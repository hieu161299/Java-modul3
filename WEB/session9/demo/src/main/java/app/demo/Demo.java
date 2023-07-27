package app.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Demo", value = "/demo")
public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<form action=\"\" method=\"get\">\n" +
                "  <input type=\"text\" name=\"a\">\n" +
                "  <input type=\"text\" name=\"b\">\n" +
                " <button>enter</button> </form> ");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int sum = 0;
        for (int i = a; i <= b ; i++) {
            sum += i;
        }
        writer.println("sum = " + sum);
    }
}