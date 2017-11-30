package fr.istic.m1.aco.miniediteur.v3;

public interface Moteur {
	public String affiche();
	public void couper();
	public void copier();
	public void coller();
	public void inserer(String s);
	public void selectionner(int debut, int fin);
	public void charger(Buffer b, Selection s);
	public Buffer getbuf();
	public Selection getSel();
	public PressePapier getPP();
}
