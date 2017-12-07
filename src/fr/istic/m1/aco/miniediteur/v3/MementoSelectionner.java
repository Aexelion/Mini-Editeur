/**
 * @file MementoSelectionner.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe implementant Memento destinée à conserver l'état d'une commande Selectionner
 */
public class MementoSelectionner implements Memento{

    private int deb;
    private int fin;

	/**
	 * @brief Constructeur sauvegardant le début et la fin d'une Selection
	 * @param deb un entier représentant le début de la sélection à sauvegarder
	 * @param fin un entier représentant la fin de la sélection à sauvegarder
	 */
    public MementoSelectionner(int deb, int fin){
        this.deb = deb;
        this.fin = fin;
    }

	/**
	 * @brief Accesseur retournant le début de sélection sauvegardé
	 * @return Un entier représentant le début de la sélection conservée dans le MementoSelectionner
	 */
    public int getDeb(){
        return deb;
    }

	/**
	 * @brief Accesseur retournant la fin de sélection sauvegardée
	 * @return Un entier représentant la fin de la sélection conservée dans le MementoSelectionner
	 */
    public int getFin(){
        return fin;
    }

}
