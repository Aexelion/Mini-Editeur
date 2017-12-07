/**
 * @file ImplGestionnaire.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v3;

import java.util.Stack;

/**
 * @brief Classe implémentant un GestionnaireDefaireRefaire basé sur des pile de commandes
 * @details Fait appel à la classe Stack standard Java
 */
public class ImplGestionnaire implements GestionnaireDefaireRefaire{

	/**
	 * @brief Classe interne permettant de représenter un état à la fois du Buffer et de la Sélection à un instant t
	 */
    private class Etat{
        final Buffer buf;
        final Selection sel;

		/**
		 * @brief Constructeur d'Etat sauvegardant le Buffer et la Selection donnés en entrée
		 * @param b le Buffer à conserver
		 * @param s la Selection à conserver
		 */
        public Etat(Buffer b, Selection s){
            this.buf = b;
            this.sel = s;
        }
    }

    private Moteur engine;
    private Stack<Etat> pileFait;
    private Stack<Etat> pileARefaire;

    private final Etat init = new Etat(new Buffer(""), new Selection(0,0));
    private Etat courant;

	/**
	 * @brief Constructeur permettant d'associer le Moteur à utiliser pour en conserver les états
	 * @param engine le Moteur dont il faudra sauver les états
	 */
    public ImplGestionnaire(Moteur engine){
        this.engine = engine;
        pileFait = new Stack<>();
        pileARefaire = new Stack<>();
        courant = init;
    }

	/**
	 * @brief Méthode permettant d'annuler la dernière Commande effectuée par l'utilisateur
	 * @details Décharge une pile de commande faites dans une pile de commandes à faire et charge l'état correspondant dans le Moteur au passage.
	 * @note Ne fait rien si aucune commande n'a été effectuée.
	 */
    @Override
    public void defaire() {
        if (!pileFait.isEmpty()){
            Etat e = pileFait.pop();
            engine.charger(e.buf, e.sel);
            pileARefaire.add(courant);
            courant = e;
        } else {
            engine.charger(new Buffer(""), new Selection(0,0));
            courant = init;
        }
    }

	/**
	 * @brief Méthode permettant de refaire la dernière Commande effectée par l'utilisateur
	 * @details Retire la commande de la pile des commandes à refaire et la place dans la pile des commandes faites. Charge le nouvel état dans le Moteur au passage.
	 * @note Ne fait rien si aucune commande n'a été au préalablement défaite.
	 */
    @Override
    public void refaire() {
        if (!pileARefaire.isEmpty()){
            Etat e = pileARefaire.pop();
            engine.charger(e.buf, e.sel);
            pileFait.add(courant);
            courant = e;
        }
    }

	/**
	 * @brief Méthode enregistrant les états lors des appels de Commande
	 * @param c la Commande exécutée
	 * @note La présente implémentation n'utilise pas de sauvegarde de Commandes mais sauvegarde l'état du Moteur plutôt.
	 */
    @Override
    public void appelCmd(Commande c) {
        if (!pileARefaire.isEmpty()){
            pileARefaire.clear();
        }

        Buffer newBuf = engine.getbuf().clone();
        Selection newSel = engine.getSel().clone();

        Etat tmp = new Etat(newBuf, newSel);
        pileFait.push(courant);
        courant = tmp;
    }
}
