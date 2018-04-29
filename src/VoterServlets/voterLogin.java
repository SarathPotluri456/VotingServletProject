package VoterServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VoteSavingDetails.VoteRegitration;
import VoteSavingDetails.VoterRegistrationImpl;

/**
 * Servlet implementation class voterLogin
 */
@WebServlet("/voterLogin")
public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voterLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String name=req.getParameter("name");
		HttpSession hs=req.getSession();
		hs.setAttribute("name", name);
		VoteRegitration vg=new VoterRegistrationImpl();
		boolean st=vg.checkUser(name);
		if(st==true)
		{
			RequestDispatcher rd=req.getRequestDispatcher("party.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("notsuccess", true);
			RequestDispatcher rd=req.getRequestDispatcher("Userlogin.jsp");
			rd.forward(req, res);
		}
		
	}

}
