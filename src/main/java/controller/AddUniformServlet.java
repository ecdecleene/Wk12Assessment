package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlayerUniform;

/**
 * Servlet implementation class AddUniformServlet
 */
@WebServlet("/addUniformServlet")
public class AddUniformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUniformServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String numbers = request.getParameter("number");
		int number = Integer.parseInt(numbers);
		
		PlayerUniform un = new PlayerUniform(number, name);
		PlayerUniformHelp uh = new PlayerUniformHelp();
		uh.insertUniform(un);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
