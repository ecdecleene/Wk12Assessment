package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlayerUniform;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToUniform");
		String path = "/viewUniformsServlet";
		PlayerUniformHelp uh = new PlayerUniformHelp();
		if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PlayerUniform uniToDelete = uh.searchForUniformById(tempId);
			uh.deleteUniform(uniToDelete);
			} catch (NumberFormatException e) {
				System.out.println("no uniform selected");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				PlayerUniform uniToEdit = uh.searchForUniformById(tempId);
				request.setAttribute("uniToEdit", uniToEdit);
				path = "/edit.jsp";
			} catch(NumberFormatException e) {
				System.out.println("No uniform selected");
			}
		}else if(act.equals("add")) {
			
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
