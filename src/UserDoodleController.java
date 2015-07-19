

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserDoodleRepository;

/**
 * Servlet implementation class UserDoodleController
 */
@WebServlet("/UserDoodleController")
public class UserDoodleController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
       
	private UserDoodleRepository user_doodle;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDoodleController() {
        super();
        
        this.user_doodle = new UserDoodleRepository();
        // TODO Auto-generated constructor stub
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
		int did = Integer.parseInt(request.getParameter("did"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		int daid = Integer.parseInt(request.getParameter("daid"));
		String name = request.getParameter("name"); 
		
		if (this.user_doodle.save(did, aid, daid, name)) {
			super.displayLayout("/WEB-INF/Home/index.jsp", request, response, "Votre participation est enregistrée!");
			return;
		}
		else {
			super.displayLayout("/WEB-INF/Home/index.jsp", request, response, "Erreur lors de votre inscription.");
			return;
		}
	}

}
