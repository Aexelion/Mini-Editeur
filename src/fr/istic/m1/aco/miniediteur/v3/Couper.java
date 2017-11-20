package fr.istic.m1.aco.miniediteur.v3;

public class Couper implements CommandeEnregistrable {
	
	private Moteur engine;
	private Enregistreur recorder; //V2
	private GestionnaireDefaireRefaire gest;

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

	@Override
	public Memento getMemento() { //V2
		return null;
	}

	@Override
	public void setMemento(Memento m) { //V2

	}
}
