package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ImplEnregistreurTest {
	ImplEnregistreur recorder;
	ImplMoteur engine;

	Copier copier;
	Couper couper;
	Coller coller;
	Inserer inserer;
	Selectionner selectionner;

	@Before
	public void init () {
		recorder = new ImplEnregistreur();
		engine = new ImplMoteur();

		Affiche a = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(a);

		copier = new Copier(engine, recorder);
		couper = new Couper(engine, recorder);
		coller = new Coller(engine, recorder);
		inserer = new Inserer(engine, gui, recorder);
		selectionner = new Selectionner(engine, gui, recorder);
	}

	@Test
	public void testFonctions() throws Exception {
		MementoInserer mementoIns = new MementoInserer("123456");
		MementoSelectionner mementoSel = new MementoSelectionner(0,6);

		recorder.demarrer();
		inserer.setMemento(mementoIns);
		inserer.execute();
		selectionner.setMemento(mementoSel);
		selectionner.execute();
		copier.execute();
		mementoSel = new MementoSelectionner(6,6);
		selectionner.setMemento(mementoSel);
		selectionner.execute();
		coller.execute();
		recorder.stopper();

		Buffer buf = engine.getbuf();
		Selection sel = engine.getSel();
		PressePapier pp = engine.getPP();
		assertTrue(buf.getTxt().equals("123456123456"));
		assertTrue(sel.getDeb() == 12 && sel.getFin() == 12);
		assertTrue(pp.getTxt().equals("123456"));

		mementoSel = new MementoSelectionner(0,12);
		selectionner.setMemento(mementoSel);
		selectionner.execute();
		couper.execute();
		couper.execute();

		buf = engine.getbuf();
		sel = engine.getSel();
		pp = engine.getPP();
		assertTrue(buf.getTxt().equals(""));
		assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);
		assertTrue(pp.getTxt().equals(""));

		recorder.rejouer();

		buf = engine.getbuf();
		sel = engine.getSel();
		pp = engine.getPP();
		assertTrue(buf.getTxt().equals("123456123456"));
		assertTrue(sel.getDeb() == 12 && sel.getFin() == 12);
		assertTrue(pp.getTxt().equals("123456"));

		recorder.demarrer();
		recorder.stopper();
		recorder.rejouer();

		buf = engine.getbuf();
		sel = engine.getSel();
		pp = engine.getPP();
		assertTrue(buf.getTxt().equals("123456123456"));
		assertTrue(sel.getDeb() == 12 && sel.getFin() == 12);
		assertTrue(pp.getTxt().equals("123456"));
	}
}
