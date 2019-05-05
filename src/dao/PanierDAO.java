package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class PanierDAO {
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Statement statement = null;
	
	
	public static void insertPanier(String cookie,String idU, String idP, String nom, int qte)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "INSERT INTO PANIER (COOKIE,ID_USER,ID_PRODUIT,NOM_PROD, QUANTITE)  " + 
			"VALUES ('"+cookie+"','"+idU+"','"+idP+"','"+nom+"','"+qte+"')";
			System.out.println(q);
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}

	
	public static Map<String,String> getPanier(String cookie,String idU)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		Map<String,String> listPr = new HashMap<>();
		try {
			statement = connect.getCnx().createStatement();
			String q = "SELECT NOM_PROD, SUM(QUANTITE) AS TOTAL FROM PANIER  WHERE Cookie=" + cookie + " AND ID_USER ="+idU+ " GROUP BY NOM_PROD";
			preparedStatement = connect.getCnx().prepareStatement(q);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String nameProd = resultSet.getString("NOM_PROD");
				String qteTT = resultSet.getString("TOTAL");
				listPr.put(nameProd, qteTT);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
		return listPr;
	}
}
