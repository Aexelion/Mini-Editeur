/**
 * @file Inserer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe contrôlant le fonctionnement de la commande d'insertion de texte dans l'éditeur
 */
public class Inserer implements CommandeEnregistrable {

    private Moteur engine;
    private IHM gui;
    private Enregistreur recorder; //V2
    private MementoInserer m; //V2
    private boolean flagMemento = false; //V2

	/**
	 * @brief Constructeur affectant un Moteur, une IHM et un Enregistreur qui seront utilisés par l'insertion
	 * @param engine le Moteur qui effectuera l'insertion en elle même
	 * @param gui l'IHM qui sert à intéragir avec l'utilisateur pour qu'il puisse insérer du texte
	 * @param recorder l'Enregistreur qui sera utilisé pour enregistrer l'insertion
	 */
    public Inserer(Moteur engine, IHM gui, Enregistreur recorder){
        this.engine = engine;
        this.gui = gui;
        this.recorder = recorder; //V2
    }

	/**
	 * @brief Implémentation de la commande d'insertion de texte
	 */
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
    }

	/**
	 * @brief Implémentation de la méthode permettant de récupérer un Memento dans lequel sera sauvegardé l'état
	 * @return Un Memento de sauvegarde de l'état d'une commande d'insertion, c'est à dire un MementoInserer
	 */
    @Override
    public Memento getMemento() { //V2
        return m;
    }

	/**
	 * @brief Implémentation de la méthode permettant d'éditer le Memento pour sauvegarder l'état d'une commande d'insertion
	 * @param m un MementoInserer qui sera édité
	 * @exception IllegalArgumentException Levée dans le cas où le Memento fourni n'est pas un MementoInserer
	 */
    @Override
    public void setMemento(Memento m) throws IllegalArgumentException { //V2
        if (m instanceof MementoInserer){
            this.m = (MementoInserer) m;
            flagMemento = true;
        } else {
            throw new IllegalArgumentException("MementoInserer attendu et "+ m.getClass().toString() +" fourni.");
        }
    }
}
