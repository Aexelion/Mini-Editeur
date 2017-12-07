/**
 * @file MementoInserer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe implémentant le Memento destinées à sauvegarder l'état d'une commande Inserer
 */
public class MementoInserer implements Memento {

    private String text;

	/**
	 * @brief Constructeur sauvegardant un texte inséré donné en entrée
	 * @param str un String du texte à conserver
	 */
    public MementoInserer (String str){
        text = str;
    }

	/**
	 * @brief Accesseur retournant le texte sauvegardé par le MementoInserer
	 * @return Le String du texte sauvegardé
	 */
    public String getText(){
        return this.text;
    }
}
