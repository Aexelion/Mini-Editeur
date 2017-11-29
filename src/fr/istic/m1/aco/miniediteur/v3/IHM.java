package fr.istic.m1.aco.miniediteur.v3;

public interface IHM {
    public void addCmd(String nomCmd, Commande cmd);
    public void execution();
	public String getText();
    public int getInt();
}
