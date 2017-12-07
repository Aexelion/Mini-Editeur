/**
 * @file Selectionner.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe implémentant la fonctionnalité permettant de sélectionner une partie du texte pour y exécuter d'autres commandes
 */
public class Selectionner implements CommandeEnregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder; //V2
    private MementoSelectionner m; //V2
    private boolean flagMemento = false; //V2
    private GestionnaireDefaireRefaire gest; //V3

	/**
	 * @brief Constructeur affectant un Moteur, une IHM, un Enregistreur et un GestionnaireDefaireRefaire pour gérer le "Undo-Redo" de la commande
	 * @param engine le Moteur utilisé par la commande
	 * @param gui l'IHM à employer pour questionner l'utilisateur
	 * @param recorder l'Enregistreur pouvant enregistrer la commande
	 * @param gest le GestionnaireDefaireRefaire gérant le "Undo-Redo" de la commande
	 */
    public Selectionner(Moteur engine, IHM gui, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.recorder = recorder; //V2
        this.gui = gui;
        this.gest = gest; //V3
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action de sélection du texte dans l'éditeur
     */
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

	/**
	 * @brief Accesseur donnant accès à la sauvegarde de l'état de Selectionner
	 * @return Un MementoSelectionner contenant une sauvegarde de l'état de la commande
	 */
    @Override
    public Memento getMemento() { //V2
        return m;
    }

	/**
	 * @brief Mutateur permettant d'éditer la sauvegarde de l'état de la commande
	 * @param m un Memento remplaçant l'ancien état
	 * @exception IllegalArgumentException si le Memento donné en entré n'est pas un MementoSelectionner
	 */
    @Override
    public void setMemento(Memento m) throws IllegalArgumentException { //V2
        if (m instanceof MementoSelectionner){
            this.m = (MementoSelectionner) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoSelectionner attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}
