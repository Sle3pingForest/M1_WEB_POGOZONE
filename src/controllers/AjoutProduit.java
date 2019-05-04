package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import dao.ProduitDAO;
import dao.UsersDAO;
import forms.ProduitForm;

/**
 * Servlet implementation class AjoutProduit
 */
@WebServlet("/AjoutProduit")
public class AjoutProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public static final String VUE_FORMULAIRE_AJOUT = "/produits/AjoutProduit.jsp";
    public static final String VUE_ADMIN = "/admin/Admin.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProduitForm form = new ProduitForm();
		Produit produit = form.ajouterProduit(request);
		if(produit!=null && form.getErreurs().isEmpty()) {
			try {
				ProduitDAO.insertProduit(produit);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.getServletContext().getRequestDispatcher( VUE_ADMIN ).forward( request, response );
		}
		else {
			this.getServletContext().getRequestDispatcher( VUE_FORMULAIRE_AJOUT ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
