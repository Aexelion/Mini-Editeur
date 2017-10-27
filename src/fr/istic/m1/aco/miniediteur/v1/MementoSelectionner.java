package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 20/10/17.
 */
public class MementoSelectionner implements Memento{

    private int deb;
    private int fin;

    public MementoSelectionner(int debut, int fin){
        this.deb = debut;
        this.fin = fin;
    }

    public int getDeb(){
        return deb;
    }

    public int getFin(){
        return fin;
    }

}
