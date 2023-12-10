

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name");
		String pass1=req.getParameter("password");
		String age=req.getParameter("age");
		String gender=req.getParameter("gender");
		String lang=req.getParameter("languages");
		String msg=req.getParameter("msg");
		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
	    	String jdbcUsername = "root";
	    	String jdbcPassword = "sushil0722";
	    	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
			
	    	Class.forName(jdbcDriver);
	     	Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement ps=con.prepareStatement("Insert into web(name,password,gender,age,language,message) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass1);
			ps.setString(3,gender);
			ps.setString(4,age);
			ps.setString(5,lang);
			ps.setString(6,msg);
			
			out.println("Data Inserted successfully");
			out.println("<br>");
			out.println("<br>");
			ps.executeUpdate();

			ResultSet rs = null;
			PreparedStatement ps2=con.prepareStatement("Select * From web where name=?");
			ps2.setString(1, name);
            rs = ps2.executeQuery();
         
            while(rs.next()){
                out.println("Hello:"+rs.getString("name"));
                out.println("<br>");
                out.println("Password:"+rs.getString("password"));
                out.println("<br>");
                out.println("Gender:"+rs.getString("gender"));
                out.println("<br>");
                out.println("Age:"+rs.getString("age"));
                out.println("<br>");
                out.println("Language:"+rs.getString("language"));
                out.println("<br>");
                out.println("Message:"+rs.getString("message"));
                out.println("<br>");
                
            }            
           ps.close();
           con.close();   
		
		}
		catch(Exception e)
		{
			out.println("<br>");
			out.println("Error in Database");
		}
	}

}
