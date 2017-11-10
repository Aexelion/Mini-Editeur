package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 20/10/17.
 */
public class Defaire implements Commande {

    private GestionnaireDefaireRefaire gest;

    public Defaire(GestionnaireDefaireRefaire gest){
        this.gest = gest;
    }

    @Override
    public void execute() {
        gest.defaire();
    }
}
