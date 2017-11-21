/**
 * @file MementoSelectionner.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe implémentant le Memento appliqué à l'action Selectionner
 * @details Implémentation jouant donc le rôle de "concrete memento" du design pattern Memento
 */
public class MementoSelectionner implements Memento{

    private int deb;
    private int fin;

	/**
	 * @brief Constructeur de MementoSelectionner destiné à sauvegarder l'état d'une sélection de l'utilisateur
	 * @param debut entier décrivant le début d'une selection de texte
	 * @param fin entier décrivant la fin d'une selection de texte
	 * @see Voir Selectionner pour plus de détails quand aux notions de début et de fin de sélection
	 */
    public MementoSelectionner(int debut, int fin){
        this.deb = debut;
        this.fin = fin;
    }

	/**
	 * @brief Accesseur du début de la selection enregistrée
	 * @return un entier indiquant le début de la selection
	 */
    public int getDeb(){
        return deb;
    }

	/**
	 * @brief Accesseur de la fin de la selection enregistrée
	 * @return un entier indiquant la fin de la selection
    public int getFin(){
        return fin;
    }

}
