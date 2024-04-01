package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coach;
import model.PlayerUniform;
import model.TeamPlayers;

/**
 * Servlet implementation class CreateNewTeamServlet
 */
@WebServlet("/createNewTeamServlet")
public class CreateNewTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUniformHelp ph = new PlayerUniformHelp();
		String teamName = request.getParameter("teamName");
		System.out.println("Team Name: " + teamName);
		String coachName = request.getParameter("coachName");
		String[] selectedUniforms = request.getParameterValues("allUniformsToAdd");
		List<PlayerUniform> selectedUniformsOnTeam = new ArrayList<PlayerUniform>();
		if(selectedUniforms != null && selectedUniforms.length > 0) {
			for(int i = 0; i<selectedUniforms.length; i++) {
				System.out.println(selectedUniforms[i]);
				PlayerUniform p = ph.searchForUniformById(Integer.parseInt(selectedUniforms[i]));
				selectedUniformsOnTeam.add(p);
			}
		}
		
		Coach coach = new Coach(coachName);
		TeamPlayers tp = new TeamPlayers(teamName, coach);
		tp.setTeamPlayers(selectedUniformsOnTeam);
		TeamPlayersHelper tph = new TeamPlayersHelper();
		tph.insertNewTeamPlayers(tp);
		System.out.println("Done");
		System.out.println(tp.toString());
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
