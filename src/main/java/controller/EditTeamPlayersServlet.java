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
 * Servlet implementation class EditTeamPlayersServlet
 */
@WebServlet("/EditTeamPlayersServlet")
public class EditTeamPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamPlayersServlet() {
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
		TeamPlayersHelper tph = new TeamPlayersHelper();
		PlayerUniformHelp tp = new PlayerUniformHelp();
		CoachHelper ch = new CoachHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		TeamPlayers teamToUpdate = tph.searchForTeamById(tempId);
		String newTeamName = request.getParameter("teamName");
		String coachName = request.getParameter("coachName");
		Coach newCoach = ch.findCoach(coachName);
		try {
			String[] selectedUniforms = request.getParameterValues("allUniformsToAdd");
			List<PlayerUniform> selectedUniformsOnTeam = new ArrayList<PlayerUniform>();
			for(int i=0; i<selectedUniforms.length; i++) {
				System.out.println(selectedUniforms[i]);
				PlayerUniform p = tp.searchForUniformById(Integer.parseInt(selectedUniforms[i]));
				selectedUniformsOnTeam.add(p);
			} 
				
			} catch(NullPointerException ex) {
				List<PlayerUniform> selectedUniformsOnTeam = new ArrayList<PlayerUniform>();
				teamToUpdate.setTeamPlayers(selectedUniformsOnTeam);
		}
		teamToUpdate.setTeamName(newTeamName);
		teamToUpdate.setCoach(newCoach);
		tph.updateTeam(teamToUpdate);
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
