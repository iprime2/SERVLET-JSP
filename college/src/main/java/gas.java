

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
 * Servlet implementation class gas
 */
@WebServlet("/gas")
public class gas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gas() {
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
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String qty = request.getParameter("qty");
        
        if(name == null || phone == null || address == null || qty == null) {
        	request.setAttribute("error", "Field is missing");
        	request.getRequestDispatcher("/gas.jsp").forward(request, response);
        }
        
        String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
    	String jdbcUsername = "root";
    	String jdbcPassword = "sushil0722";
    	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    	String INSERT_GAS_SQL = "INSERT INTO gas (name, phone, address, qty) VALUES (?, ?, ?, ?)";
    	String SELECT_GAS = "SELECT * FROM gas WHERE name = ?";
    	
    	Connection connection = null;
    	
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	
    	try {
			Class.forName(jdbcDriver);
			
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GAS_SQL);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, qty);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_GAS);
			preparedStatement1.setString(1, name);
			ResultSet rs = preparedStatement1.executeQuery();

			out.println("<h1>Successfully Order Registred</h1>");
			out.println("<h1>Registred order details</h1>");
			while (rs.next()) {
//				out.println("<p>Id: " + rs.getInt("id") + "</p>");
				out.println("<p>Name: " + rs.getString("name") + "</p>");
				out.println("<p>Mobile: " + rs.getString("phone") + "</p>");
				out.println("<p>address: " + rs.getString("address") + "</p>");
				out.println("<p>Qty.: " + rs.getString("qty") + "</p>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			request.getRequestDispatcher("/gas.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			request.getRequestDispatcher("/gas.jsp").forward(request, response);
		}
	}

}
