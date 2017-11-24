/**
 * @(#) Editeur.java
 */

package fr.istic.m1.aco.miniediteur.v3;

public class Editeur {
	private IHM gui;
	private Moteur engine;
	private Enregistreur recorder; //V2
	private GestionnaireDefaireRefaire gest; //V3

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

	//Commandes V3
	private Defaire defaire;
	private Refaire refaire;

	public Editeur (IHM i, Moteur m, Enregistreur e, GestionnaireDefaireRefaire g) {

		this.gui = i;
		this.engine = m;
		this.recorder = e;
		this.gest = g;

		this.createV1();
		this.createV2();
		this.createV3();
	}

	private void createV1(){
		this.coller = new Coller(engine, recorder, gest);
		this.copier = new Copier(engine, recorder, gest);
		this.couper = new Couper(engine, recorder, gest);
		this.selectionner = new Selectionner(engine, gui, recorder, gest);
		this.inserer = new Inserer(engine, gui, recorder, gest);
	}

	private void createV2(){
		this.demarrer = new Demarrer(recorder);
		this.stopper = new Stopper(recorder);
		this.rejouer = new Rejouer(recorder);
	}

	private void createV3(){
		this.defaire = new Defaire(gest);
		this.refaire = new Refaire(gest);
	}


	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);
		ImplEnregistreur recorder = new ImplEnregistreur();
		ImplGestionnaire gest = new ImplGestionnaire(engine);

		Editeur editeur = new Editeur(gui, engine, recorder, gest);


	}
}


