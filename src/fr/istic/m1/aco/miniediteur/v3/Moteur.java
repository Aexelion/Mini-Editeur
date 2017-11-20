package fr.istic.m1.aco.miniediteur.v3;

public interface Moteur {
	public void couper() throws UnsupportedOperationException;
	public void copier() throws UnsupportedOperationException;
	public void coller() throws UnsupportedOperationException;
	public void inserer(String s) throws UnsupportedOperationException;
	public void selectionner(int debut, int fin) throws UnsupportedOperationException;
	public void charger(Buffer b, Selection s, PressePapier p);
	public Buffer getbuf();
	public Selection getSel();
	public PressePapier getPP();
}
