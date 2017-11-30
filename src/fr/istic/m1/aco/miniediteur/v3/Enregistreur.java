/**
 * @file Enregistreur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Interface décrivant les actions d'enregistrement de macros
 * @details Élément d'intégration d'un design pattern "Command" jouant le rôle "engine"
 */
public interface Enregistreur {

	/**
	 * @brief Opération permettant de débuter l'enregistrement des actions entreprises à refaire dans le cadre d'une macro
	 */
    public void demarrer();
    
    /**
     * @brief Opération permettant de terminer l'enregistrement des actions entreprises auparavant pour une macro
     */
    public void stopper();
    
    /**
     * @brief Opération exécutant les action enregistrées en macro
     */
    public void rejouer();
    
    /**
     * @brief Opération devant stocker une certaine action effectuée
     * @param c la commande à stocker pour la refaire ultérieurement
     */
    public void enregistrer(Commande c);
}
