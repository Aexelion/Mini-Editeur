package fr.istic.m1.aco.miniediteur.v1;

public class Couper implements CommandeEnregistrable {
	
	private Moteur engine;
	private Enregistreur recorder;

	public Couper(Moteur engine, Enregistreur recorder){
		this.engine = engine;
		this.recorder = recorder;
	}

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
