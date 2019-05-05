package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PanierDAO;

/**
 * Servlet implementation class MyPanier
 */
@WebServlet("/MyPanier")
public class MyPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        HttpSession session = request.getSession();
        
		String id = (String) session.getAttribute("idu");
		Map<String,String> listProd = new HashMap<>();
		String name = "Nom Prod: " ;
		String qte = "Quantite : " ;
		String s  = "";
		try {
			listProd=PanierDAO.getPanier(id, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listProd != null){
			for(Map.Entry mapentry : listProd.entrySet()){
		         s +=  name + mapentry.getKey() + " " + qte + mapentry.getValue() ;
		      }
		}
		response.getWriter().append(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
