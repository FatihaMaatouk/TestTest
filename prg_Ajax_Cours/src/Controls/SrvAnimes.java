package Controls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Joueur;

/**
 * Servlet implementation class SrvAnimes
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SrvAnimes" })
public class SrvAnimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvAnimes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 System.out.println("HERE");
		 String choice = request.getParameter("action");
		 
		 switch(choice)
		 {
		 	case "list":
		 			String arrayChoice = "<select name='joueur'>";
					ArrayList<Joueur> joueurs;
					try {
						joueurs = Joueur.listPlayers();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						joueurs = null;
						e.printStackTrace();
					}
							
					for(Joueur j:joueurs) {
						arrayChoice += "<option value=" + j.getId() + ">"+ j.getNom() + " " + j.getPrenom() + "</option>";
					}
					arrayChoice += "</select>";
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(arrayChoice.length());
					response.getWriter().append(arrayChoice);
		 		break;
		 	case 	"chercherUnJoueur":
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
