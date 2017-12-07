package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionnerTest {

	private Selectionner tested;
	
	@Before
	public void setUp() {
		Moteur engine = new ImplMoteur();
		Affiche a = new Affiche(engine);
		IHM gui = new ImplIHMText(a);
		Enregistreur recorder = new ImplEnregistreur();
		
		tested = new Selectionner(engine, gui, recorder);
	}

	@Test
	public void setMementoNormalTest() throws Exception {
		MementoSelectionner m = new MementoSelectionner(1,2);
		tested.setMemento(m);
		MementoSelectionner mementoSel = (MementoSelectionner) tested.getMemento();
		assertTrue(mementoSel.getDeb() == 1 && mementoSel.getFin() == 2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setMementoMauvaisMemento() throws Exception {
		MementoInserer m = new MementoInserer("test");
		tested.setMemento(m);
	}
}
