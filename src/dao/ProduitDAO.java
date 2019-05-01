package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProduitDAO {

	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Statement statement = null;
	
	public static void insertProduit(String type,String marque,int stock_dispo)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			String q = "INSERT INTO PRODUIT (TYPE_PRODUIT,MARQUE,STOCK_DISPO)  " + 
			"VALUES ('"+type+"','"+marque+"','"+stock_dispo+"')";
			//System.out.println(q);
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
	}
	
	
	public static void supprProduit(String type_produit,String marque)throws Exception{
		ConnexionBDD connect = ConnexionBDD.getInstance();
		try {
			statement = connect.getCnx().createStatement();
			//DELETE FROM PRODUIT WHERE(TYPE_PRODUIT='CARAPUCE' AND MARQUE='POKEMON');
			String q ="DELETE FROM PRODUIT WHERE (TYPE_PRODUIT='"+type_produit+"'AND MARQUE='"+marque+"');";
			preparedStatement = connect.getCnx().prepareStatement(q);
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		} finally {
			connect.closeCnx();
		}
		
	}
	
	


}
