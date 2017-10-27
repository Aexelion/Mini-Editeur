/**
 * @file Commande.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant une commande déclenchée par une action sur l'IHM de l'Utilisateur
 * @details Élément d'intégration d'un design pattern "Command" remplissant le rôle "command"
 */
public interface Commande {

	/**
	 * @brief Opération commune aux commandes devant implémenter leur action quand déclenchée par l'IHM
	 */
	public void execute();
}
