/**
 * @file Enregistrable.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Interface décrivant et fournissant les opérations nécessaire à la faculté d'un élément à appartenir à une macro
 */
public interface Enregistrable {

	/**
	 * @brief Opération permettant d'obtenir un Memento sauvegardant l'état d'un élément si cela est nécessaire à sa reproduction par la macro
	 * @return Soit un Memento de sauvegarde de l'état de l'objet Enregistrable ou un null
	 * @warning Peut retourner un null dans le cas où aucune sauvegarde n'est nécessaire
	 */
    public Memento getMemento();
    
    /**
     * @brief Opération permettant d'éditer une sauvegarde de l'état d'un objet
     * @param m le nouveau Memento devant remplacer l'ancienne sauvegarde
     */
    public void setMemento(Memento m);

}
