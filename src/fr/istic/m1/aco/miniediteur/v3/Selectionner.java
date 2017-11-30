package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Selectionner implements CommandeEnregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder; //V2
    private MementoSelectionner m; //V2
    private boolean flagMemento = false; //V2
    private GestionnaireDefaireRefaire gest;

    public Selectionner(Moteur engine, IHM gui, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.recorder = recorder;
        this.gui = gui;
        this.gest = gest;
    }

    @Override
    public void execute() {
        int deb;
        int fin;
        if (!flagMemento){ //V2
            deb = gui.getInt(); //TODO reflechir aux fonctions de gui
            fin = gui.getInt();
        } else {
            deb = m.getDeb();
            fin = m.getFin();
            flagMemento = false;
        }
        engine.selectionner(deb, fin);
        m = new MementoSelectionner(deb,fin); //V2
        recorder.enregistrer(this); //V2
        gest.appelCmd(this); //V3
    }

    @Override
    public Memento getMemento() { //V2
        return m;
    }

    @Override
    public void setMemento(Memento m) { //V2
        if (m instanceof MementoSelectionner){
            this.m = (MementoSelectionner) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoSelectionner attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}