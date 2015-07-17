

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.CategoryAnswer;
import entities.CategoryAnswers;
import models.CategoryAnswerRepository;

/**
 * Servlet implementation class Doodle
 */
@WebServlet("/Doodle")
public class Doodle extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	private CategoryAnswerRepository answer_categories;
				
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doodle() {
        super();
        
		this.answer_categories = new CategoryAnswerRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryAnswers categories = this.answer_categories.findAll();
		
		request.setAttribute("categories", categories);
		
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
