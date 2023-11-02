

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterDbServlet
 */
@WebServlet("/RegisterDbServlet")
public class RegisterDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDbServlet() {
        super();
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
		
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        
    	String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
    	String jdbcUsername = "root";
    	String jdbcPassword = "sushil0722";
    	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    	String INSERT_USERS_SQL = "INSERT INTO user (name, password, email, mobile) VALUES (?, ?, ?, ?)";
    	String SELECT_USER_BY_NAME = "select name, password, email, mobile from user where name =?";
    	
    	Connection connection = null;
    	
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	
    	try {
			Class.forName(jdbcDriver);
			
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, mobile);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_USER_BY_NAME);
			preparedStatement1.setString(1, name);
			ResultSet rs = preparedStatement1.executeQuery();

			out.println("<h1>Registred user details</h1>");
			while (rs.next()) {
//				out.println("<p>Id: " + rs.getString("id") + "</p>");
				out.println("<p>Name: " + rs.getString("name") + "</p>");
				out.println("<p>Password: " + rs.getString("password") + "</p>");
				out.println("<p>Email: " + rs.getString("email") + "</p>");
				out.println("<p>Mobile No.: " + rs.getString("mobile") + "</p>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		doGet(request, response);
	}

}
