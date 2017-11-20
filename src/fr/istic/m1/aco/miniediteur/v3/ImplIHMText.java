package fr.istic.m1.aco.miniediteur.v3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 16009566 on 09/11/17.
 */
public class ImplIHMText implements IHM {

    private Map<String,Commande> commandes;
    private Scanner scan;

    public ImplIHMText() {
        this.commandes = new HashMap<>();
        this.scan = new Scanner(System.in);
    }

    private void executeCommande(String s){
        if (commandes.containsKey(s)){
            commandes.get(s).execute();
        }else{
            System.out.println("Commande " + s + " inexistante");
        }
    }

    private void listCommande(){
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

    public void execution(){
        System.out.println("Choisir une commande a executuer.");
        listCommande();
        System.out.println("Entrer 'Exit' pour quitter l'editeur");
        String cmd = scan.nextLine();

        while (cmd != "Exit"){
            executeCommande(cmd);
            System.out.println("Choisir une commande a executuer.");
            listCommande();
            System.out.println("Entrer 'Exit' pour quitter l'editeur");
            cmd = scan.nextLine();
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
