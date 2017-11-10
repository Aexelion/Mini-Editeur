package fr.istic.m1.aco.miniediteur.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 16009566 on 09/11/17.
 */
public class ImplIHMText implements IHM {

    private Map<String,Commande> commandes = new HashMap<>();
    private Scanner scan = new Scanner(System.in);

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
        String str = scan.nextLine();
        return str;
    }

    @Override
    public int getInt() {
        int i = scan.nextInt();
        return i;
    }
}
