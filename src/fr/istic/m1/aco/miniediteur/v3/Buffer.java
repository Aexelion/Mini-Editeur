/**
 * @file Buffer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe décrivant la structure conservant le texte rentré dans un Editeur par l'Utilisateur
 */
public class Buffer {

    private String txt;

	/**
	 * @brief Constructeur remplissant le Buffer à sa création
	 * @param s le contenu à donner à la création du Buffer
	 */
    public Buffer(String s){
        this.txt = s;
    }

	/**
	 * @brief Accesseur permettant d'obtenir le texte contenu dans le Buffer
	 * @return Un String du texte sauvegardé
	 */
    public String getTxt() {
        return txt;
    }

	/**
	 * @brief Mutateur permettant de modifier le texte stocké dans le Buffer
	 * @param txt un String a placer en lieu et place du texte contenu dans le Buffer
	 */
    public void setTxt(String txt) {
        this.txt = txt;
    }

	/**
	 * @brief Fonction de copie du Buffer
	 * @return Un Buffer qui est une copie du Buffer actuel
	 */
    @Override
    public Buffer clone(){
        return new Buffer(txt);
    }

}
