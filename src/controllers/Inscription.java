package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utilisateur;
import dao.UsersDAO;
import forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE_LOGIN = "/LogIn.jsp";
    public static final String VUE_INSCRIPTION = "/Inscription.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
		
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */        
    	
    	InscriptionForm form = new InscriptionForm();
		
        Utilisateur utilisateur = form.inscrireUtilisateur( request );
        try {
        	if(utilisateur != null && form.getErreurs().isEmpty()){
        		request.setAttribute( ATT_FORM, form );
                request.setAttribute( ATT_USER, utilisateur );UsersDAO.insertUser(utilisateur.getNom(), utilisateur.getMotDePasse(),utilisateur.getDateNaissance(), utilisateur.getEmail(), utilisateur.getVille(), utilisateur.getCode());
              	this.getServletContext().getRequestDispatcher( VUE_LOGIN ).forward( request, response );
        		
        	}
        	else{

            	this.getServletContext().getRequestDispatcher( VUE_INSCRIPTION ).forward( request, response );
        	}
        		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


        doGet(request,response);
    }

    

}
