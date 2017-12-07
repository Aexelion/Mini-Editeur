/**
 * @file Couper.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe implémentant l'action de Couper une selection de texte dans le cadre d'un "couper-coller" par le biais d'une Commande
 */
public class Couper implements CommandeEnregistrable {
	
	private Moteur engine;
	private Enregistreur recorder; //V2
	private GestionnaireDefaireRefaire gest; //V3

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exéctuer la Commande, l'Enregistreur qui conservera éventuellement son emploi et le GestionnaireDefaireRefaire permettant de refaire les commandes
	 * @param engine le Moteur à employer pour effectuer l'action de Copier
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 * @param gest le GestionnaireDefaireRefaire permettant de faire le "Undo-Redo" de la commande
	 */
	public Couper(Moteur engine, Enregistreur recorder, GestionnaireDefaireRefaire gest){
		this.engine = engine;
		this.recorder = recorder; //V2
		this.gest = gest; //V3
	}

	/**
	 * @brief Implémentation permettant d'effectuer l'action couper du "coupé-collé"
	 */
	@Override
	public void execute() {
		engine.couper();
		recorder.enregistrer(this); //V2
		gest.appelCmd(this); //V3
	}

	/**
	 * @brief Implémentation vierge de la méthode getMemento car l'action Couper n'a pas de sauvegarde du texte à copier
	 * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Couper dans une action Refaire avec l'intention de remettre texte précis il faut avoir au préalable enregistrer Selectionner aussi.
	 * @return Un null comme Couper n'a pas de sauvegarde
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
