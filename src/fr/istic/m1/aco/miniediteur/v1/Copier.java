package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Copier implements Commande, Enregistrable {

    private Moteur engine;
    private Enregistreur recorder;

    public Copier(Moteur engine, Enregistreur recorder){
        this.engine = engine;
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        engine.copier();
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
