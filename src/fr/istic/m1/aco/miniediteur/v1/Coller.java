package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements Commande, Enregistrable {

    private Moteur engine;
    private Enregistreur recorder;

    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this);
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento m) {
    }
}
