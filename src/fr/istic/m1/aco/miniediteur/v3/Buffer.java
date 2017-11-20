package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 20/10/17.
 */
public class Buffer {

    private String txt;

    public Buffer(String s){
        this.txt = s;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public Buffer clone(){
        return new Buffer(txt);
    }

}
