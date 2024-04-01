package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeamPlayers;

/**
 * Servlet implementation class TeamNavigationServlet
 */
@WebServlet("/TeamNavigationServlet")
public class TeamNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamNavigationServlet() {
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
		String act = request.getParameter("doThisToTeam");
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		} else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TeamPlayers teamToDelete = tph.searchForTeamById(tempId);
				tph.deleteTeam(teamToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TeamPlayers teamToEdit = tph.searchForTeamById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				PlayerUniformHelp tphForPlayers = new PlayerUniformHelp();
				request.setAttribute("allPlayers", tphForPlayers.showAllUniforms());
				if(tphForPlayers.showAllUniforms().isEmpty()) {
					request.setAttribute("allPlayers", " ");
				}
				getServletContext().getRequestDispatcher("/edit-team.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		} else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-team.jsp").forward(request, response);
		}
	}

}
