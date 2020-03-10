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
		 System.out.println(choice);
		 switch(choice)
		 {
		 	case "list":
		 			String arrayChoice = "<select name='joueur' id='player' onchange='findPlayerInfos(this.value)'>";
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
		 	case 	"search":
		 		Joueur joueur;
				try {
					joueur = Joueur.searchPlayer(request.getParameter("player"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					joueur = null;
				}
				if(joueur != null) {
					String answer = joueur.getId().toString() + "/"+joueur.getNom() + "/"+ joueur.getPrenom()+"/"+joueur.getGenre();
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(answer.length());
					response.getWriter().append(answer);
				}
		 		break;
		 	case"add":
				try {
					if(Joueur.addPlayer(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("genre"))) {
						try {
							joueurs = Joueur.listPlayers();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							joueurs = null;
							e.printStackTrace();
						}
						String tabJoueurs = "<table style=\"background-color:#decba4;width:250px\" >\r\n" + 
								"						<tr>\r\n" + 
								"							<td>ID</td>\r\n" + 
								"							<td>Nom</td>\r\n" + 
								"							<td>Prenom</td>\r\n" + 
								"							<td>Genre</td>\r\n" + 
								"						</tr>\r\n";
						for(Joueur j:joueurs) {
							tabJoueurs += "<tr><td>" + j.getId() + "</td><td>"+ j.getNom() + "</td><td>" + j.getPrenom() + "</td><td>"+j.getGenre()+"</td></tr>;";
						}
						tabJoueurs += "</table>";
						response.setContentType("text/html");
						response.setHeader("Cache-Control", "no-cache");
						response.setCharacterEncoding("UTF-8");
						response.setContentLength(tabJoueurs.length());
						response.getWriter().append(tabJoueurs);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
