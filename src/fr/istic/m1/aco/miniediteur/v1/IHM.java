/**
 * @file IHM.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant les opérations requises pour toutes les interfaces hommes machines
 */
public interface IHM {

	/**
	 * @brief Opération retournant un texte obtenu depuis l'utilisateur
	 * @return Un String contenant le texte obtenu de l'utilisateur
	 */
	public String getText();
    
    /**
     * @brief Opération retournant un entier obtenu depuis l'utilisateur
     * @return L'entier récupéré depuis l'utilisateur
     */
    public int getInt();
}
