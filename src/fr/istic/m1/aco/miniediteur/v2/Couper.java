/**
 * @file Couper.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe implémentant l'action de Couper une selection de texte dans le cadre d'un "couper-coller" par le biais d'une Commande
 */
public class Couper implements CommandeEnregistrable {

	private Moteur engine;
	private Enregistreur recorder; //V2

	/**
	 * @brief Constructeur permettant de définir le Moteur à employer pour exéctuer la Commande et l'Enregistreur qui conservera éventuellement son emploi
	 * @param engine le Moteur à employer pour effectuer l'action de Copier
	 * @param recorder l'Enregistreur qui recevra un appel d'enregistrement à l'utilisation de la commande
	 */
	public Couper(Moteur engine, Enregistreur recorder){
		this.engine = engine;
		this.recorder = recorder; //V2
	}

	/**
	 * @brief Implémentation permettant d'effectuer l'action couper du "coupé-collé"
	 */
	@Override
	public void execute() {
		engine.couper();
		recorder.enregistrer(this); //V2
	}

	/**
	 * @brief Implémentation vierge de la méthode getMemento car l'action Couper n'a pas de sauvegarde du texte à copier
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
