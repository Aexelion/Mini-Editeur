package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Selectionner implements Commande, Enregistrable {

    private Moteur engine;
    private IHM gui;

    @Override
    public void execute() {
        int deb = gui.getInt(); //TODO reflechir aux fonctions de gui
        int fin = gui.getInt();
        engine.selectionner(deb, fin);
    }

    @Override
    public void enregistrer() {

    }
}
