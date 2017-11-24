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
    public String affiche() throws UnsupportedOperationException {
        String txt = buf.getTxt();
        int deb = sel.getDeb(), fin = sel.getFin();

        String res = txt.substring(0,deb) + "[" + txt.substring(deb, fin) + "[" + txt.substring(fin);

        return res;
    }

    @Override
    public void couper() throws UnsupportedOperationException {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        pp.setTxt(txt.substring(debutSel,finSel)); //Ne vérifie pas si la sous-chaine est vide. Récupère la chaine [debut, fin[
        txt = txt.substring(0,debutSel) + txt.substring(finSel);

        sel.setFin(debutSel); //Place le curseur de sélection la où le texte a été couper

        buf.setTxt(txt);
    }

    @Override
    public void copier() throws UnsupportedOperationException {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        pp.setTxt(txt.substring(debutSel,finSel)); //Ne vérifie pas si la sous-chaine est vide. Récupère la chaine [debut, fin[
    }

    @Override
    public void coller() throws UnsupportedOperationException {
        String txt = buf.getTxt();
        String ajout = "";
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        ajout = pp.getTxt();
        txt = txt.substring(0,debutSel) + ajout + txt.substring(finSel);

        sel.setFin(debutSel + ajout.length()); //Place le curseur de sélection après le texte qui vient d'être inséré
        sel.setDeb(finSel);

        buf.setTxt(txt);
    }

    @Override
    public void inserer(String s) throws UnsupportedOperationException {
        String txt = buf.getTxt();
        int debutSel = sel.getDeb();
        int finSel = sel.getFin();

        txt = txt.substring(0,debutSel) + s + txt.substring(finSel);


        sel.setFin(debutSel + s.length()); //Place le curseur de sélection après le texte qui vient d'être inséré
        sel.setDeb(finSel);

        buf.setTxt(txt);
    }

    @Override
    public void selectionner(int debut, int fin) throws UnsupportedOperationException {
        sel.setDeb(debut);
        sel.setFin(fin);
    }

    @Override
    public void charger(Buffer b, Selection s) {
        this.buf = b;
        this.sel = s;
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
