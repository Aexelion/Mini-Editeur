/**
 * @file ImplIHMText.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @brief Classe implémentant l'IHM du MiniEditeur de façon textuelle
 */
public class ImplIHMText implements IHM {

    private Map<String,Commande> commandes;
    private Scanner scan;
    private Affiche affiche;

	/**
	 * @brief Constructeur préparant l'IHM textuelle et affectant son accès d'affichage au reste de l'Editeur
	 * @param a une classe Affiche permettant l'affichage du contenu d'un Moteur
	 */
    public ImplIHMText(Affiche a) {
        this.commandes = new HashMap<>();
        this.scan = new Scanner(System.in);
        this.affiche = a;
    }

	/**
	 * @brief Méthode ajoutant à l'IHM une commande donnée pour la mettre à disposition de l'utilisateur avec un nom donné
	 * @details Ne rajoute pas deux fois la même commande
	 * @param s le nom de la commande donnée à l'IHM pour l'affichage
	 * @param c la Commande a mettre à disposition de l'IHM
	 */
    @Override
    public void addCmd(String s, Commande c) {
        commandes.putIfAbsent(s, c);
    }

	/**
	 * @brief Méthode exécutant une Commande donnée en entrée
	 * @details Utilise le nom de la Commande telle que rentrée dans le HashMap et affiche un message d'erreur à l'utilisateur si la commande n'existe pas
	 * @param s un String du nom de la Commande à exécuter
	 */
    private void executeCommande(String s) {
        if (commandes.containsKey(s)){
            commandes.get(s).execute();
        }else{
            System.out.println("Commande " + s + " inexistante");
        }
    }

	/**
	 * @brief Méthode permettant d'afficher à l'utilisateur la liste des Commandes à sa disposition
	 */
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

	/**
     * @brief Opération lancant l'IHM et assurant son fonctionnement en boucle jusqu'à ce que le programme soit fermé par l'utilisateur
     * @details L'utilisateur peut fermer le programme en tapant "Exit"
     */
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

	/**
	 * @brief Méthode retournant un texte obtenu depuis l'utilisateur
	 * @return Un String contenant le texte obtenu de l'utilisateur
	 */
    @Override
    public String getText() {
        String str = scan.nextLine();
        return str;
    }

	/**
     * @brief Méthode retournant un entier obtenu depuis l'utilisateur
     * @return L'entier récupéré depuis l'utilisateur
     */
    @Override
    public int getInt() {
        int i = scan.nextInt();
        return i;
    }
}
