package fr.istic.m1.aco.miniediteur.v1;

import java.util.*;

/**
 * Created by 16009566 on 27/10/17.
 */
public class ImplEnregistreur implements Enregistreur {

    private boolean enrEnCours = false;
    private List<Commande> macro = new ArrayList<Commande>(); //Une seule macro enregistrable à la fois
    //TODO une classe interne contenant une paire (Command,Memento)

    @Override
    public void demarrer() {

    }

    @Override
    public void stopper() {

    }

    @Override
    public void rejouer() {

    }

    @Override
    public void enregistrer(Commande c) {

    }
}
