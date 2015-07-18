

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.CategoryAnswers;
import entities.Emails;
import entities.User;
import models.EmailRepository;

/**
 * Servlet implementation class Email
 */
@WebServlet("/Email")
public class EmailController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
       
	private EmailRepository email;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailController() {
        super();
        // TODO Auto-generated constructor stub
        
        this.email = new EmailRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Emails emails = this.email.findAllByUserId(super.getCurrentUser(request, response).getUid());
		
		request.setAttribute("emails", emails);
		
		// Arrivée depuis le bouton 'Ajouter un email'
		super.displayLayout("/WEB-INF/Email/index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User user =  super.getCurrentUser(request, response);
		
		String email = request.getParameter("email");
		
		if(this.email.insert(user.getUid(), email)) {
			this.doGet(request, response);
		}
	}

}
