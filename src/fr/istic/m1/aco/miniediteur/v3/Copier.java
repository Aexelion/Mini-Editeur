/**
 * @file Copier.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Copier dans un "copié-collé"
 */
public class Copier implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2
    //private GestionnaireDefaireRefaire gest; //V3

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exécuter la Commande et l'Enregistreur qui conservera éventuellement son emploi
	 * @param engine le Moteur à employer pour effectuer l'action de Copier
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 */
    public Copier(Moteur engine, Enregistreur recorder/*, GestionnaireDefaireRefaire gest*/){
        this.engine = engine;
        this.recorder = recorder; //V2
        //this.gest = gest; //V3
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action copier du "copié-collé"
     */
    @Override
    public void execute() {
        engine.copier();
        recorder.enregistrer(this); //V2
        //gest.appelCmd(this); //V3
    }

	/**
     * @brief Implémentation vierge de la méthode getMemento car l'action Copier n'a pas de sauvegarde du texte à copier
     * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Copier dans une action Refaire avec l'intention de remettre texte précis il faut avoir au préalable enregistrer Selectionner aussi.
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
