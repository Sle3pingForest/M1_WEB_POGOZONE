package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utilisateur;
import dao.UsersDAO;
import forms.LogInForm;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class LogIn extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_USERS             = "/WEB-INF/User.jsp";
    public static final String VUE_ADMIN            = "/admin/Admin.jsp";
    public static final String VUE_LOGIN            = "/LogIn.jsp";
    public static Map<String,String> listAdmin  = null;
    public static Map<String,String> listUsers  = null;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
    	LogInForm form = new LogInForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur(request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } 
        else {
            session.setAttribute( ATT_SESSION_USER, null );
        }
        

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
        
        System.out.println(utilisateur.getEmail());
       
        if(session.getAttribute(ATT_SESSION_USER) != null 
        		&& (isAdmin(utilisateur.getEmail(), utilisateur.getMotDePasse())
        		|| 	isUsers(utilisateur.getEmail(),utilisateur.getMotDePasse()))){
        	 if(isAdmin(utilisateur.getEmail(), utilisateur.getMotDePasse())){
                 this.getServletContext().getRequestDispatcher(VUE_ADMIN).forward( request, response );
             }
        	 else if(isUsers(utilisateur.getEmail(),utilisateur.getMotDePasse())){
                 this.getServletContext().getRequestDispatcher(VUE_USERS).forward( request, response );
             }
        }
        else{
            this.getServletContext().getRequestDispatcher( VUE_LOGIN).forward( request, response );
        }

    }
    
   
    
    private boolean isAdmin(String mail, String pass){
    	boolean is_admin = false;
    	boolean correct_pass = false;
    	try {
			listAdmin = UsersDAO.selectAdmin();
			System.out.println(listAdmin.get(mail));
			if(listAdmin.containsKey(mail) && listAdmin.get(mail).equals(pass)){
	    		is_admin = true;
	    		correct_pass = true;
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return is_admin & correct_pass;
    	
    }
    
    
    private boolean isUsers(String mail, String pass){
    	boolean is_user = false;
    	boolean correct_pass = false;
    	try {
			listUsers = UsersDAO.selectUsers();
			System.out.println(listUsers.get(mail));
			if(listUsers.containsKey(mail) && listUsers.get(mail).equals(pass)){
	    		is_user = true;
	    		correct_pass = true;
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return is_user & correct_pass;
    	
    }

}
