package VoteSavingDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VoterRegistrationImpl implements VoteRegitration {
     static int i=0;
	@Override

	public Connection createConnection() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Registration is Completed");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			System.out.println("Data Base Connection is Created");
			return con;
			
		}catch(Exception e)
		{
			
		}
		
		return null;
	}

	@Override
	public int voterRegistration(int id, String name, String Gender, String addr) {
		try
		{
			Connection con=createConnection();
			PreparedStatement ps=con.prepareStatement("insert into voter (id,sname,gender,addr) values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, Gender);
			ps.setString(4, addr);
			int i=ps.executeUpdate();
			return i;
		}
		catch(Exception e)
		{
			
		}
		return 0;
	}

	@Override
	public ResultSet voterList() {
		try
		{
			Connection con=createConnection();
			Statement stmt=con.createStatement();
			String sql="select *from voter";
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	@Override
	public boolean checkUser(String name) {
		
		try
		{
			Connection con=createConnection();
			String sql="select *from voter where sname='"+name+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			
		}
		
		return false;
	}
	public int partyvotes()
	{
		i=i+1;
		return i;
		
	}

	@Override
	public ResultSet partiesList() {
		try
		{
			Connection con=createConnection();
			Statement stmt=con.createStatement();
			String sql="select *from party";
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

}
