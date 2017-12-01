package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsererTest {

	private Inserer tested;
	
	@Before
	public void setUp() {
		Moteur engine = new ImplMoteur();
		IHM gui = new ImplIHMText();
		Enregistreur recorder = new ImplEnregistreur();
		
		tested = new Inserer(engine, gui, recorder);
	}

	@Test
	public void setMementoNormalTest() throws Exception {
		MementoInserer m = new MementoInserer("test");
		tested.setMemento(m);
		assertTrue(tested.getMemento().getText() == "test");
		
		MementoInserer m = new MementoInserer("");
		tested.setMemento(m);
		assertTrue(tested.getMemento().getText() == "");
	}
	
	@Test (expected = IllegalArgumentException)
	public void setMementoMauvaisMemento() throws Exception {
		MementoSelectionner m = new MementoSelectionner(4,2);
		tested.setMemento(m);
	}
}
