/**
 * @file Couper.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Copier dans un "copié-collé"
 */
public class Couper implements Commande, Enregistrable {
	
	private Moteur engine;
	private Enregistreur recorder;

	/**
	 * @brief Implémentation permettant d'effectuer l'action couper du "coupé-collé"
	 * @details Action enregistrable et donc pouvant faire l'objet d'un défaire refaire. Fait appel à l'implémentation de la dite action du moteur. Est donc "implementation-dependent" du moteur.
	 */
	@Override
	public void execute() {
		engine.couper();
		recorder.enregistrer(this);
	}

	/**
	 * @brief Implémentation vierge de la méthode getMemento car l'action Couper n'a pas de sauvegarde du texte à copier
	 * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Couper dans une action Refaire avec l'intention de remettre texte précis il faut avoir au préalable enregistrer Selectionner aussi.
	 * @return Un null comme Couper n'a pas de sauvegarde
	 */
	@Override
	public Memento getMemento() {
		return null;
	}

	/**
	 * @brief Implémentation vierge de la méthode setMemento car l'action Copier n'a pas de sauvegarde du texte à copier
	 */
	@Override
	public void setMemento(Memento m) {

	}
}
