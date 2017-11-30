/**
 * @file Coller.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de Coller dans un "copié-collé"
 */
public class Coller implements Commande, Enregistrable {

    private Moteur engine;
    private Enregistreur recorder;

    /**
     * @brief Implémentation permettant d'effectuer l'action coller du "copié-collé"
     * @details Action enregistrable et donc pouvant faire l'objet d'un défaire refaire. Fait appel à l'implémentation de la dite action du moteur. Est donc "implementation-dependent" du moteur.
     */
    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this);
    }

    /**
     * @brief Implémentation vierge de la méthode getMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Coller dans une action Refaire il faut au préalable avoir enregistré soit Copier soit Couper.
     * @return Un null comme Coller n'a pas de sauvegarde
     */
    @Override
    public Memento getMemento() {
        return null;
    }

    /**
     * @brief Implémentation vierge de la méthode setMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     */
    @Override
    public void setMemento(Memento m) {
    }
}
