package AdminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admincheck
 */
@WebServlet("/Admincheck")
public class Admincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		if(name.equals("sarath") && pass.equals("sarath@143"))
		{
			req.setAttribute("name",name);
			RequestDispatcher rd=req.getRequestDispatcher("adminSuccess.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("notsuccess", true);
			RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, res);
		}
	}

}
