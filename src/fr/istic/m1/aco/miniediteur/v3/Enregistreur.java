/**
 * @file Enregistreur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Interface décrivant un système d'enregistrement d'une macro
 */
public interface Enregistreur {

	/**
	 * @brief Opération devant commencer l'enregistrement des actions effectuées afin de pouvoir les refaire plus tard
	 */
    public void demarrer();
    
    /**
     * @brief Opération devant arrêter l'enregistrement des actions effectuées dans la future macro
     */
    public void stopper();
    
    /**
     * @brief Opération devant exécuter les commandes retenues dans la macro les unes à la suite des autres
     */
    public void rejouer();
    
    /**
     * @brief Opération permettant d'ajouter une CommandeEnregistrable à la macro stockée dans l'Enregistreur
     * @param c la CommandeEnregistrable à ajouter à la macro
     */
    public void enregistrer(CommandeEnregistrable c);
}
