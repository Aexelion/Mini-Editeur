/**
 * @file Inserer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la commande d'insertion de texte dans l'éditeur
 */
public class Inserer implements Commande, Enregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder;
    private MementoInserer m;
    private boolean flagMemento = false;

	/**
	 * @brief Implémentation de la commande d'insertion de texte
	 * @details Action enregistrable et donc pouvant faire l'objet d'un défaire refaire. Fait appel à l'implémentation de la dite action du moteur. Est donc "implementation-dependent" du moteur.
	 */
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

	/**
	 * @brief Implémentation de la méthode permettant de récupérer un Memento dans lequel sera sauvegardé l'état
	 * @return Un Memento de sauvegarde de l'état d'une commande d'insertion
	 */
    @Override
    public Memento getMemento() {
        return m;
    }

	/**
	 * @brief Implémentation de la méthode permettant d'éditer le Memento pour sauvegarder l'état d'une commande d'insertion
	 * @param m un MementoInserer qui sera édité
	 * @exception IllegalArgumentException Levée dans le cas où le Memento fourni n'est pas un MementoInserer
	 */
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
