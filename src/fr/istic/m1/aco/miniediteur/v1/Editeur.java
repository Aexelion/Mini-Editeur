/**
 * @file Editeur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe principale représentant l'éditeur et appelant toutes les pièces nécessaires à son fonctionnement
 */
public class Editeur {
	private IHM gui;
	private Moteur engine;

	//Commandes V1
	private Coller coller;
	private Copier copier;
	private Couper couper;
	private Selectionner selectionner;
	private Inserer inserer;

	/**
	 * @brief Constructeur chargeant une IHM et un Moteur dans l'Editeur et lancant le chargement des Commandes disponible dans l'Editeur
	 * @param i l'IHM à charger dans l'Editeur
	 * @param m le Moteur à charger dans l'Editeur
	 */
	public Editeur (IHM i, Moteur m) {

		this.gui = i;
		this.engine = m;

		this.createV1();
	}

	/**
	 * @brief Fonction créant et affectant les Commandes à l'IHM
	 * @details Donne les commandes Copier, Coller, Couper, Selectionner et Inserer telles que les spécifications de la version 1 demandent
	 */
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

	/**
	 * @brief Fonction principale du Mini-Editeur
	 */
	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);

		Editeur editeur = new Editeur(gui, engine);

		gui.execution();
	}
}


