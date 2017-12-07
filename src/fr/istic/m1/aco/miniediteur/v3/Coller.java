/**
 * @file Coller.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Coller dans un "copié-collé"
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2
    private GestionnaireDefaireRefaire gest; //V3

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exécuter la Commande, l'Enregistreur qui conservera éventuellement son emploi et le GestionnaireDefaireRefaire pour pouvoir la refaire
	 * @param engine le Moteur qui exécutera l'action de la Commande
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 * @param gest le GestionnaireDefaireRefaire gérant les "Undo-Redo" de la commande
	 */
    public Coller(Moteur engine, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.recorder = recorder; //V2
        this.gest = gest; //V3
    }

	/**
     * @brief Implémentation permettant d'effectuer l'action coller du "copié-collé"
     */
    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this); //V2
        gest.appelCmd(this); //V3
    }

	/**
     * @brief Implémentation vierge de la méthode getMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Coller dans une action Refaire il faut au préalable avoir enregistré soit Copier soit Couper.
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
