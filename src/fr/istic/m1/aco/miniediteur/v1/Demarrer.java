/**
 * @file Demarrer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de débuter l'enregistrement d'une macro
 * @details Fonctionnalité introduite dans la spécification de la version 2 du Mini-Éditeur. N'est pas elle même enregistrable conformément à la spécification pour éviter un empilement d'enregistrements qui résulterait en un écrasement des précédents.
 */
public class Demarrer implements Commande {

    private Enregistreur recorder;

    /**
     * @brief Implémentation permettant d'effectuer l'action débutant l'enregistrement d'une macro
     * @details Fait appel à l'implémentation de l'enregistremenent. Est donc "implementation-dependent" de l'Enregistreur.
     */
    @Override
    public void execute() {
        recorder.demarrer();
    }
}
