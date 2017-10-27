/**
 * @file Enregistrable.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant des actions pouvant faire l'objet d'un enregistrement pour une macro
 * @details Permet de séparer clairement les actions pouvant être enregistrée des autres et fourni des opérations nécéssaires à l'enregistrement. Rempli le rôle "originator" du design pattern Memento.
 */
public interface Enregistrable {

    /**
     * @brief Opération permettant d'obtenir une copie de l'état d'une opération requérant une sauvegarde pour pouvoir être refaire ultérieurement
     * @return Une instance implémentant Memento qui est une copie de l'état de la commande.
     */
    public Memento getMemento();

    /**
     * @brief Opération permettant de réinitialiser la commande par rapport à un état précédent donné sous la forme d'un Memento
     * @param m un Memento décrivant un état précédent de la commande sur lequel revenir
     */
    public void setMemento(Memento m);

}
