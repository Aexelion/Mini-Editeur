/**
 * @file Editeur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe principale représentant l'éditeur et appelant toutes les pièces nécessaires à son fonctionnement
 */
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

	/**
	 * @brief Constructeur chargeant une IHM, un Moteur dans l'Editeur, l'Enregistreur utilisé pour les macros et le GestionnaireDefaireRefaire permettant de faire des "Undo-Redo", et lancant le chargement des Commandes disponible dans l'Editeur
	 * @param i l'IHM à charger dans l'Editeur
	 * @param m le Moteur à charger dans l'Editeur
	 * @param e l'Enregistreur à charger dans l'Editeur
	 * @param g le GestionnaireDefaireRefaire à charger dans l'Editeur
	 */
	public Editeur (IHM i, Moteur m, Enregistreur e, GestionnaireDefaireRefaire g) {

		this.gui = i;
		this.engine = m;
		this.recorder = e;
		this.gest = g;

		this.createV1();
		this.createV2();
		this.createV3();
	}

	/**
	 * @brief Fonction créant et affectant les Commandes de la version 1 à l'IHM
	 * @details Donne les commandes Copier, Coller, Couper, Selectionner et Inserer telles que les spécifications de la version 1 demandent
	 */
	private void createV1(){
		this.coller = new Coller(engine, recorder, gest);
		this.copier = new Copier(engine, recorder);
		this.couper = new Couper(engine, recorder, gest);
		this.selectionner = new Selectionner(engine, gui, recorder, gest);
		this.inserer = new Inserer(engine, gui, recorder, gest);

		gui.addCmd("Coller",		this.coller);
		gui.addCmd("Copier",		this.copier);
		gui.addCmd("Couper",		this.couper);
		gui.addCmd("Selectionner",	this.selectionner);
		gui.addCmd("Inserer",		this.inserer);
	}

	/**
	 * @brief Fonction créant et affectant les Commandes de la version 2 à l'IHM
	 * @details Donne les commandes Demarrer, Stopper et Rejouer permettant de créer et rejouer une macro telles que les spécifications de la version 2 demandent
	 */
	private void createV2(){
		this.demarrer = new Demarrer(recorder);
		this.stopper = new Stopper(recorder);
		this.rejouer = new Rejouer(recorder);

		gui.addCmd("Demarrer",		this.demarrer);
		gui.addCmd("Stopper",		this.stopper);
		gui.addCmd("Rejouer",		this.rejouer);
	}

	/**
	 * @brief Fonction créant et affectant les Commandes de la version 3 à l'IHM
	 * @details Donne les commandes Defaire et Refaire permettant d'annuler ou de reproduire la dernière action de l'utilisateur telle que la spécification de la version 3 le demande
	 */
	private void createV3(){
		this.defaire = new Defaire(gest);
		this.refaire = new Refaire(gest);

		gui.addCmd("Defaire",		this.defaire);
		gui.addCmd("Refaire",		this.refaire);
	}

	/**
	 * @brief Fonction principale du Mini-Editeur
	 */
	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);
		ImplEnregistreur recorder = new ImplEnregistreur();
		ImplGestionnaire gest = new ImplGestionnaire(engine);

		Editeur editeur = new Editeur(gui, engine, recorder, gest);

		gui.execution();
	}
}


