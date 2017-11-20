package fr.istic.m1.aco.miniediteur.v3;

import java.util.Stack;

/**
 * Created by 16009566 on 20/11/17.
 */
public class ImplGestionnaire implements GestionnaireDefaireRefaire{

    private class Etat{
        final Buffer buf;
        final Selection sel;
        final PressePapier pp;

        public Etat(Buffer b, Selection s, PressePapier p){
            this.buf = b;
            this.sel = s;
            this.pp = p;
        }
    }

    Moteur engine;
    Stack<Etat> pileFait;
    Stack<Etat> pileARefaire;

    public ImplGestionnaire(Moteur engine){
        this.engine = engine;
        pileFait = new Stack<>();
        pileARefaire = new Stack<>();
    }

    @Override
    public void defaire() {
        if (!pileFait.isEmpty()){
            Etat e = pileFait.pop();
            engine.charger(e.buf, e.sel, e.pp);
            pileARefaire.add(e);
        }
    }

    @Override
    public void refaire() {
        if (!pileARefaire.isEmpty()){
            Etat e = pileARefaire.pop();
            engine.charger(e.buf, e.sel, e.pp);
            pileFait.add(e);
        }
    }

    @Override
    public void appelCmd(Commande c) {
        if (!pileARefaire.isEmpty()){
            pileARefaire.clear();
        }

        Buffer newBuf = engine.getbuf().clone();
        Selection newSel = engine.getSel().clone();
        PressePapier newPP = engine.getPP().clone();

        Etat tmp = new Etat(newBuf, newSel, newPP);
        pileFait.push(tmp);
    }
}
