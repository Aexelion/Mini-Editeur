/**
 * @(#) Editeur.java
 */

package fr.istic.m1.aco.miniediteur.v2;

public class Editeur {
	private IHM gui;
	private Moteur engine;
	private Enregistreur recorder; //V2

	//Commandes V1
	private Coller coller;
	private Copier copier;
	private Couper couper;
	private Selectionner selectionner;
	private Inserer inserer;

	//Commandes V2
	private Demarrer demarrer;
	private Stopper stopper;
	private Rejouer rejouer;

	public Editeur (IHM i, Moteur m, Enregistreur e) {

		this.gui = i;
		this.engine = m;
		this.recorder = e;

		this.createV1();
		this.createV2();
	}

	private void createV1(){
		this.coller = new Coller(engine, recorder);
		this.copier = new Copier(engine, recorder);
		this.couper = new Couper(engine, recorder);
		this.selectionner = new Selectionner(engine, gui, recorder);
		this.inserer = new Inserer(engine, gui, recorder);

		gui.addCmd("Coller",		this.coller);
		gui.addCmd("Copier",		this.copier);
		gui.addCmd("Couper",		this.couper);
		gui.addCmd("Selectionner",	this.selectionner);
		gui.addCmd("Inserer",		this.inserer);
	}

	private void createV2(){
		this.demarrer = new Demarrer(recorder);
		this.stopper = new Stopper(recorder);
		this.rejouer = new Rejouer(recorder);

		gui.addCmd("Demarrer",		this.demarrer);
		gui.addCmd("Stopper",		this.stopper);
		gui.addCmd("Rejouer",		this.rejouer);
	}

	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);
		ImplEnregistreur recorder = new ImplEnregistreur();

		Editeur editeur = new Editeur(gui, engine, recorder);

		gui.execution();
	}
}


