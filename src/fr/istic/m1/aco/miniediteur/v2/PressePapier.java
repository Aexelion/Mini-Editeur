/**
 * @file PressePapier.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe décrivant le Presse Papier contenu dans un Editeur de texte et permettant de sauvegarder temporairement du texte afin de le dupliquer
 */
public class PressePapier {

    private String txt = "";

	/**
	 * @brief Constructeur initialisant le PressePapier avec un texte défini
	 * @param t un String à entrer dans le PressePapier dès sa création
	 */
    public PressePapier(String t){
        this.txt = t;
    }

	/**
	 * @brief Accesseur permettant de récupérer le texte sauvegardé dans le PressePapier
	 * @return Un String du texte enregistré
	 */
    public String getTxt() {
        return txt;
    }

	/**
	 * @brief Mutateurs permettant de remplacer le texte contenu dans le PressePapier
	 * @param txt un String a placer dans le PressePapier
	 */
    public void setTxt(String txt) {
        this.txt = txt;
    }

	/**
	 * @brief Méthode permettant de dupliquer le PressePapier
	 * @return Un PressePapier qui est une copie de l'actuel
	 */
    @Override
    public PressePapier clone() {
        return new PressePapier(txt);
    }
}
