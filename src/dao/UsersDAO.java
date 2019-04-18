package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersDAO  {
	
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static ArrayList<String> listUsers = null;
	protected static ArrayList<String> listMail = null;
	protected static Map<String,String> listAdmin = null;
	protected static Statement statement = null;
	
	public static ArrayList<String>  selectUsersName() throws Exception{

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try{
		    statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT username from USERS");
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
	
	public static ArrayList<String>  selectUsersMail() throws Exception{

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try{
		    statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT email from USERS");
			resultSet = preparedStatement.executeQuery();
			listMail = new ArrayList<>();
		    while (resultSet.next()) {
		       String email = resultSet.getString("email");
		       listMail.add(email);
		    }
		}
		catch (Exception e) {
		      throw e;
		} 
		finally {
		      connect.closeCnx();
		}
		
		return listMail;
	}
	
	public static Map<String, String> selectAdmin()throws Exception{

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try{
		    statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT * from ADMINS");
			resultSet = preparedStatement.executeQuery();
			listAdmin = new HashMap<>();
		    while (resultSet.next()) {
		    	String name = resultSet.getString("username");
		       String email = resultSet.getString("email");
		       String pass = resultSet.getString("password");
		       listAdmin.put(email , pass);
		    }
		}
		catch (Exception e) {
		      throw e;
		} 
		finally {
		      connect.closeCnx();
		}
		return listAdmin;
	}
}
