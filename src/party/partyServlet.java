package party;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
 * Servlet implementation class partyServlet
 */
@WebServlet("/partyServlet")
public class partyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public partyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  res.setContentType("text/html");
	 
	 
	  String str=req.getParameter("party");
	  HttpSession hs=req.getSession();
	  String str1=(String) hs.getAttribute("name");
	  String sql=null;
	  String sql1=null;
	  VoteRegitration vg= new VoterRegistrationImpl();
	  Connection con=vg.createConnection();
	  
	  try {
		Statement stmt=con.createStatement();
	    
	  
	  
	  
	  if(str.equals("TDP"))
	  {
		  
		  sql="update voter set vote='"+str+"'where sname='"+str1+"'";
		  stmt.executeUpdate(sql);
		  RequestDispatcher rd=req.getRequestDispatcher("voteSuccess.jsp");
		  rd.forward(req, res);
		  VoterRegistrationImpl vri=new VoterRegistrationImpl();
		  int i=vri.partyvotes();
		  sql1="insert into party (tdp) values('"+i+"')";
		  stmt.executeQuery(sql1);
		  
	  }
	  else if(str.equals("YSRCP"))
	  {
		  sql="update voter set vote='"+str+"'where sname='"+str1+"'";
		  stmt.executeUpdate(sql);
		  RequestDispatcher rd=req.getRequestDispatcher("voteSuccess.jsp");
		  rd.forward(req, res);
		  VoterRegistrationImpl vri=new VoterRegistrationImpl();
		  int i=vri.partyvotes();
		  sql1="insert into party (ysrcp) values('"+i+"')";
		  stmt.executeQuery(sql1);
	  }
	  else if(str.equals("BJP"))
	  {
		  sql="update voter set vote='"+str+"'where sname='"+str1+"'";
		  stmt.executeUpdate(sql); 
		  RequestDispatcher rd=req.getRequestDispatcher("voteSuccess.jsp");
		  rd.forward(req, res);
		  VoterRegistrationImpl vri=new VoterRegistrationImpl();
		  int i=vri.partyvotes();
		  sql1="insert into  party (bjp) values('"+i+"')";
		  stmt.executeQuery(sql1);
	  }
	  else
	  {
		  sql="update voter set vote='"+str+"'where sname='"+str1+"'";
		  stmt.executeUpdate(sql); 
		  RequestDispatcher rd=req.getRequestDispatcher("voteSuccess.jsp");
		  rd.forward(req, res);
		  VoterRegistrationImpl vri=new VoterRegistrationImpl();
		  int i=vri.partyvotes();
		  sql1="insert into party  (janasena) values('"+i+"')";
		  stmt.executeUpdate(sql1);
	  }
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
