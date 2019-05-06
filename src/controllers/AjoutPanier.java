package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Panier;
import bean.Produit;
import dao.PanierDAO;
import dao.ProduitDAO;

/**
 * Servlet implementation class AjoutPanier
 */
// @WebServlet("/AjoutPanier")
public class AjoutPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Cookie cookie = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

        HttpSession session = request.getSession();
        
		Cookie[] listeCookies = request.getCookies();
		System.out.println(listeCookies.length);
		Panier panier = null;
		for (Cookie c : listeCookies) {
			System.out.println("id: "+ c.getName() + " **" + session.getAttribute("idu"));
			if(c.getName().equals(session.getAttribute("idu")) && request.getParameter("idProduit") !=null  &&  request.getParameter("type") !=null){
				panier = new Panier(c.getName(), c);
				String id_prod = request.getParameter("idProduit");
				String nom_prod = request.getParameter("type");
				panier.ajoutProduit(id_prod, 1);
				try {
					PanierDAO.insertPanier(c.getName(), session.getAttribute("idu").toString(),id_prod,nom_prod, 1);
					ProduitDAO.modifierStock(Integer.parseInt(id_prod));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		 this.getServletContext().getRequestDispatcher( "/user/User.jsp" ).forward( request, response );
		 //response.sendRedirect("/produits/ListeProduits.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
