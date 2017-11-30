/**
 * @file Selectionner.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe implémentant la fonctionnalité permettant de sélectionner 	une partie du texte pour y exécuter d'autres commandes
 */
public class Selectionner implements Commande, Enregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder;
    private MementoSelectionner m;
    private boolean flagMemento = false;

	
    /**
     * @brief Implémentation permettant d'effectuer l'action de slection du texte dans l'éditeur
     * @details Action enregistrable et donc pouvant faire l'objet d'un défaire refaire. Fait appel à l'implémentation de la dite action du moteur. Est donc "implementation-dependent" du moteur.
     */
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

	/**
	 * @brief Implémentation de la méthode permettant de récupérer un Memento dans lequel sera sauvegardé l'état de la sélection
	 * @return Un Memento de sauvegarde de l'état de la sélection au moment de l'appel de la méthode
	 */
    @Override
    public Memento getMemento() {
        return m;
    }

	/**
	 * @brief Implémentation de la méthode permettant d'éditer le Memento pour sauvegarder l'état dde la sélection
	 * @param m un MementoSelectionner qui sera édité
	 */
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
