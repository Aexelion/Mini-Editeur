/**
 * @file IHM.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Interface décrivant les opérations requises pour toutes les interfaces hommes machines
 */
public interface IHM {

	/**
	 * @brief Opération ajoutant à l'IHM une commande donnée pour la mettre à disposition de l'utilisateur avec un nom donné
	 * @param nomCmd le nom de la commande donnée à l'IHM pour l'affichage
	 * @param cmd la Commande a mettre à disposition de l'IHM
	 */
    public void addCmd(String nomCmd, Commande cmd);
    
    /**
     * @brief Opération lancant l'IHM et assurant son fonctionnement en boucle jusqu'à ce que le programme soit fermé par l'utilisateur
     */
    public void execution();
    
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
