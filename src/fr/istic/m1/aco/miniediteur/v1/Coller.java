package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder;

    public Coller(Moteur engine, Enregistreur recorder){
        this.engine = engine;
        this.recorder = recorder;
    }

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
