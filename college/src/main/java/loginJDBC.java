

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
 * Servlet implementation class loginJDBC
 */
@WebServlet("/loginJDBC")
public class loginJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginJDBC() {
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
    	String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
    	String jdbcUsername = "root";
    	String jdbcPassword = "sushil0722";
    	String jdbcDriver = "com.mysql.cj.jdbc.Driver";

	    String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
        try {
        	Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	request.setAttribute("name", resultSet.getString("name"));
            	request.setAttribute("email", resultSet.getString("email"));
            	request.setAttribute("mobile", resultSet.getString("mobile"));
            	request.getRequestDispatcher("/welcomeJDBC.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Invalid username or password.");
                request.getRequestDispatcher("/welcomeJDBC.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        
	}

}
