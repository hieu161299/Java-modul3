package app.log_in;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogIn", value = "/LogIn")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <form action=\"/LogIn\" method=\"post\">\n" +
                "      <input type=\"text\" placeholder=\"tên đăng nhập\" name=\"userName\">\n" +
                "      <input type=\"text\" placeholder=\"mật khẩu\" name=\"pwd\">\n" +
                "      <button>Đăng nhập</button>\n"  +
                "  </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("pwd");
        if (userName.equals("admin") && passWord.equals("admin")){
            writer.println("Hello " + userName);
        }else if (userName.equals("user") && passWord.equals("123")){
            writer.println("Hello " + userName);
        }else {
            writer.println("Account not found" );
        }
    }
}