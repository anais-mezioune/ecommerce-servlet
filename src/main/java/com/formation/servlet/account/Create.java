package com.formation.servlet.account;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import com.formation.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/account/create")
public class Create extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/account/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");

        try {
            Client client = ClientService.creerClient(email, password, lastName, firstName);
            ClientService.enregistrer(client);
            response.sendRedirect("/login.jsp");

        } catch (MetierException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext().getRequestDispatcher("/account/create.jsp").forward(request, response);
        }
    }
}
