package app.controller;

import app.model.User;
import app.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "login":
                showLoginForm(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "register":
                showRegisterForm(request, response);
                break;
            case "information":
                showInformation(request ,response);
                break;
        }
    }

    private void showInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*int idUser = Integer.parseInt(request.getParameter("idUser"));
        User user = userService.getUser(idUser);*/

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("idUser");

        User user = userService.getUser(id);
        request.setAttribute("user" , user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/information.jsp");
        dispatcher.forward(request , response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/register.jsp");
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        dispatcher.forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");

            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "login":
                login(request, response);
                break;
            case "register":
                register(request , response);
                break;
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(id , username , password , "user");

        userService.add(user);
        response.sendRedirect("/user?action=login");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.checkUser(username , password)){
            HttpSession session = request.getSession();
            session.setAttribute("idUser" , userService.getIdUser(username , password) );
            response.sendRedirect("/students?action=showAll");
        }else {
            response.sendRedirect("/user?action=login&tb=loi");
        }
    }
}