package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanierDAO {
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Statement statement = null;
	
	public static void insertPanier(String cookie,String idU, String idP, int qte)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "INSERT INTO PANIER (COOKIE,ID_USER,ID_PRODUIT,QUANTITE)  " + 
			"VALUES ('"+cookie+"','"+idU+"','"+idP+"','"+qte+"')";
			System.out.println(q);
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
}
