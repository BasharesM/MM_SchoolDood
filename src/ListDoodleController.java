

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Emails;
import models.DoodleRepository;
import models.AnswerRepository;
import entities.Doodles;
import entities.AnswerResults;
import entities.Answers;

/**
 * Servlet implementation class ListDoodleController
 */
@WebServlet("/ListDoodleController")
public class ListDoodleController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
	
	private DoodleRepository doodleRepository;
	private AnswerRepository answerRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDoodleController() {
        super();
        // TODO Auto-generated constructor stub
        
        this.doodleRepository = new DoodleRepository();
        this.answerRepository = new AnswerRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());		
		
		if(request.getParameter("did") != null) {
			boolean author;
			try {
				author = this.doodleRepository.checkIfAuthor(Integer.parseInt(request.getParameter("did")), super.getCurrentUser(request, response).getUid());
				
				if(author) {
					AnswerResults answers = this.answerRepository.getAllByDid(Integer.parseInt(request.getParameter("did")));
					System.out.println(answers.size());
					request.setAttribute("answers", answers);
					
					super.displayLayout("/WEB-INF/Doodle/stats.jsp", request, response);
					return;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		Doodles doodles = this.doodleRepository.findAllByUserId(super.getCurrentUser(request, response).getUid());
		request.setAttribute("doodles", doodles);
		
		super.displayLayout("/WEB-INF/Doodle/list.jsp", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
