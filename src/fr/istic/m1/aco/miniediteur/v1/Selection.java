package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 20/10/17.
 */
public class Selection {

    private int deb = 0;
    private int fin = 0;

    public Selection(int d, int f){
        this.deb = d;
        this.fin = f;
    }

    public int getDeb(){
        return deb;
    }

    public void setDeb(int deb) {
        this.deb = deb;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    @Override
    public Selection clone(){
        return new Selection(deb, fin);
    }


}
