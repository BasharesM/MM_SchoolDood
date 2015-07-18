

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
public class Doodle extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	private CategoryAnswerRepository answer_categories;
	private EmailRepository emails;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doodle() {
        super();
        
        this.emails = new EmailRepository();
		this.answer_categories = new CategoryAnswerRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		if (session.getAttribute("logged") == null) {

			this.getServletContext().getRequestDispatcher("/WEB-INF/Home/index.jsp").forward(request, response);
			return;
		}
		CategoryAnswers categories = this.answer_categories.findAll();
		Emails emails = this.emails.findAllById(user.getUid());
		
		request.setAttribute("categories", categories);
		request.setAttribute("emails", emails);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Doodle/index.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
