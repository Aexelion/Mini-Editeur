package fr.istic.m1.aco.miniediteur.v2;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2

    public Coller(Moteur engine, Enregistreur recorder){
        this.engine = engine;
        this.recorder = recorder; //V2
    }

    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this); //V2
    }

    @Override
    public Memento getMemento() { //V2
        return null;
    }

    @Override
    public void setMemento(Memento m) { //V2
    }
}
