package fr.istic.m1.aco.miniediteur.v1;

public class Couper implements Commande {
	
	private Moteur engine;

	public Couper(Moteur engine){
		this.engine = engine;
	}

	@Override
	public void execute() {
		engine.couper();
	}
}
