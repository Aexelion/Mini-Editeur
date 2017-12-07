package fr.istic.m1.aco.miniediteur.v3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InsererTest {

	private Inserer tested;

	@Before
	public void setUp() {
		Moteur engine = new ImplMoteur();
		Affiche a = new Affiche(engine);
		IHM gui = new ImplIHMText(a);
		Enregistreur recorder = new ImplEnregistreur();
		GestionnaireDefaireRefaire gest = new ImplGestionnaire(engine);

		tested = new Inserer(engine, gui, recorder, gest);
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
