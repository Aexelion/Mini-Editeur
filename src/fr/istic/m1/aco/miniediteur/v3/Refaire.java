/**
 * @file Refaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe implémentant une Commande permettant de demander de reproduire la dernière commande annulée
 */
public class Refaire implements Commande {

    private GestionnaireDefaireRefaire gest;

	/**
	 * @brief Constructeur associant le GestionnaireDefaireRefaire chargé d'effectuer la reproduction de la commande annulée
	 * @param gest le GestionnaireDefaireRefaire à employer pour refaire l'action annulée
	 */
    public Refaire(GestionnaireDefaireRefaire gest){
        this.gest = gest;
    }

	/** 
	 * @brief Implémentation de la commande demandant au GestionnaireDefaireRefaire de rééxécuter la dernière commande annulée
	 */
    @Override
    public void execute() {
        gest.refaire();
    }
}
