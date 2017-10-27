/**
 * @file Defaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Défaire dans un "défaire-refaire"
 * @note Dans la spécification de la version 3 du Mini-Éditeur cette commande a été introduite et elle ne doit pas obligatoirement être enregistrée. La fonctionnalité d'enregistrement n'est donc pas implémentée.
 */
public class Defaire implements Commande {

    private GestionnaireDefaireRefaire gest;

    /**
     * @brief Implémentation permettant d'effectuer l'action défaire du "défaire-refaire"
     * @details Fait appel à l'implémentation de la dite action du GestionnaireDefaireRefaire. Est donc "implementation-dependent" du GestionnaireDefaireRefaire.
     */
    @Override
    public void execute() {
        gest.defaire();
    }
}
