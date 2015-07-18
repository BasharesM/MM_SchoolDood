

import java.io.IOException;
import java.util.Enumeration;

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
import models.DoodleRepository;
import models.EmailRepository;

/**
 * Servlet implementation class Doodle
 */
@WebServlet("/Doodle")
public class DoodleController extends ServletAbstract {
	private static final long serialVersionUID = 1L;
		
	private CategoryAnswerRepository answer_categories;
	private EmailRepository emails;
	private DoodleRepository doodle;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoodleController() {
        super();
        
        this.emails = new EmailRepository();
		this.answer_categories = new CategoryAnswerRepository();
		this.doodle = new DoodleRepository();
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
		
		if (request.getAttribute("message") != null) {
			System.out.println((String) request.getAttribute("message"));
			
			super.displayLayout("/WEB-INF/Doodle/index.jsp", request, response, (String) request.getAttribute("message"));			
		}
		else {
			super.displayLayout("/WEB-INF/Doodle/index.jsp", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) 
        {
        	 String paramName = (String)paramNames.nextElement();
             String[] paramValues = request.getParameterValues(paramName);
             System.out.println("+ "+paramName);
             /*
             if (paramValues.length == 1) 
             {
                 String paramValue = paramValues[0];
                 if (paramValue.length() == 0)
                	 System.out.println("No Value");
                 else
                	 System.out.println(paramValue);
             } 
             else
             {
            	 System.out.println("<ul>");
                 for(int i=0; i<paramValues.length; i++) 
                 {
                	 System.out.println("<li>" + paramValues[i] + "</li>");
                 }
                 System.out.println("</ul>");
             }
  */
        }
        int status = 1;
        String checkbox = (String) request.getParameter("status");
        
        if (checkbox == null || checkbox.compareTo("off") == 0) {
        	status = 0;
        }
        
        if (this.doodle.save(super.getCurrentUser(request, response).getUid(), Integer.parseInt(request.getParameter("caid")), status, request.getParameter("question"))) {
			request.setAttribute("message", "Doodle ajouté !");
			
			this.doGet(request, response);
        }
        else {
        	super.displayLayout("/WEB-INF/Doodle/index.jsp", request, response, "Impossible d'ajouté le doodle ! :(");
        }
	}

}
