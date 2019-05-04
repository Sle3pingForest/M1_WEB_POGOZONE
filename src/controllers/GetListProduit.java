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
 * Servlet implementation class GetListProduit
 */
@WebServlet("/GetListProduit")
public class GetListProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_NAME          = "produits";
	private static ArrayList<Produit> produits = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuilder sb = new StringBuilder();
		try {
			produits = ProduitDAO.listProduit();
			
			for(Produit p : produits) {
				sb.append(p.getMarque()).append("</br>");
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute(ATT_NAME, produits);
		request.setAttribute("sb",sb.toString() );
	    this.getServletContext().getRequestDispatcher( "/produits/ListeProduits.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
