

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserRepository;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
      
	private UserRepository user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        
        this.user = new UserRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name = (String) request.getParameter("first_name");
		String last_name = (String) request.getParameter("last_name");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		if (this.user.save(first_name, last_name, email, password)) {
			System.out.println("ok");
		}	
		else {
			System.out.println("nop");
		}
		super.displayLayout("/WEB-INF/Home/index.jsp", request, response);
	}

}
