/**
 * @file Copier.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Copier dans un "copié-collé"
 */
public class Copier implements Commande {

    private Moteur engine;

	/**
	 * @brief Constructeur désignant à la Commande quel Moteur utiliser
	 * @param engine le Moteur à employer pour effectuer l'action de Copier
	 */
    public Copier(Moteur engine){
        this.engine = engine;
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action copier du "copié-collé"
     */
    @Override
    public void execute() {
        engine.copier();
    }
}
