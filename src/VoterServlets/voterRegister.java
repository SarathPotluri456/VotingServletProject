package VoterServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VoteSavingDetails.VoteRegitration;
import VoteSavingDetails.VoterRegistrationImpl;

/**
 * Servlet implementation class voterRegister
 */
@WebServlet("/voterRegister")
public class voterRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voterRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
	    String gender=null;
	    if(req.getParameter("gen").equals("male"))
	    {
	    	gender="male";
	    }
	    else if(req.getParameter("gen").equals("female"))
	    {
	    	gender="female";
	    }
	    else
	    {
	    	gender="others";
	    }
	    String addr=req.getParameter("addr");
	    int i=0;
	    try
	    {
	    	VoteRegitration vr=new VoterRegistrationImpl();
	     i=vr.voterRegistration(id1, name, gender, addr);
	    	if(i==1)
	    	{
	    		req.setAttribute("name", name);
	    		RequestDispatcher rd=req.getRequestDispatcher("successReg.jsp");
	    		rd.forward(req, res);
	    	}
	    	else
	    	{
	    		req.setAttribute("notsuccess", true);
	    		RequestDispatcher rd=req.getRequestDispatcher("voterregister.jsp");
	    		rd.forward(req, res);
	    	}
	    }
	    catch(Exception e)
	    {
	    	
	    }
		
	}

}
