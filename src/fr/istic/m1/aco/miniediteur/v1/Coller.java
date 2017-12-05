/**
 * @file Coller.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Coller dans un "copié-collé"
 */
public class Coller implements Commande {

    private Moteur engine;

	/**
	 * @brief Cosntructeur permettant de définir le Moteur à employer pour exéctuer la Commande
	 * @param engine le Moteur qui exécutera l'action de la Commande
	 */
    public Coller(Moteur engine) {
        this.engine = engine;
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action coller du "copié-collé"
     */
    @Override
    public void execute() {
        engine.coller();
    }
}
