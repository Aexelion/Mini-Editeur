package fr.istic.m1.aco.miniediteur.v3;

public class Couper implements CommandeEnregistrable {
	
	private Moteur engine;
	private Enregistreur recorder; //V2
	private GestionnaireDefaireRefaire gest; //V3

	public Couper(Moteur engine, Enregistreur recorder, GestionnaireDefaireRefaire gest){
		this.engine = engine;
		this.recorder = recorder; //V2
		this.gest = gest; //V3
	}

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
