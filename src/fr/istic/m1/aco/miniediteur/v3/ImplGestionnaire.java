package fr.istic.m1.aco.miniediteur.v3;

import java.util.Stack;

/**
 * Created by 16009566 on 20/11/17.
 */
public class ImplGestionnaire implements GestionnaireDefaireRefaire{

    private class Etat{
        final Buffer buf;
        final Selection sel;

        public Etat(Buffer b, Selection s){
            this.buf = b;
            this.sel = s;
        }
    }

    private Moteur engine;
    private Stack<Etat> pileFait;
    private Stack<Etat> pileARefaire;

    private final Etat init = new Etat(new Buffer(""), new Selection(0,0));
    private Etat courant;

    public ImplGestionnaire(Moteur engine){
        this.engine = engine;
        pileFait = new Stack<>();
        pileARefaire = new Stack<>();
        courant = init;
    }

    @Override
    public void defaire() {
        if (!pileFait.isEmpty()){
            Etat e = pileFait.pop();
            engine.charger(e.buf, e.sel);
            pileARefaire.add(courant);
            courant = e;
        } else {
            engine.charger(init.buf, init.sel);
            courant = init;
        }
    }

    @Override
    public void refaire() {
        if (!pileARefaire.isEmpty()){
            Etat e = pileARefaire.pop();
            engine.charger(e.buf, e.sel);
            pileFait.add(courant);
            courant = e;
        }
    }

    @Override
    public void appelCmd(Commande c) {
        if (!pileARefaire.isEmpty()){
            pileARefaire.clear();
        }

        Buffer newBuf = engine.getbuf().clone();
        Selection newSel = engine.getSel().clone();

        Etat tmp = new Etat(newBuf, newSel);
        pileFait.push(courant);
        courant = tmp;
    }
}
