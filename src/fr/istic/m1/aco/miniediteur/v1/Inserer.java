/**
 * @file Inserer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la commande d'insertion de texte dans l'éditeur
 */
public class Inserer implements Commande {

    private Moteur engine;
    private IHM gui;
	
	/**
	 * @brief Constructeur affectant un Moteur et une IHM qui seront utilisés par l'insertion
	 * @param engine le Moteur qui effectuera l'insertion en elle même
	 * @param gui l'IHM qui sert à intéragir avec l'utilisateur pour qu'il puisse insérer du texte
	 */
    public Inserer(Moteur engine, IHM gui){
        this.engine = engine;
        this.gui = gui;
    }

	/**
	 * @brief Implémentation de la commande d'insertion de texte
	 */
    @Override
    public void execute() {
        String str;
        str = gui.getText();
        engine.inserer(str);
    }
}
