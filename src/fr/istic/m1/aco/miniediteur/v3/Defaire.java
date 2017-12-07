/**
 * @file Defaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v3;

/**
 * @brief Classe décrivant la Commande permettant d'annuler la dernière action entreprise par l'utilisateur
 */
public class Defaire implements Commande {

    private GestionnaireDefaireRefaire gest;

	/**
	 * @brief Constructeur affectant le GestionnaireDefaireRefaire devant effectuer l'annulation
	 * @param gest le GestionnaireDefaireRefaire gérant l'annulation de la dernière action de l'utilisateur
	 */
    public Defaire(GestionnaireDefaireRefaire gest){
        this.gest = gest;
    }

	/**
	 * @brief Méthode demandant l'annulation de la dernière action au GestionnaireDefaireRefaire
	 */
    @Override
    public void execute() {
        gest.defaire();
    }
}
