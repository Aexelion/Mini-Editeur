package fr.istic.m1.aco.miniediteur.v2;

/**
 * Created by 16009566 on 20/10/17.
 */
public class MementoSelectionner implements Memento {

    private int deb;
    private int fin;

    public MementoSelectionner(int deb, int fin){
        this.deb = deb;
        this.fin = fin;
    }

    public int getDeb(){
        return deb;
    }

    public int getFin(){
        return fin;
    }

}
