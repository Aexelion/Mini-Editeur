/**
 * @file Coller.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Coller dans un "copié-collé"
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exécuter la Commande et l'Enregistreur qui conservera éventuellement son emploi
	 * @param engine le Moteur qui exécutera l'action de la Commande
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 */
    public Coller(Moteur engine, Enregistreur recorder){
        this.engine = engine;
        this.recorder = recorder; //V2
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action coller du "copié-collé"
     */
    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this); //V2
    }

	/**
     * @brief Implémentation vierge de la méthode getMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     * @return Un null comme Coller n'a pas de sauvegarde
     */
    @Override
    public Memento getMemento() { //V2
        return null;
    }

	/**
     * @brief Implémentation vierge de la méthode setMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     */
    @Override
    public void setMemento(Memento m) { //V2
    }
}
