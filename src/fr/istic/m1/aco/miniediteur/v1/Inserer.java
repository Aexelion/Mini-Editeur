package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Inserer implements Commande {

    private Moteur engine;
    private IHM gui;

    @Override
    public void execute() {
        String str = gui.getText();
        engine.inserer(str);
    }
}
