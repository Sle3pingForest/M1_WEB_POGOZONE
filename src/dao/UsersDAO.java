package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO  {
	
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static ArrayList<String> listUsers = null;
	protected static Statement statement = null;
	
	public static ArrayList<String>  selectAll() throws Exception{

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try{
		    statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT * from ADMINS");
			resultSet = preparedStatement.executeQuery();
			listUsers = new ArrayList<>();
		    while (resultSet.next()) {
		       String user = resultSet.getString("username");
		       listUsers.add(user);
		    }
		}
		catch (Exception e) {
		      throw e;
		} 
		finally {
		      connect.closeCnx();
		}
		
		return listUsers;

	}
}
