package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet Filter implementation class LoginFilter
 */
// @WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public static final String ACCES_PUBLIC = "/AccesPublic.jsp";
	public static final String ACCES_USER = "/user/User.jsp";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String ATT_ADMIN = "admin";
	public static final String ATT_USER = "user";
	public static final String ACCES_CONNEXION = "/LogIn.jsp";

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		/* Récupération de la session depuis la requête */
		HttpSession session = req.getSession();

		/**
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */

		/* Affichage de la page restreinte */
		System.out.println(session.getAttribute(ATT_ADMIN));
		if (session.getAttribute(ATT_SESSION_USER) != null && (boolean) session.getAttribute(ATT_ADMIN)) {
			chain.doFilter(req, res);
		} 
		else {
			System.out.println(req.getContextPath());
			res.sendRedirect(req.getContextPath() + ACCES_CONNEXION);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
