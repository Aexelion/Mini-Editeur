/**
 * @file Affiche.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 3.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe permettant de demander l'affichage du contenu du Moteur
 */
public class Affiche {

    private Moteur engine;

	/**
	 * @brief Constructeur affectant le Moteur duquel on souhaite afficher les éléments
	 * @param engine le Moteur dont on veut pouvoir afficher les éléments
	 */
    public Affiche(Moteur engine) {
        this.engine = engine;
    }

	/**
	 * @brief Méthode retournant l'affichage déja prétraité par le Moteur de son contenu
	 * @return Un String contenant le contenu du Moteur
	 */
    public String execute() {
        String res = engine.affiche();
        return res;
    }
}
