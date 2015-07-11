

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served adsdt: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);  

		try {

		    Class.forName( "com.mysql.jdbc.Driver" );
		   
		    /* Connexion à la base de données */
		    String url = "jdbc:mysql://localhost:3306/school_doodle";
		    String utilisateur = "root";
		    String motDePasse = "root";
		    java.sql.Connection connexion = null;
		    try {
		        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

		        String sql = "select * from users where first_name=? and password=?;" ;
		        		
		        PreparedStatement preparedStatement =
		                (PreparedStatement) connexion.prepareStatement(sql);

		        preparedStatement.setString(1, username);
		        preparedStatement.setString(2, DigestUtils.sha1Hex(password));

		        ResultSet user = preparedStatement.executeQuery();
		        		
		        if (user.next()){
		        	
		        	session.setAttribute("user", user);
		    		session.setAttribute("logged", true);
		    		
		    		this.getServletContext().getRequestDispatcher("/WEB-INF/Login/index.jsp").forward(request, response);
		        }
		        else {
		        	this.getServletContext().getRequestDispatcher("/WEB-INF/Home/index.jsp").forward(request, response);
		        }	

		    } catch ( SQLException e ) {

		        System.out.println("cerise !! ");

		        /* Gérer les éventuelles erreurs ici */
		    } finally {
		        if ( connexion != null )
		            try {
		                connexion.close();
		            } catch ( SQLException ignore ) {

				        System.out.println("poire ! ");

		            }
		    }

		} catch ( ClassNotFoundException e ) {

	        System.out.println("pomme! ");


		}
	}

}
