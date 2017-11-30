package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Copier implements Commande {

    private Moteur engine;

    public Copier(Moteur engine){
        this.engine = engine;
    }

    @Override
    public void execute() {
        engine.copier();
    }
}
