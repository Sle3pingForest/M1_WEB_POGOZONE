package forms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Utilisateur;

public final class InscriptionForm {

	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "motdepasse";
	private static final String CHAMP_CONF = "confirmation";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_DATE = "datedenaissance";
	private static final String CHAMP_VILLE = "ville";
	private static final String CHAMP_CODE = "codepostal";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String date_naissan = getValeurChamp(request, CHAMP_DATE);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String code = getValeurChamp(request, CHAMP_CODE);

		Utilisateur utilisateur = new Utilisateur();
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);

		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		utilisateur.setMotDePasse(motDePasse);

		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		utilisateur.setNom(nom);
		
		try {
			validationDateNaissance(date_naissan);
		} catch (Exception e) {
			setErreur(CHAMP_DATE, e.getMessage());
		}
		utilisateur.setDateNaissance(date_naissan);

		try {
			validationVille(ville);
		} catch (Exception e) {
			setErreur(CHAMP_VILLE, e.getMessage());
		}
		utilisateur.setVille(ville);
		
		try {
			validationCode(code);
		} catch (Exception e) {
			setErreur(CHAMP_CODE, e.getMessage());
		}
		utilisateur.setCode(code);
		
		
		if (erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Échec de l'inscription.";
		}

		return utilisateur;
	}

	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}
	
	private void validationDateNaissance(String d) throws Exception {
		String[] y = d.split("/");
		if(d != null ){
			if(!isNumeric(y[0]) || !isNumeric(y[1]) || !isNumeric(y[2])){
				throw new Exception("Rentre le date avec la bonne format!.");
			}
		}
		if(d.charAt(2) !='/' || d.charAt(5) != '/'){
			throw new Exception("Rentre le date avec la bonne format!.");
		}
		System.out.println("apres" + d);
	}
	
	private void validationVille(String ville) throws Exception {
		if (ville == null ) {
			throw new Exception("La ville n'est pas correct!.");
		}
	}
	
	private void validationCode(String code) throws Exception {
		if (code == null  || !isNumeric(code)) {
			throw new Exception("La code postal n'est pas correct!.");
		}
	}


	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
	
	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

}
