/**
 * @file Moteur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Interface décrivant les opérations réalisable par le moteur du Mini-Editeur
 */
public interface Moteur {

	/**
	 * @brief Opération effectuant du pretty-printing pour préparer l'affichage sur l'IHM
	 * @return Un String pour l'affichage
	 */
	public String affiche();
	
	/**
	 * @brief Opération effectuant le retrait de la sélection en cours du texte et son stockage dans le PressePapier
	 */
	public void couper();
	
	/**
	 * @brief Opération effectuant la sauvegarde dans le PressePapier de la sélection en cours
	 */
	public void copier();
	
	/**
	 * @brief Opération insérant à l'emplacement de la sélection le contenu du PressePapier
	 */
	public void coller();
	
	/**
	 * @brief Opération insérant un texte donné à l'emplacement de la sélection
	 * @param s un String du texte à insérer
	 */
	public void inserer(String s);
	
	/**
	 * @brief Opération définissant la sélection en cours
	 * @param debut un entier marquant le début de la sélection
	 * @param fin un entier marquant la fin de la sélection
	 */
	public void selectionner(int debut, int fin);
	
	/**
	 * @brief Opération chargeant un Buffer et une Selection dans le Moteur
	 * @param b le Buffer a charger
	 * @param s la Selection a charger
	 */
	public void charger(Buffer b, Selection s);
	
	/**
	 * @brief Accesseur du Buffer du Moteur
	 * @return Le Buffer du Moteur
	 */
	public Buffer getbuf();
	
	/**
	 * @brief Accesseur de la Selection du Moteur
	 * @return La Selection contenue dans le Moteur
	 */
	public Selection getSel();
	
	/**
	 * @brief Accesseur du PressePapier du Moteur
	 * @return Le PressePapier du Moteur
	 */
	public PressePapier getPP();
}
