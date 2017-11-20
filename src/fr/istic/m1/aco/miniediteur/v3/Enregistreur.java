package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public interface Enregistreur {
    public void demarrer();
    public void stopper();
    public void rejouer();
    public void enregistrer(CommandeEnregistrable c);
}
