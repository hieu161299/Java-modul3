package app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscount", value = "/ProductDiscount")
public class ProductDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        double listedPrice = Double.parseDouble(request.getParameter("price"));
        double discountPercent = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = (listedPrice * discountPercent * 0.01);

        writer.println("<p>" + "Discount Amount : " + discountAmount + "</p>" );
        writer.println("Discount Price : " + (listedPrice - discountAmount));
    }
}