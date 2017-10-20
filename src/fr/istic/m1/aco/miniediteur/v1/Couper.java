package fr.istic.m1.aco.miniediteur.v1;

public class Couper implements Commande, Enregistrable {
	
	private Moteur engine;
	private Enregistreur recorder;

	@Override
	public void execute() {
		engine.couper();
		recorder.enregistrer(this);
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento m) {

	}
}