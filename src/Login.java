

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import models.UserRepository;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends ServletAbstract {
	private static final long serialVersionUID = 1L;
       
	private UserRepository user; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
        this.user = new UserRepository();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served adsdt: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		
		User user = this.user.login(username, password);
		
		if (user != null){
			session.setAttribute("user", user);	
			session.setAttribute("logged", true);
			super.displayLayout("/WEB-INF/Login/index.jsp", request, response);
		}
		else {
			super.displayLayout("/WEB-INF/Home/index.jsp", request, response, "loginError");
		}	
	}

}
