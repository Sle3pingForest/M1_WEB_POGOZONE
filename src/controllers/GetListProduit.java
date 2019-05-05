package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Produit;
import dao.ProduitDAO;

/**
 * Servlet implementation class GetListProduit
 */
@WebServlet("/GetListProduit")
public class GetListProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_NAME        = "produits";
	public static final String ATT_ADMIN       = "admin";
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
		
		HttpServletRequest req = (HttpServletRequest) request;
       

        HttpSession session = req.getSession();

        //System.out.println(session.getAttribute(ATT_ADMIN));
        if ((boolean) session.getAttribute(ATT_ADMIN)) {
            request.setAttribute( "admin", true );
        }
        else{
        	request.setAttribute( "user", true );
        }

		
		try {
			produits = ProduitDAO.listProduit();
			
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute(ATT_NAME, produits);
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
