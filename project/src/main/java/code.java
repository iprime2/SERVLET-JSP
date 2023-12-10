

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class code
 */
@WebServlet("/code")
public class code extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String jsonInputString = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": ["
                + "{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},"
                + "{\"role\": \"user\", \"content\": \"Who won the world series in 2020?\"},"
                + "{\"role\": \"assistant\", \"content\": \"The Los Angeles Dodgers won the World Series in 2020.\"},"
                + "{\"role\": \"user\", \"content\": \"Where was it played?\"}"
                + "]"
                + "}";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
