package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 20/10/17.
 */
public class ImplMoteur implements Moteur {

    private Buffer buf;
    private Selection sel;
    private PressePapier pp;

    public ImplMoteur(){
        this.buf = new Buffer("");
        this.sel = new Selection(0,0);
        this.pp = new PressePapier("");
    }

    @Override
    public String affiche() {
        String txt = buf.getTxt();
        int deb = sel.getDeb(), fin = sel.getFin();

        String res = txt.substring(0,deb) + "[" + txt.substring(deb, fin) + "[" + txt.substring(fin);

        return res;
    }

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

    @Override
    public void copier() {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        pp.setTxt(txt.substring(debutSel,finSel)); //Ne vérifie pas si la sous-chaine est vide. Récupère la chaine [debut, fin[

        this.verifSel();
    }

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

    @Override
    public void selectionner(int debut, int fin) {
        sel.setDeb(debut);
        sel.setFin(fin);

        this.verifSel();
    }

    @Override
    public void charger(Buffer b, Selection s) {
        this.buf = b;
        this.sel = s;

        this.verifSel();
    }

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

    private void verifDeb() {
        int deb = sel.getDeb();
        int bufLen = buf.getTxt().length();

        if (deb < 0) {
            sel.setDeb(0);
        } else if (deb > bufLen) {
            sel.setDeb(bufLen);
        }
    }

    private void verifFin() {
        int fin = sel.getFin();
        int bufLen = buf.getTxt().length();

        if (fin < 0) {
            sel.setFin(0);
        } else if (fin > bufLen) {
            sel.setFin(bufLen);
        }
    }

    @Override
    public Buffer getbuf() {
        return buf;
    }

    @Override
    public Selection getSel() {
        return sel;
    }

    @Override
    public PressePapier getPP() {
        return pp;
    }
}
