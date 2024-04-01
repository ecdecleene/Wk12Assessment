package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.TeamPlayers;

/**
 * Servlet implementation class ViewAllTeamsServlet
 */
@WebServlet("/viewAllTeamsServlet")
public class ViewAllTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamPlayersHelper tph = new TeamPlayersHelper();
		List<TeamPlayers> tpl = tph.getTeams();
		request.setAttribute("allTeams", tpl);
		if(tpl.isEmpty()) {
			request.setAttribute("allTeams", " ");
		}
		getServletContext().getRequestDispatcher("/team-players.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
