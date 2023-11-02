

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
 * Servlet implementation class BookCRUDServlet
 */
@WebServlet("/BookCRUDServlet")
public class BookCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
    	String jdbcUsername = "root";
    	String jdbcPassword = "sushil0722";
    	String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        String action = request.getParameter("action");
        
        try {
        	Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			if (action != null) {
				if (action.equals("add")) {
		            String bookName = request.getParameter("name");
		            double bookPrice = Double.parseDouble(request.getParameter("price"));
		            
		                PreparedStatement statement = connection.prepareStatement("INSERT INTO books (bname, price) VALUES (?, ?)");
		                statement.setString(1, bookName);
		                statement.setDouble(2, bookPrice);
		                statement.executeUpdate();
		                out.println("<h3>Book added successfully!</h3>");
		                
		                request.setAttribute("message", "Successfully Added!");
		                request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
		        } else if (action.equals("update")) {
		            int bookId = Integer.parseInt(request.getParameter("id"));
		            String bookName = request.getParameter("name");
		            double bookPrice = Double.parseDouble(request.getParameter("price"));

		                PreparedStatement statement = connection.prepareStatement("UPDATE books SET bname=?,price=? WHERE bno=?");
		                statement.setString(1, bookName);
		                statement.setDouble(2, bookPrice);
		                statement.setInt(3, bookId);
		                statement.executeUpdate();
		                out.println("<h3>Book updated successfully!</h3>");
		                
		                request.setAttribute("message", "Successfully updated!");
		                request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
		           
		        } else if (action.equals("delete")) {
		            int bookId = Integer.parseInt(request.getParameter("id"));

		                PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE bno=?");
		                statement.setInt(1, bookId);
		                statement.executeUpdate();
		                out.println("<h3>Book deleted successfully!</h3>");
		                
		                request.setAttribute("message", "Successfully deleted!");
		                request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);

		        } else if (action.equals("list")) {
		        		PreparedStatement statement = connection.prepareStatement("SELECT * FROM books");
		                ResultSet rs = statement.executeQuery();

		                out.println("<h2>Book List</h2>");
		                out.println("<table border='1'>");
		                out.println("<tr><th>Book Id</th><th>Book Name</th><th>Book Price</th></tr>");

		                while (rs.next()) {
		                    int bookId = rs.getInt("bno");
		                    String bookName = rs.getString("bname");
		                    double bookPrice = rs.getDouble("price");
		                    out.println("<tr><td>" + bookId + "</td><td>" + bookName + "</td><td>" + bookPrice + "</td></tr>");
		                }

		                out.println("</table>");
		                
//		                request.setAttribute("message", "Success!");
//		                request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
		        }
			}else {
				request.setAttribute("message", "Action is null!");
	            request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
			}
        } catch (SQLException e) {
        	request.setAttribute("message", "Something went worng with sql!!");
            request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	request.setAttribute("message", "Class No found");
            request.getRequestDispatcher("/BookCRUD.jsp").forward(request, response);
			e.printStackTrace();
		}

        out.println("<br><a href='BookCRUD.jsp'>Go Back</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
