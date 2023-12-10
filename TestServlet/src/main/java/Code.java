
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Servlet implementation class Code
 */
@WebServlet(name = "Code", urlPatterns="/code")
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String responseFromOpenAI = callOpenAIApi();
        request.setAttribute("data", responseFromOpenAI);
        request.getRequestDispatcher("/Code.jsp").forward(request, response);
	}

	private String callOpenAIApi() {
		
		try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{"
                    + "\"model\": \"gpt-3.5-turbo\","
                    + "\"messages\": ["
                    + "{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},"
                    + "{\"role\": \"user\", \"content\": \"Who won the world series in 2020?\"},"
                    + "{\"role\": \"assistant\", \"content\": \"The Los Angeles Dodgers won the World Series in 2020.\"},"
                    + "{\"role\": \"user\", \"content\": \"Where was it played?\"}"
                    + "]"
                    + "}";
            
            connection.setRequestProperty("Content-Length", String.valueOf(jsonInputString.getBytes().length));


            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
	
	        String jsonResponse = response.toString();
	        JSONObject jsonObject = new JSONObject(jsonResponse);
	        String assistantMessage = jsonObject.getJSONArray("choices").getJSONObject(0).getString("message");
	        
	        System.out.print(assistantMessage);
	        
	        return assistantMessage;
        } catch (Exception e) {
        	  e.printStackTrace();
        }
        return null;
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
