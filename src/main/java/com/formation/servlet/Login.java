package com.formation.servlet;

import com.formation.models.Client;
import com.formation.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client client = ClientService.getClientByEmail(email);
        if (client == null || !client.motDePasse.equals(password)) {
            request.setAttribute ("error", "Utilisateur inconnu ou mot de passe incorect");
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("email", client.email);
            response.sendRedirect("/");
        }
    }
}
