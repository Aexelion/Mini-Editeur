/**
 * @file Couper.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe implémentant l'action de Couper une selection de texte dans le cadre d'un "couper-coller" par le biais d'une Commande
 */
public class Couper implements Commande {
	
	private Moteur engine;

	/**
	 * @brief Constructeur désignant le Moteur à utiliser pour que la Commande effectue son action
	 * @param engine le Moteur qui sera employé par la Commande
	 */
	public Couper(Moteur engine){
		this.engine = engine;
	}

	/**
	 * @brief Implémentation permettant d'effectuer l'action couper du "coupé-collé"
	 */
	@Override
	public void execute() {
		engine.couper();
	}
}
