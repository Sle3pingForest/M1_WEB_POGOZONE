package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;

/**
 * Servlet implementation class RequestBDD
 */
@WebServlet("/ListUsers")
public class GetListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> listUsers = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder users= new StringBuilder("");
        String head = "List all users" ;  
		try {
			listUsers = UsersDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		users.append(head +"\n");
		for(String s: listUsers){
			users.append(s+'\n');
		}

        System.out.println(users.toString());
        request.setAttribute("lu", users.toString());
        request.getRequestDispatcher( "/WEB-INF/ListUsers.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
