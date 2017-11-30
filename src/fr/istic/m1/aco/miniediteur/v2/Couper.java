package fr.istic.m1.aco.miniediteur.v2;

public class Couper implements CommandeEnregistrable {

	private Moteur engine;
	private Enregistreur recorder; //V2

	public Couper(Moteur engine, Enregistreur recorder){
		this.engine = engine;
		this.recorder = recorder; //V2
	}

	@Override
	public void execute() {
		engine.couper();
		recorder.enregistrer(this); //V2
	}

	@Override
	public Memento getMemento() { //V2
		return null;
	}

	@Override
	public void setMemento(Memento m) { //V2

	}
}
