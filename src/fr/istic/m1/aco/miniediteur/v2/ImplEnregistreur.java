/**
 * @file ImplEnregistreur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe implémentant l'Enregistreur
 * @details Emploie une ArrayList de Paire composée de CommandeEnregistrable et de Memento de sauvegarde
 */
public class ImplEnregistreur implements Enregistreur {

	/**
	 * @brief Classe interne permettant de stocker par Paire les CommandeEnregistrable et leurs états sauvegardés dans des Memento
	 */
    private class Paire{
        private CommandeEnregistrable cmd;
        private Memento m;

		/**
		 * @brief Constructeur associant une CommandeEnregistrable avec un Memento de son état
		 * @param cmd la CommandeEnregistrable à associer
		 * @param m le Memento enregistrant l'état à l'exécution de cmd
		 */
        public Paire (CommandeEnregistrable cmd, Memento m){
            this.cmd = cmd;
            this.m = m;
        }

		/**
		 * @brief Accesseur permettant de récupérer la CommandeEnregistrable de la Paire
		 * @return La CommandeEnregistrable de la Paire
		 */
        public CommandeEnregistrable getCommande(){
            return this.cmd;
        }

		/**
		 * @brief Accesseur permettant de récupérer le Memento de la Paire
		 * @return Le Memento de la Paire
		 */
        public Memento getMemento(){
            return this.m;
        }
    }

    private boolean enrEnCours = false;
    private List<Paire> macro = new ArrayList<Paire>(); //Une seule macro enregistrable à la fois

	/**
	 * @brief Méthode démarrant l'enregistrement si ce n'est pas déja fait
	 * @details Vérifie si une macro n'est pas déja en cours d'enregistrement. Si c'est le cas, ignore la demande. Sinon, flush la macro déja sauvegardée et commence l'enregistrement.
	 */
    @Override
    public void demarrer() {
        if(!enrEnCours){
            macro.clear();
            enrEnCours = true;
        }
    }

	/**
	 * @brief Méthode stoppant l'enregistrement si celui-ci est lancé
	 * @details Ignore la demande si l'enregistrement n'est pas en cours
	 */
    @Override
    public void stopper() {
        if(enrEnCours){
            enrEnCours = false;
        }
    }

	/**
	 * @brief Méthode faisant s'exécuter la macro enregistrée
	 * @details Exécute chaque Commande enregistrée dans le même ordre qu'elles ont été enregistrées en les remettant au préalable dans leur état sauvegardé par le Memento.
	 */
    @Override
    public void rejouer() {
        for (Paire p : macro){
            CommandeEnregistrable cmd = p.getCommande();
            Memento m = p.getMemento();
            cmd.setMemento(m);
            cmd.execute();
        }
    }

	/**
	 * @brief Méthode enregistrant les CommandeEnregistrable données en paramètre
	 * @details Sauvegarde aussi leur état au moment de la demande. N'a pas d'effet si aucun enregistrement n'est en cours.
	 */
    @Override
    public void enregistrer(CommandeEnregistrable c) {
        if (enrEnCours) {
            Memento m = c.getMemento();
            Paire tmp = new Paire(c,m);
            macro.add(tmp);
        }
    }
}
