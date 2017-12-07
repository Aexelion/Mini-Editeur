/**
 * @file CommandeEnregistrable.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Interface de structure permettant de relier les interface Commande à la propriété Enregistrable pour définir les Commandes pouvant être enregistrées dans une macro
 */
public interface CommandeEnregistrable extends Commande, Enregistrable {
}
