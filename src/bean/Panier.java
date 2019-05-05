package bean;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

public class Panier {
	public Cookie cookie = null;
	public String id_user ="";
	public Map<String,Integer>  listProduitAcheter= null;
	
	public Panier(String id, Cookie cookie2){
		this.id_user = id;
		this.cookie = cookie2;
		this.listProduitAcheter = new HashMap<>();
	}
	
	
	public void ajoutProduit(String id, int qte){
		this.listProduitAcheter.put(id,qte );
	}
}
