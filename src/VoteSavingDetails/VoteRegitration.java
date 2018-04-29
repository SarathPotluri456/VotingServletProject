package VoteSavingDetails;

import java.sql.Connection;
import java.sql.ResultSet;

public interface VoteRegitration 
    {
	public Connection createConnection();
	int voterRegistration(int id,String name,String Gender,String addr);
      ResultSet voterList();
      ResultSet partiesList();
      boolean checkUser(String name);
     int partyvotes();
      
	}
