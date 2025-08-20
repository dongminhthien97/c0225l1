package controller;

import model.Caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value= "/form")
public class CaculatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");


        double result = 0;
        try {
            result = Caculator.calculate(firstOperand, secondOperand, operator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
}
