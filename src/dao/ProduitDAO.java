package dao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Produit;


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
	
	public static ArrayList<Produit> listProduit() throws Exception {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Produit> listProduit = new ArrayList<>();
		
		//System.out.println("demande de connexion ... ");
		ConnexionBDD con = ConnexionBDD.getInstance();
		//System.out.println("connecté!");
		
		try {
			statement = con.getCnx().createStatement();
			rs = statement.executeQuery("select * from PRODUIT");
			while(rs.next()) {
				int id = rs.getInt("ID");
				String type = rs.getString("TYPE_PRODUIT");
				String marque = rs.getString("MARQUE");
				int stock = rs.getInt("STOCK_DISPO");
				listProduit.add(new Produit(id,type,marque,stock));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.closeCnx();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listProduit;
	}


	public static void insertProduit(Produit produit) throws Exception {
		insertProduit(produit.getType_produit(), produit.getMarque(), produit.getStock_dispo());
		
	}

	
	


}
