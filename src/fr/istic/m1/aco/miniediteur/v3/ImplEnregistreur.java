package fr.istic.m1.aco.miniediteur.v3;

import java.util.*;

/**
 * Created by 16009566 on 27/10/17.
 */
public class ImplEnregistreur implements Enregistreur {

    private class Paire{
        private CommandeEnregistrable cmd;
        private Memento m;

        public Paire (CommandeEnregistrable cmd, Memento m){
            this.cmd = cmd;
            this.m = m;
        }

        public CommandeEnregistrable getCommande(){
            return this.cmd;
        }

        public Memento getMemento(){
            return this.m;
        }
    }

    private boolean enrEnCours = false;
    private List<Paire> macro = new ArrayList<Paire>(); //Une seule macro enregistrable à la fois

    @Override
    public void demarrer() {
        if(!enrEnCours){
            macro.clear();
            enrEnCours = true;
        }
    }

    @Override
    public void stopper() {
        if(enrEnCours){
            enrEnCours = false;
        }
    }

    @Override
    public void rejouer() {
        for (Paire p : macro){
            CommandeEnregistrable cmd = p.getCommande();
            Memento m = p.getMemento();
            cmd.setMemento(m);
            cmd.execute();
        }
    }

    @Override
    public void enregistrer(CommandeEnregistrable c) {
        if (enrEnCours) {
            Memento m = c.getMemento();
            Paire tmp = new Paire(c,m);
            macro.add(tmp);
        }
    }
}
