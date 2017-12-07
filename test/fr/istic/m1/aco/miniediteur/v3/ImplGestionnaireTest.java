package fr.istic.m1.aco.miniediteur.v3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 16009566 on 01/12/17.
 */
public class ImplGestionnaireTest {
    ImplGestionnaire gest;
    ImplMoteur engine;

    Copier copier;
    Couper couper;
    Coller coller;
    Inserer inserer;
    Selectionner selectionner;

    @Before
    public void init () {
        engine = new ImplMoteur();
        gest = new ImplGestionnaire(engine);

        Affiche a = new Affiche(engine);
        ImplIHMText gui = new ImplIHMText(a);
        ImplEnregistreur recorder = new ImplEnregistreur();

        copier = new Copier(engine, recorder);
        couper = new Couper(engine, recorder, gest);
        coller = new Coller(engine, recorder, gest);
        inserer = new Inserer(engine, gui, recorder, gest);
        selectionner = new Selectionner(engine, gui, recorder, gest);
    }

    @Test
    public void defaire() throws Exception {
        MementoInserer mementoIns = new MementoInserer("123456");
        MementoSelectionner mementoSel = new MementoSelectionner(0,6);

        inserer.setMemento(mementoIns);
        inserer.execute();
        selectionner.setMemento(mementoSel);
        selectionner.execute();
        copier.execute();

        Buffer buf = engine.getbuf();
        Selection sel = engine.getSel();
        PressePapier pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);
        assertTrue(pp.getTxt().equals("123456"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);
        assertTrue(pp.getTxt().equals("123456"));

        coller.execute();
        mementoSel = new MementoSelectionner(4,6);
        selectionner.setMemento(mementoSel);
        selectionner.execute();
        couper.execute();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("1234"));
        assertTrue(sel.getDeb() == 4 && sel.getFin() == 4);
        assertTrue(pp.getTxt().equals("56"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 4 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("56"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("56"));

        gest.defaire();
        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);
        assertTrue(pp.getTxt().equals("56"));
    }

    @Test
    public void refaire() throws Exception {
        MementoInserer mementoIns = new MementoInserer("123456");
        MementoSelectionner mementoSel = new MementoSelectionner(0,6);

        inserer.setMemento(mementoIns);
        inserer.execute();
        selectionner.setMemento(mementoSel);
        selectionner.execute();
        copier.execute();

        Buffer buf = engine.getbuf();
        Selection sel = engine.getSel();
        PressePapier pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        gest.defaire();
        gest.defaire();
        gest.defaire();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);
        assertTrue(pp.getTxt().equals("123456"));

        gest.refaire();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        gest.refaire();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        gest.defaire();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);
        assertTrue(pp.getTxt().equals("123456"));

        mementoSel = new MementoSelectionner(3,5);
        selectionner.setMemento(mementoSel);
        selectionner.execute();

        gest.refaire();

        buf = engine.getbuf();
        sel = engine.getSel();
        pp = engine.getPP();
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 3 && sel.getFin() == 5);
        assertTrue(pp.getTxt().equals("123456"));
    }

}