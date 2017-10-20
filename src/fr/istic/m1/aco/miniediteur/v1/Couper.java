package fr.istic.m1.aco.miniediteur.v1;

public class Couper implements Commande, Enregistrable {
	
	private Moteur engine;
	private IHM gui;

	@Override
	public void enregistrer() {

	}

	@Override
	public void execute() {
		engine.couper();
	}

}
