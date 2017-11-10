package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Inserer implements CommandeEnregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder;
    private MementoInserer m;
    private boolean flagMemento = false;

    public Inserer(Moteur engine, Enregistreur recorder, IHM gui){
        this.engine = engine;
        this.recorder = recorder;
        this.gui = gui;
    }

    @Override
    public void execute() {
        String str;
        if (!flagMemento) {
            str = gui.getText();
        } else {
            str = m.getText();
            flagMemento = false;
        }
        engine.inserer(str);
        m = new MementoInserer(str);
        recorder.enregistrer(this);
    }

    @Override
    public Memento getMemento() {
        return m;
    }

    @Override
    public void setMemento(Memento m) {
        if (m instanceof MementoInserer){
            this.m = (MementoInserer) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoInserer attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}
