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
    private Affiche affiche;

    public ImplIHMText(Affiche a) {
        this.commandes = new HashMap<>();
        this.scan = new Scanner(System.in);
        this.affiche = a;
    }

    @Override
    public void addCmd(String s, Commande c) {
        commandes.putIfAbsent(s, c);
    }

    private void executeCommande(String s) {
        if (commandes.containsKey(s)){
            commandes.get(s).execute();
        }else{
            System.out.println("Commande " + s + " inexistante");
        }
    }

    private void listCommande() {
        if (!commandes.isEmpty()) {
            int i = 1;
            for (Map.Entry<String, Commande> c : commandes.entrySet()) {
                System.out.println("Commande " + i + " : " + c.getKey());
                i++;
            }
        }else{
            System.out.println("Aucune commande existante");
        }
    }

    @Override
    public void execution() {
        System.out.println("Choisir une commande a executer.");
        listCommande();
        System.out.println("Entrer 'Exit' pour quitter l'editeur");
        System.out.println(affiche.execute());
        String cmd = scan.nextLine();

        while (!cmd.equalsIgnoreCase("Exit")){
            executeCommande(cmd);
            System.out.println("Choisir une commande a executer.");
            listCommande();
            System.out.println("Entrer 'Exit' pour quitter l'editeur");
            System.out.println(affiche.execute());
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
