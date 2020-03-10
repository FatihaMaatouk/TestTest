package Controls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cities;
import model.Countries;
import model.Degrees;
import model.Department;
import model.Member;
import model.Region;

/**
 * Servlet implementation class SrvAnimes
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SrvDetails" })
public class SrvDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String choice = request.getParameter("action");
		 System.out.println(choice);
		 switch(choice)
		 {
		 	case "browse":
		 			String answer = Degrees.findDetails(request.getParameter("nom"));
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(answer.length());
					response.getWriter().append(answer);
		 		break;
		 	default:
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
