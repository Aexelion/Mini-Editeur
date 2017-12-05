package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Demarrer implements Commande {

    private Enregistreur recorder;

    public Demarrer(Enregistreur recorder){
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.demarrer();
    }
}
