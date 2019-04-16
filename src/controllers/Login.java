package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(name.equals("admin") && password.equals("admin123")){  
	        String ad = "Welcome Admin, "+name;  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",name);  
	        request.getRequestDispatcher( "/WEB-INF/Admin.jsp" ).forward( request, response );
            
        }  
        else if(password.equals("user123")){
	        String use = "Welcome User, "+name;  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",use);  
	        request.getRequestDispatcher( "/WEB-INF/User.jsp" ).forward( request, response );
        }
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("/LogIn.jsp").include(request, response);  
        }  
        out.close();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
