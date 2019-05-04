package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

/**
 * Servlet implementation class SupprimerUser
 */
@WebServlet("/SupprimerUser")
public class SupprimerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_NAME          = "listename";
    public static final String VUE_USERS        = "/admin/ListUsers.jsp";

	private static Map<String ,String> listUsersName= new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("idUser") + ": " + request.getParameter("nameUser") +": " + request.getParameter("Supprimer")  + ":" + request.getParameter("Modifier") );
		
		try {
			if(request.getParameter("Supprimer") !=null){
				UsersDAO.deleteUser(request.getParameter("idUser"), request.getParameter("nameUser"));
			}
			if(request.getParameter("Admin") !=null){
				UsersDAO.settingAdmin(request.getParameter("idUser"));
			}
			if(request.getParameter("Modifier") !=null){
				UsersDAO.settingName(request.getParameter("idUser"), request.getParameter("nameUser"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			listUsersName = UsersDAO.selectUsersIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}

        request.setAttribute(ATT_NAME, listUsersName);
		this.getServletContext().getRequestDispatcher(VUE_USERS).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
