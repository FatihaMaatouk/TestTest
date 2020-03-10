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
import model.Department;
import model.Region;

/**
 * Servlet implementation class SrvAnimes
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SrvVilles" })
public class SrvVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvVilles() {
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
		 	case "choixPays":
		 			ArrayList<Countries> countries = Countries.listCountries();
		 			String answer = "<select id='chosenCountry' name='country' onchange='showRegions(this.value)' onload='showRegions(this.value)'>";
		 			
		 			for(Countries c :countries) {
		 				answer += "<option value="+ c.getId() +">"+c.getCode()+ " "+c.getNom()+"</option>";
		 			}
		 			answer += "</select>";
		 			answer += "<option></option>";
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(answer.length());
					response.getWriter().append(answer);
		 		break;
		 	case 	"choixRegion":
		 			String region = request.getParameter("region");
		 			ArrayList<Region> regions = Region.listRegionsCountries(region);
		 			answer = "<select id='chosenRegion' name='region' onchange='showDept(this.value)' onload='showDept(this.value)'>";
		 			answer += "<option></option>";
		 			for(Region c :regions) {
		 				answer += "<option value='"+ c.getId() +"'>"+c.getCode()+ " "+c.getNom()+"</option>";
		 			}
		 			answer += "</select>";
		 			System.out.println(region);
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(answer.length());
					response.getWriter().append(answer);
		 		break;
		 	case"choixDept":
			 		String department = request.getParameter("dept");
		 			ArrayList<Department> deps = Department.listRegionDepartments(department);
		 			answer = "<select id='chosenDep' name='departement' onchange='showCities(this.value)' onload='showCities(this.value)'>";
		 			answer += "<option></option>";
		 			for(Department c :deps) {
		 				answer += "<option value='"+ c.getId() +"'>"+c.getCode()+ " "+c.getNom()+"</option>";
		 			}
		 			answer += "</select>";
		 			System.out.println(answer);
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(answer.length());
					response.getWriter().append(answer);
		 		break;
		 	case"choixVille":
		 		String cities = request.getParameter("cities");
	 			ArrayList<Cities> cits = Cities.listRegionDepartments(cities);
	 			answer = "<ul><li>Liste des villes :</h1>";
	 			answer += "<option></option>";
	 			for(Cities c :cits) {
	 				answer += "<li>"+c.getNom()+"</li>";
	 			}
	 			answer += "</ul>";
	 			System.out.println(answer);
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				response.setCharacterEncoding("UTF-8");
				response.setContentLength(answer.length());
				response.getWriter().append(answer);
	 		break;
		 	case "initialisation":
			 		response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(4);
					response.getWriter().append("LOL");
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
