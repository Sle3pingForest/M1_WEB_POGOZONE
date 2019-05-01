package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Produit;

public final class ProduitForm {
	
    private static final String CHAMP_TYPE  = "type_produit";
    private static final String CHAMP_MARQUE  = "marque";
    private static final String CHAMP_STOCK  = "stock";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
	
    public Produit ajouterProduit(HttpServletRequest request) {
    	String type = getValeurChamp(request, CHAMP_TYPE);
    	String marque = getValeurChamp(request, CHAMP_MARQUE);
    	String stock = getValeurChamp(request, CHAMP_TYPE);
    	
    	Produit produit = new Produit();
    	
    	try {
    		validationType(type);
    	}catch (Exception e) {
			setErreur(CHAMP_TYPE, e.getMessage());
		}
    	produit.setType_produit(type);
    	try {
    		validationMarque(marque);
    	}catch (Exception e) {
			setErreur(CHAMP_MARQUE, e.getMessage());
		}
    	produit.setMarque(marque);
    	try {
    		Integer.parseInt(stock);
    		//validationStock(stock);
    	}catch (Exception e) {
			setErreur(CHAMP_STOCK, e.getMessage());
		}
    	produit.setStock_dispo(Integer.parseInt(stock));
    	
        if ( erreurs.isEmpty() ) {
            resultat = "Succès.";
        } else {
            resultat = "Échec.";
        }
    	
    	return produit;
    	
    }
    private void validationType(String type) throws Exception{
    	if(type != null) {
    		if(type.length()>30) {
    			throw new Exception("Merci de saisir un type possedant moins de 30 caractère.");
    		}
    	}
    	
    }
    private void validationMarque(String marque) throws Exception{
    	if(marque != null) {
    		if(marque.length()>30) {
    			throw new Exception("Merci de saisir une marque possedant moins de 30 caractère.");
    		}
    	}
    }
   
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
    public void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

	public Map<String, String> getErreurs() {
		return erreurs;
	}


}
