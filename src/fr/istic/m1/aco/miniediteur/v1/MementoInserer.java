/**
 * @file MementoInserer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe implémentant le Memento appliqué à l'action Inserer
 * @details Implémentation jouant donc le rôle de "concrete memento" du design pattern Memento
 */
public class MementoInserer implements Memento {

    private String text;

	/**
	 * @brief Constructeur du MementoInserer destiné à sauvegarder un texte inséré
	 * @param str un String du texte inséré à conserver
	 */
    public MementoInserer (String str){
        text = str;
    }

	/**
	 * @brief Accesseur du texte sauvegardé
	 * @return Le texte originellement inséré, sous forme de String
	 */
    public String getText(){
        return this.text;
    }
}
