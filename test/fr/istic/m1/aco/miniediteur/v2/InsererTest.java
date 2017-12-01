package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsererTest {

	private Inserer tested;
	
	@Before
	public void setUp() {
		Moteur engine = new ImplMoteur();
		Affiche a = new Affiche(engine);
		IHM gui = new ImplIHMText(a);
		Enregistreur recorder = new ImplEnregistreur();
		
		tested = new Inserer(engine, gui, recorder);
	}

	@Test
	public void setMementoNormalTest() throws Exception {
		MementoInserer m = new MementoInserer("test");
		tested.setMemento(m);
		MementoInserer mementoIns = (MementoInserer) tested.getMemento();
		assertTrue(mementoIns.getText() == "test");
		
		m = new MementoInserer("");
		tested.setMemento(m);
		mementoIns = (MementoInserer) tested.getMemento();
		assertTrue(mementoIns.getText() == "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setMementoMauvaisMemento() throws Exception {
		MementoSelectionner m = new MementoSelectionner(4,2);
		tested.setMemento(m);
	}
}
