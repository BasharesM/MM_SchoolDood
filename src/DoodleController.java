

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.CategoryAnswer;
import entities.CategoryAnswers;
import entities.Emails;
import entities.User;
import models.CategoryAnswerRepository;
import models.EmailRepository;

/**
 * Servlet implementation class Doodle
 */
@WebServlet("/Doodle")
public class DoodleController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
		
	private CategoryAnswerRepository answer_categories;
	private EmailRepository emails;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoodleController() {
        super();
        
        this.emails = new EmailRepository();
		this.answer_categories = new CategoryAnswerRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!super.accessControl(request, response)) {
			return;
		}
		
		CategoryAnswers categories = this.answer_categories.findAll();
		Emails emails = this.emails.findAllByUserId(super.getCurrentUser(request, response).getUid());
		
		request.setAttribute("categories", categories);
		request.setAttribute("emails", emails);
		
		super.displayLayout("/WEB-INF/Doodle/index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
