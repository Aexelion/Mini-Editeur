package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Rejouer implements Commande {

    private Enregistreur recorder;

    @Override
    public void execute() {
        recorder.rejouer();
    }
}
