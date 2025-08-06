package com.example.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="HttpServlet", value ="/display-discount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/display-discount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tính toán
        // lấy dữ liệu
        double Price = Float.parseFloat(req.getParameter("Price"));
        double Discount = Float.parseFloat(req.getParameter("Discount"));
        double Amount = Price * Discount * 0.01;
        // gửi dữ liệu sang file jsp để hiển thị
        req.setAttribute("Price", Price);
        req.setAttribute("Discount", Discount);
        req.setAttribute("Amount", Amount);
        req.getRequestDispatcher("/display-discount.jsp").forward(req,resp);
    }
}
