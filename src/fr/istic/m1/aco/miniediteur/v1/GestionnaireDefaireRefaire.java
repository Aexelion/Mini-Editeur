/**
 * @file GestionnaireDefaireRefaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant les mécanismes permettant d'annuler une action de l'utilisateur et éventuellement de la refaire
 * @details Élément d'intégration d'un design pattern "Command" jouant le rôle "engine"
 */
public interface GestionnaireDefaireRefaire {

	/**
	 * @brief Opération annulant la dernière commande effectuée par l'utilisateur
	 */
    public void defaire();
    
    /**
     * @brief Opération reproduisant la dernière commande annulée par l'utilisateur
     */
    public void refaire();

}
