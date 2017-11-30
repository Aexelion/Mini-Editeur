package fr.istic.m1.aco.miniediteur.v1;


/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements Commande {

    private Moteur engine;

    public Coller(Moteur engine) {
        this.engine = engine;
    }

    @Override
    public void execute() {
        engine.coller();
    }
}
