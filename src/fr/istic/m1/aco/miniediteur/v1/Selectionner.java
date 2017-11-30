package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Selectionner implements Commande {

    private Moteur engine;
    private IHM gui;

    public Selectionner(Moteur engine, IHM gui){
        this.engine = engine;
        this.gui = gui;
    }

    @Override
    public void execute() {
        int deb;
        int fin;
        deb = gui.getInt();
        fin = gui.getInt();
        engine.selectionner(deb, fin);
    }
}
