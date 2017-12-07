/**
 * @file GestionnaireDefaireRefaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Interface décrivant un système gérant la capacité d'annuler puis de reproduire la dernière action d'un utilisateur
 */
public interface GestionnaireDefaireRefaire {

	/**
	 * @brief Opération annulant la dernière action entreprise par l'utilisateur
	 */
    public void defaire();
    
    /**
     * @brief Opération reproduisant la dernière action de l'utilisateur
     */
    public void refaire();
    
    /**
     * @brief Opération appelant une Commande dans le but de reproduire la dernière action de l'utilisateur
     * @param c la Commande pouvant éventuellement être reproduite
     */
    public void appelCmd(Commande c);

}
