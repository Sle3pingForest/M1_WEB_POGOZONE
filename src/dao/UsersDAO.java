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

public class UsersDAO {

	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Map<String,String> listUserName = null;
	protected static Map<String, String> listAdmin = null;
	protected static Map<String, String> listUsers = null;
	protected static Map<String, String> listUsersIdName = null;
	protected static Statement statement = null;
	protected String nameLogIn = "";

	public static Map<String, String> selectUsers() throws Exception {

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try {
			statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT * from USER WHERE EST_ADMIN IS NULL");
			resultSet = preparedStatement.executeQuery();
			listUsers = new HashMap<String,String>();
			listUserName = new HashMap<String,String>();
			while (resultSet.next()) {
				String email = resultSet.getString("E_MAIL");
				String pass = resultSet.getString("PASSWORD");
				String name = resultSet.getString("Nom");
				listUsers.put(email,pass);
				listUserName.put(email,name);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}

		return listUsers;

	}

	public static Map<String,String> selectUsersIdName() throws Exception {

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try {
			statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT * from USER WHERE EST_ADMIN IS NULL");
			resultSet = preparedStatement.executeQuery();
			listUsersIdName = new HashMap<>();
			while (resultSet.next()) {
				String id = resultSet.getString("ID_USER");
				String nom = resultSet.getString("NOM");
				listUsersIdName.put(id,nom);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}

		return listUsersIdName;
	}

	public static Map<String, String> selectAdmin() throws Exception {

		ConnexionBDD connect = ConnexionBDD.getInstance();

		try {
			statement = connect.getCnx().createStatement();
			preparedStatement = connect.getCnx().prepareStatement("SELECT * from USER WHERE EST_ADMIN IS NOT NULL");
			resultSet = preparedStatement.executeQuery();
			listAdmin = new HashMap<>();
			while (resultSet.next()) {
				String name = resultSet.getString("NOM");
				String email = resultSet.getString("E_MAIL");
				String pass = resultSet.getString("PASSWORD");
				listAdmin.put(email, pass);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
		return listAdmin;
	}
	
	public static void insertUser(String nom, String pass, String date , String email, String ville, String code )throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "INSERT INTO USER (NOM, PASSWORD, DATE_NAISSANCE, E_MAIL, VILLE, CODE_POSTAL)  " + "VALUES ('"+nom +"','" + pass+"'," + "STR_TO_DATE('"+ date+ "','%d/%m/%Y')" +",'"+ email +"','"+ville + "','"+code  +"')";
			System.out.println(q);
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
	
	public static void deleteUser(String id, String name )throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "DELETE FROM USER WHERE ID_USER = " + id +" AND NOM  ='"+name+"'";
			
			System.out.println(q);
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
	
	public static void settingAdmin(String id)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "UPDATE USER SET EST_ADMIN  = 1 WHERE ID_USER = " +id ;
			
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
	
	public static void settingName(String id,String name)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "UPDATE USER SET NOM ='"+ name+ "' WHERE ID_USER = " +id ;
			
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
	
	public static String getName(String mail){
		return listUserName.get(mail);
	}
	
	

}
