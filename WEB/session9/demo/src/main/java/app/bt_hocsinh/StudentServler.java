package app.bt_hocsinh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServler", value = "/StudentServler")
public class StudentServler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        StudentManagement stdList = new StudentManagement();
        for (int i = 0; i < stdList.getAll().size(); i++) {
            writer.println("<p>" + stdList.getAll().get(i).toString() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}