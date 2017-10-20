package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Selectionner implements Commande, Enregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder;
    private MementoSelectionner m;
    private boolean flagMemento = false;

    @Override
    public void execute() {
        int deb;
        int fin;
        if (!flagMemento){
            deb = gui.getInt(); //TODO reflechir aux fonctions de gui
            fin = gui.getInt();
        } else {
            deb = m.getDeb();
            fin = m.getFin();
            flagMemento = false;
        }
        engine.selectionner(deb, fin);
        //TODO remplissage du mementoSelectionner
        recorder.enregistrer(this);
    }

    @Override
    public Memento getMemento() {
        return m;
    }

    @Override
    public void setMemento(Memento m) {
        if (m instanceof MementoSelectionner){
            this.m = (MementoSelectionner) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoSelectionner attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}
