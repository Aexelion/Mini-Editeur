package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Inserer implements CommandeEnregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder; //V2
    private MementoInserer m; //V2
    private boolean flagMemento = false; //V2
    private GestionnaireDefaireRefaire gest; //V3

    public Inserer(Moteur engine, IHM gui, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.gui = gui;
        this.recorder = recorder; //V2
        this.gest = gest; //V3
    }

    @Override
    public void execute() {
        String str;
        if (!flagMemento) { //V2
            str = gui.getText();
        } else {
            str = m.getText();
            flagMemento = false;
        }
        engine.inserer(str);
        m = new MementoInserer(str); //V2
        recorder.enregistrer(this); //V2
        gest.appelCmd(this); //V3
    }

    @Override
    public Memento getMemento() { //V2
        return m;
    }

    @Override
    public void setMemento(Memento m) { //V2
        if (m instanceof MementoInserer){
            this.m = (MementoInserer) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoInserer attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}
