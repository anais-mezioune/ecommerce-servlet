package com.formation.servlet.produit;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import com.formation.models.Produit;
import com.formation.services.ClientService;
import com.formation.services.ProduitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/produit/create")
public class Create extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String strPrixUnitaire = request.getParameter("prixUnitaire");
        Float prixUnitaire = Float.parseFloat(strPrixUnitaire);

        try {
            Produit produit = ProduitService.creerProduit(nom, prixUnitaire);
            ProduitService.enregistrer(produit);
        } catch (MetierException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/");
    }

}
