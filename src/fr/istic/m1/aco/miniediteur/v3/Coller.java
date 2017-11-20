package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2
    private GestionnaireDefaireRefaire gest; //V3

    public Coller(Moteur engine, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.recorder = recorder; //V2
        this.gest = gest; //V3
    }

    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this); //V2
        gest.appelCmd(this); //V3
    }

    @Override
    public Memento getMemento() { //V2
        return null;
    }

    @Override
    public void setMemento(Memento m) { //V2
    }
}
