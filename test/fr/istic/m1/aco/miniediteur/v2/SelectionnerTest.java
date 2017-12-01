package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionnerTest {

	private Selectionner tested;
	
	@Before
	public void setUp() {
		Moteur engine = new ImplMoteur();
		IHM gui = new ImplIHMText();
		Enregistreur recorder = new ImplEnregistreur();
		
		tested = new Selectionner(engine, gui, recorder);
	}

	@Test
	public void setMementoNormalTest() throws Exception {
		MementoSelectionner m = new MementoSelectionner(1,2);
		tested.setMemento(m);
		assertTrue(tested.getMemento().getDeb() == 1 && tested.getMemento().getFin() == 2);
	}
	
	@Test (expected = IllegalArgumentException)
	public void setMementoMauvaisMemento() throws Exception {
		MementoInserer m = new MementoInserer("test");
		tested.setMemento(m);
	}
}
