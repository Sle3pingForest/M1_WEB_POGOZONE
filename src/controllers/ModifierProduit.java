package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import dao.ProduitDAO;

/**
 * Servlet implementation class ModifierProduit
 */
@WebServlet("/ModifierProduit")
public class ModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	public static final String VUE_PRODUIT = "/produits/ListeProduits.jsp";
	private static ArrayList<Produit> produits = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
		try {
			String type_produit = request.getParameter("type");
			String marque = request.getParameter("marque");
			int id = Integer.parseInt(request.getParameter("idProduit"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			if(request.getParameter("Supprimer")!=null) {
				ProduitDAO.supprProduit(type_produit, marque);
			}
			if (request.getParameter("Modifier")!=null) {
				ProduitDAO.modifierProduit(id, type_produit, marque,stock);
			}
			
			produits = ProduitDAO.listProduit();
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		request.setAttribute("produits", produits);
		this.getServletContext().getRequestDispatcher( "/produits/ListeProduits.jsp" ).forward( request, response );
		//this.getServletContext().getRequestDispatcher(VUE_PRODUIT).forward( request, response );
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
