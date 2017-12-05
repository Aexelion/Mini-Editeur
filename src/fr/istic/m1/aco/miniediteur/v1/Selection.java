/**
 * @file Selection.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe définissant ce qu'est une séléction de texte dans le MiniEditeur
 */
public class Selection {

    private int deb = 0;
    private int fin = 0;

	/**
	 * @brief Constructeur initialisant la Selection à certaines valeurs
	 * @param d un entier marquant la position du marqueur de début de la Selection
	 * @param f un entier marquant la position du marqueur de fin de la Selection
	 */
    public Selection(int d, int f){
        this.deb = d;
        this.fin = f;
    }

	/**
	 * @brief Accesseur permettant d'obtenir la valeur de début de la Selection
	 * @return Un entier représentant la position du marqueur de début de la Selection du texte
	 */
    public int getDeb(){
        return deb;
    }

	/**
	 * @brief Mutateur permettant d'éditer la valeur de début de la Selection
	 * @param deb un entier représentant la nouvelle position du marqueur de début de la Selection
	 */
    public void setDeb(int deb) {
        this.deb = deb;
    }

	/**
	 * @brief Accesseur permettant d'obtenir la valeur de fin de la Selection
	 * @return Un entier représentant la position du marqueur de fin de la Selection du texte
	 */
    public int getFin() {
        return fin;
    }

	/**
	 * @brief Mutateur permettant d'éditer la valeur de fin de la Selection
	 * @param deb un entier représentant la nouvelle position du marqueur de fin de la Selection
	 */
    public void setFin(int fin) {
        this.fin = fin;
    }

	/**
	 * @brief Méthode permettant d'obtenir une copie de la Selection telle qu'elle est
	 * @return Une Selection qui est une copie de celle actuelle
	 */
    @Override
    public Selection clone(){
        return new Selection(deb, fin);
    }


}
