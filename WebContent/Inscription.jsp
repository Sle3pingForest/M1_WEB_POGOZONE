<%@page import="controllers.Inscription"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="get" action="Inscription">
            <fieldset>
                <legend>Inscription</legend>
                
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse"  size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                
                <label for="datedenaissance">Date de naissance <span class="requis">*</span></label>
                <input type="text" id="datedenaissance" name="datedenaissance" value="jj/mm/aaaa" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['datedenaissance']}</span>
                <br />
               <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" size="20" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
                
               <label for="ville">ville<span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" size="20" />
                <span class="erreur">${form.erreurs['ville']}</span>
                <br />
                
                <label for="code">code postal<span class="requis">*</span></label>
                <input type="text" id="codepostal" name="codepostal" size="20"/>
                <span class="erreur">${form.erreurs['codepostal']}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>