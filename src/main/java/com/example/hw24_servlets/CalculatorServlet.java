package com.example.hw24_servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "calculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operationType = request.getParameter("op");
        String number1 = request.getParameter("n1");
        String number2 = request.getParameter("n2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ((operationType != null && !operationType.isEmpty())
                && (number1 != null && !number1.isEmpty())
                && (number2 != null && !number2.isEmpty())) {
            out.println("<html><body>");
            if (operationType.equals("add")) {
                out.println("<h2>Operation = add, n1 + n2 = </h2>");
                out.println("<h2>" + number1 + " + " + number2 + " = " + (Integer.parseInt(number1) + Integer.parseInt(number2)) + "</h2>");
            } else if (operationType.equals("sub")) {
                out.println("<h2>Operation = subtract, n1 - n2 = </h2>");
                out.println("<h2>" + number1 + " - " + number2 + " = " + (Integer.parseInt(number1) - Integer.parseInt(number2)) + "</h2>");
            } else if (operationType.equals("multiply")) {
                out.println("<h2>Operation = multiply, n1 * n2 = </h2>");
                out.println("<h2>" + number1 + " * " + number2 + " = " + (Integer.parseInt(number1) * Integer.parseInt(number2)) + "</h2>");
            } else if (operationType.equals("divide")) {
                out.println("<h2>Operation = divide, n1 / n2 = </h2>");
                out.println("<h2>" + number1 + " / " + number2 + " = " + (Double.parseDouble(number1) / Double.parseDouble(number2)) + "</h2>");
            }
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>You should specify the parameters 'op', 'n1' and 'n2' in URL</h2>");
            out.println("</body></html>");
        }
    }
}