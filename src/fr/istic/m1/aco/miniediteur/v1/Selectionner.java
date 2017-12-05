/**
 * @file Selectionner.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe implémentant la fonctionnalité permettant de sélectionner 	une partie du texte pour y exécuter d'autres commandes
 */
public class Selectionner implements Commande {

    private Moteur engine;
    private IHM gui;

    public Selectionner(Moteur engine, IHM gui){
        this.engine = engine;
        this.gui = gui;
    }

	
    /**
     * @brief Implémentation permettant d'effectuer l'action de slection du texte dans l'éditeur
     */
    @Override
    public void execute() {
        int deb;
        int fin;
        deb = gui.getInt();
        fin = gui.getInt();
        engine.selectionner(deb, fin);
	}
}
