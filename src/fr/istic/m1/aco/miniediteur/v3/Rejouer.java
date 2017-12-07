/**
 * @file Rejouer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Commande permettant de lancer une macro enregistrée
 * @note N'est pas elle même Enregistrable pour éviter des paradoxes
 */
public class Rejouer implements Commande {

    private Enregistreur recorder;

	/**
	 * @brief Constructeur définissant l'Enregistreur contenant la macro
	 * @param recorder l'Enregistreur à exécuter
	 */
    public Rejouer(Enregistreur recorder){
        this.recorder = recorder;
    }

	/**
	 * @brief Méthode appelant le lancement de la macro contenue dans l'Enregistreur
	 */
    @Override
    public void execute() {
        recorder.rejouer();
    }
}
