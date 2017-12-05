package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Coller implements CommandeEnregistrable {

    private Moteur engine;
    private Enregistreur recorder; //V2
    private GestionnaireDefaireRefaire gest; //V3

    public Coller(Moteur engine, Enregistreur recorder, GestionnaireDefaireRefaire gest){
        this.engine = engine;
        this.recorder = recorder; //V2
        this.gest = gest; //V3
    }

    @Override
    public void execute() {
        engine.coller();
        recorder.enregistrer(this); //V2
        gest.appelCmd(this); //V3
    }

	/**
     * @brief Implémentation vierge de la méthode getMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     * @note N'ayant pas de sauvegarde du texte à copier pour réutiliser Coller dans une action Refaire il faut au préalable avoir enregistré soit Copier soit Couper.
     * @return Un null comme Coller n'a pas de sauvegarde
     */
    @Override
    public Memento getMemento() { //V2
        return null;
    }

	/**
     * @brief Implémentation vierge de la méthode setMemento car l'action Coller n'a pas de sauvegarde du texte à copier
     */
    @Override
    public void setMemento(Memento m) { //V2

    }
}
