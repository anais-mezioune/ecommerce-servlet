package com.formation.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "")
public class Accueil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sessionEmail = (String) request.getSession().getAttribute("email");
        if (sessionEmail == null || sessionEmail.isEmpty()) {
            response.sendRedirect("/login.jsp");
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }

    }

}
