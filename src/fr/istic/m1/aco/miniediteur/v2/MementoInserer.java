package fr.istic.m1.aco.miniediteur.v2;

/**
 * Created by 16009566 on 13/10/17.
 */
public class MementoInserer implements Memento {

    private String text;

    public MementoInserer (String str){
        text = str;
    }

    public String getText(){
        return this.text;
    }
}
