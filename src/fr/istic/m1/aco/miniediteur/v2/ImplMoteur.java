/**
 * @file ImplMoteur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe implémentant le Moteur d'une façon compatible avec la spécification de la version 2 du MiniEditeur
 */
public class ImplMoteur implements Moteur {

    private Buffer buf;
    private Selection sel;
    private PressePapier pp;
 
	/**
	 * @brief Constructeur initialisant à une valeur neutre les variables internes de la classe
	 */
    public ImplMoteur(){
        this.buf = new Buffer("");
        this.sel = new Selection(0,0);
        this.pp = new PressePapier("");
    }

	/**
	 * @brief Méthode effectuant du pretty-printing pour préparer l'affichage sur l'IHM
	 * @details Utilise l'ajout de deux crochets ('[') pour permettre de visualiser la Selection
	 * @return Un String pour l'affichage
	 */
    @Override
    public String affiche() {
        String txt = buf.getTxt();
        int deb = sel.getDeb(), fin = sel.getFin();

        String res = txt.substring(0,deb) + "[" + txt.substring(deb, fin) + "[" + txt.substring(fin);

        return res;
    }

	/**
	 * @brief Méthode effectuant le retrait de la sélection en cours du texte et son stockage dans le PressePapier
	 * @details Ne vérifie pas si la sous-chaîne selectionnée est vide. Permettant ainsi de flusher volontairement le PressePapier. Replace le curseur de sélection là où le texte sélectionné a été coupé.
	 */
    @Override
    public void couper() {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        pp.setTxt(txt.substring(debutSel,finSel)); //Ne vérifie pas si la sous-chaine est vide. Récupère la chaine [debut, fin[
        txt = txt.substring(0,debutSel) + txt.substring(finSel);

        sel.setFin(debutSel); //Place le curseur de sélection la où le texte a été couper

        buf.setTxt(txt);

        this.verifSel();
    }

	/**
	 * @brief Méthode effectuant la sauvegarde dans le PressePapier de la sélection en cours
	 * @details Ne vérifie pas si la sous-chaîne selectionnée est vide. Permettant ainsi de flusher volontairement le PressePapier.
	 */
    @Override
    public void copier() {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        pp.setTxt(txt.substring(debutSel,finSel)); //Ne vérifie pas si la sous-chaine est vide. Récupère la chaine [debut, fin[

        this.verifSel();
    }

	/**
	 * @brief Méthode insérant à l'emplacement de la sélection le contenu du PressePapier
	 * @details Replace le curseur de la Selection après le texte qui vient d'être inséré.
	 */
    @Override
    public void coller() {
        String txt = buf.getTxt();
        String ajout = "";
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        ajout = pp.getTxt();
        txt = txt.substring(0,debutSel) + ajout + txt.substring(finSel);

        sel.setFin(debutSel + ajout.length()); //Place le curseur de sélection après le texte qui vient d'être inséré
        sel.setDeb(debutSel + ajout.length());

        buf.setTxt(txt);

        this.verifSel();
    }

	/**
	 * @brief Méthode insérant un texte donné à l'emplacement de la sélection
	 * @details Déplace le curseur de la Selection à la suite du texte qui est inséré
	 * @param s un String du texte à insérer
	 */
    @Override
    public void inserer(String s) {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        txt = txt.substring(0,debutSel) + s + txt.substring(finSel);


        sel.setFin(debutSel + s.length()); //Place le curseur de sélection après le texte qui vient d'être inséré
        sel.setDeb(debutSel + s.length());

        buf.setTxt(txt);

        this.verifSel();
    }

	/**
	 * @brief Méthode définissant la sélection en cours
	 * @param debut un entier marquant le début de la sélection
	 * @param fin un entier marquant la fin de la sélection
	 */
    @Override
    public void selectionner(int debut, int fin) {
        sel.setDeb(debut);
        sel.setFin(fin);

        this.verifSel();
    }

	/**
	 * @brief Méthode chargeant un Buffer et une Selection dans le Moteur
	 * @param b le Buffer a charger
	 * @param s la Selection a charger
	 */
    @Override
    public void charger(Buffer b, Selection s) {
        this.buf = b;
        this.sel = s;

        this.verifSel();
    }

	/**
	 * @brief Méthode vérifiant que les marqueurs de début et de fin de Selection sont légaux et si ils ne sont pas inversés
	 * @details Si les marqueurs de Selection sont inversés elle les remets dans l'ordre
	 * @sa verifDeb()
	 * @sa verifFin()
	 */
    private void verifSel() {
        this.verifDeb();
        this.verifFin();

        int deb = sel.getDeb();
        int fin = sel.getFin();

        if (deb > fin) {
            sel.setDeb(fin);
            sel.setFin(deb);
        }
    }

	/**
	 * @brief Méthode vérifiant et corrigeant le marqueur de début de la Selection s'il est à l'extérieur du texte
	 */
    private void verifDeb() {
        int deb = sel.getDeb();
        int bufLen = buf.getTxt().length();

        if (deb < 0) {
            sel.setDeb(0);
        } else if (deb > bufLen) {
            sel.setDeb(bufLen);
        }
    }
	
	/**
	 * @brief Méthode vérifiant et corrigeant le marqueur de fin de la Selection s'il est à l'extérieur du texte
	 */
    private void verifFin() {
        int fin = sel.getFin();
        int bufLen = buf.getTxt().length();

        if (fin < 0) {
            sel.setFin(0);
        } else if (fin > bufLen) {
            sel.setFin(bufLen);
        }
    }

	/**
	 * @brief Accesseur du Buffer du Moteur
	 * @return Le Buffer du Moteur
	 */
    @Override
    public Buffer getbuf() {
        return buf;
    }

	/**
	 * @brief Accesseur de la Selection du Moteur
	 * @return La Selection contenue dans le Moteur
	 */
    @Override
    public Selection getSel() {
        return sel;
    }

	/**
	 * @brief Accesseur du PressePapier du Moteur
	 * @return Le PressePapier du Moteur
	 */
    @Override
    public PressePapier getPP() {
        return pp;
    }
}
