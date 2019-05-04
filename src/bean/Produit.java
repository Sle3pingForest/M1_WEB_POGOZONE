package bean;

public class Produit {
	private int id;
	private String type_produit;
	private String marque;
	private int stock_dispo;
	
	public Produit() {
		
	}
	
	
	public Produit(int id,String type_produit, String marque, int stock_dispo) {
		this.type_produit = type_produit;
		this.id = id;
		this.marque = marque;
		this.stock_dispo = stock_dispo;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_produit() {
		return type_produit;
	}
	public void setType_produit(String type_produit) {
		this.type_produit = type_produit;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getStock_dispo() {
		return stock_dispo;
	}
	public void setStock_dispo(int stock_dispo) {
		this.stock_dispo = stock_dispo;
	}
	
	
	

}
