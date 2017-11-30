/**
 * @file Moteur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant les opérations réalisable par le moteur du Mini-Editeur
 */
public interface Moteur {

	/**
	 * @brief Opération effectuant le retrait de la sélection en cours du texte et son stockage dans le PressePapier
	 */
	public void couper() throws UnsupportedOperationException;
	
	/**
	 * @brief Opération effectuant la sauvegarde dans le PressePapier de la sélection en cours
	 */
	public void copier() throws UnsupportedOperationException;
	
	/**
	 * @brief Opération insérant à l'emplacement de la sélection le contenu du PressePapier
	 */
	public void coller() throws UnsupportedOperationException;
	
	/**
	 * @brief Opération insérant un texte donné à l'emplacement de la sélection
	 * @param s un String du texte à insérer
	 */
	public void inserer(String s) throws UnsupportedOperationException;
	
	/**
	 * @brief Opération définissant la sélection en cours
	 * @param debut un entier marquant le début de la sélection
	 * @param fin un entier marquant la fin de la sélection
	 */
	public void selectionner(int debut, int fin) throws UnsupportedOperationException;
}
