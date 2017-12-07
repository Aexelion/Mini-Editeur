/**
 * @file Demarrer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Commande permettant de lancer l'enregistrement d'une macro
 * @note N'est pas elle même Enregistrable pour éviter des empilements d'enregistrements
 */
public class Demarrer implements Commande {

    private Enregistreur recorder;

	/**
	 * @brief Constructeur définissant quel Enregistreur prévenir pour débuter l'enregistrement
	 * @param recorder l'Enregistreur auquel on souhaite pouvoir commencer l'enregistrement depuis la Commande
	 */
    public Demarrer(Enregistreur recorder){
        this.recorder = recorder;
    }

	/**
	 * @brief Méthode indiquant à l'Enregistreur qu'il doit commencer l'enregistrement
	 */
    @Override
    public void execute() {
        recorder.demarrer();
    }
}
