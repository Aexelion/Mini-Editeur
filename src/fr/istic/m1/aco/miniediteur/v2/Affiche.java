package fr.istic.m1.aco.miniediteur.v2;

/**
 * Created by 16009566 on 24/11/17.
 */
public class Affiche {

    private Moteur engine;

    public Affiche(Moteur engine) {
        this.engine = engine;
    }

    public String execute() {
        String res = engine.affiche();
        return res;
    }
}
