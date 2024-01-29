package com.example.hw24_servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "greetingServlet", value = "/greet")
public class GreetingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (name != null && !name.isEmpty()) {
            out.println("<html><body>");
            out.println("<h2>Hello, " + name + "!</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>You should specify the parameter 'name' in URL</h2>");
            out.println("</body></html>");
        }
    }
}
