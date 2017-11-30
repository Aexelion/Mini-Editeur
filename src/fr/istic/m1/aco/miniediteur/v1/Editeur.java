/**
 * @(#) Editeur.java
 */

package fr.istic.m1.aco.miniediteur.v1;

public class Editeur {
	private IHM gui;
	private Moteur engine;

	//Commandes V1
	private Coller coller;
	private Copier copier;
	private Couper couper;
	private Selectionner selectionner;
	private Inserer inserer;

	public Editeur (IHM i, Moteur m) {

		this.gui = i;
		this.engine = m;

		this.createV1();
	}

	private void createV1(){
		this.coller = new Coller(engine);
		this.copier = new Copier(engine);
		this.couper = new Couper(engine);
		this.selectionner = new Selectionner(engine, gui);
		this.inserer = new Inserer(engine, gui);

		gui.addCmd("Coller",		this.coller);
		gui.addCmd("Copier",		this.copier);
		gui.addCmd("Couper",		this.couper);
		gui.addCmd("Selectionner",	this.selectionner);
		gui.addCmd("Inserer",		this.inserer);
	}


	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);

		Editeur editeur = new Editeur(gui, engine);

		gui.execution();
	}
}


