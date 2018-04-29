package party;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VoteSavingDetails.VoteRegitration;
import VoteSavingDetails.VoterRegistrationImpl;

/**
 * Servlet implementation class partiesList
 */
@WebServlet("/partiesList")
public class partiesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public partiesList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		req.getRequestDispatcher("/index.jsp").include(req, res);
			VoteRegitration vr=new VoterRegistrationImpl();
			ResultSet rs=vr.partiesList();
			PrintWriter pw=res.getWriter();
			pw.println("<head>");
			pw.println("<link rel='stylesheet' type='text/css' href='css/style.css' />");
			pw.println("</head>");
			pw.println("<center>");
			pw.println("<h2 style='color:green'>Parties List</h2>");
			pw.println("<table style='border: 1px solid black'>");
			pw.println("<tr><th>TDP</th> <th>YSRCP</th><th>BJP</th><th>JANASENA</th></tr>");
			try {
				while(rs.next())
				{
					pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
				}
				pw.println("</table>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pw.println("<button><a href='http://localhost:8090/VotingProject/logout.jsp'>Logout</a></button>");
			pw.println("</center>");
	}

}
