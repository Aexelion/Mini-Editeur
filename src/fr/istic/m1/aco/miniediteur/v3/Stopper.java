/**
 * @file Stopper.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Commande permettant de mettre fin à l'enregistrement d'une macro
 * @note N'est pas elle même Enregistrable pour éviter des empilements d'enregistrements
 */
public class Stopper implements Commande {

    private Enregistreur recorder;

	/**
	 * @brief Cosntructeur définissant quel Enregistreur prévenir pour finir l'enregistrement
	 * @param recorder l'Enregistreur auquel on souhaite pouvoir demander la fin de l'enregistrement depuis la Commande
	 */
    public Stopper(Enregistreur recorder){
        this.recorder = recorder;
    }

	/**
	 * @brief Méthode indiquant à l'Enregistreur qu'il doit terminer l'enregistrement
	 */
    @Override
    public void execute() {
        recorder.stopper();
    }
}
