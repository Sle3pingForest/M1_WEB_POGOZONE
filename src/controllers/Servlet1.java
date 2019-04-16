package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int trois = 3;
	private int deux = 2;
    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*int res = add(trois,deux);
		request.setAttribute("Res", ""+ res );
		request.setAttribute("Droite", "" +getDroit());
		request.setAttribute("Gauche", "" +getGauche());
		
		response.getWriter().append("Resultat de la somme = "+res);*/
		Cookie[] listeCookies = request.getCookies();
        String name = "Name : ";
        String value = "\n Valeur :";	
        if(listeCookies!=null){
	        for(Cookie c : listeCookies){
	        		name += c.getName();
	        		value += c.getValue();
	        }
        }
			request.setAttribute("cookie",name +"</br>" + value);
			request.getRequestDispatcher("Cookie.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
   private static String getCookieValue( HttpServletRequest request) {
        Cookie[] listeCookies = request.getCookies();
        String name = "Name : ";
        String value = "Valeur :";	
        if(listeCookies!=null){
	        for(int i = 0 ; i< listeCookies.length; i++){
	        		name = listeCookies [i].getName() + "\n";
	        		value = listeCookies [i].getValue() +"\n";
	        }
        }
        return name + value;
    }
	
	protected int add(int a, int b){
		return a+b;
	}
	
	public int getDroit(){
		return trois;
	}
	
	public int getGauche(){
		return deux;
	}

}
