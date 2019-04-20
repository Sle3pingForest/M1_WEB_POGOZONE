package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnexionBDD {

	private static volatile ConnexionBDD instance;
	private Connection cnx; 
	  final public static String host = "localhost";
	  final public static  String user = "root";
	  final public static String passwd = "";
	private ConnexionBDD() throws IOException {
		try {
			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().
						getResourceAsStream("confBDD.properties")); 
			
			
				
			// chargement du driver ATTENTION A LES DONNE DES LE FICHIERS confBDD.properties 
			Class.forName(p.getProperty("driver"));
			String paramConnexion = p.getProperty("url") +"user="+ p.getProperty("user") +"&password="+ p.getProperty("pwd") ;
			//System.out.println(paramConnexion );
			//System.out.println("jdbc:mysql://" + "localhost" + "/Corrector?"+ "user=" + user + "&password=" + passwd );
			cnx = DriverManager.getConnection(paramConnexion);
			
			/*Class.forName("com.mysql.jdbc.Driver");   	
		    cnx = DriverManager.getConnection("jdbc:mysql://" + "localhost" + "/Corrector?"+ "user=" + user + "&password=" + passwd );*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	} 
	
	public static synchronized ConnexionBDD getInstance() throws IOException {
		if(instance==null)
			instance = new ConnexionBDD();
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}

