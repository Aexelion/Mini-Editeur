package fr.istic.m1.aco.miniediteur.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 16009566 on 09/11/17.
 */
public class ImplIHMText implements IHM {

    Map<String,Commande> commandes = new HashMap<>();

    public void executeCommande(String s){
        if (commandes.containsKey(s)){
            commandes.get(s).execute();
        }else{
            System.out.println("Commande " + s + " inexistante");
        }
    }

    public void listCommande(){
        if (!commandes.isEmpty()) {
            int i = 0;
            for (Map.Entry<String, Commande> c : commandes.entrySet()) {
                System.out.println("Commande " + i + " : " + c.getKey());
                i++;
            }
        }else{
            System.out.println("Aucune commande existante");
        }
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public int getInt() {
        return 0;
    }
}
