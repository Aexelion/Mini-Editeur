/**
 * @file Copier.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Copier dans un "copié-collé"
 */
public class Copier implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exéctuer la Commande et l'Enregistreur qui conservera éventuellement son emploi
	 * @param engine le Moteur à employer pour effectuer l'action de Copier
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 */
    public Copier(Moteur engine, Enregistreur recorder){
        this.engine = engine;
        this.recorder = recorder; //V2
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action copier du "copié-collé"
     */
    @Override
    public void execute() {
        engine.copier();
        recorder.enregistrer(this); //V2
    }

	/**
     * @brief Implémentation vierge de la méthode getMemento car l'action Copier n'a pas de sauvegarde du texte à copier
     * @return Un null comme Copier n'a pas de sauvegarde
     */
    @Override
    public Memento getMemento() { //V2
        return null;
    }

	/**
     * @brief Implémentation vierge de la méthode setMemento car l'action Copier n'a pas de sauvegarde du texte à copier
     */
    @Override
    public void setMemento(Memento m) { //V2

    }
}
