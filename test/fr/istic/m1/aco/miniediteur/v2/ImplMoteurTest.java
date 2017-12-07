package fr.istic.m1.aco.miniediteur.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 16009566 on 30/11/17.
 */
public class ImplMoteurTest {
    ImplMoteur engine;

    @Before
    public void init() {
        engine = new ImplMoteur();
    }

    @Test
    public void affiche() throws Exception {
        Buffer buf = engine.getbuf();
        Selection sel;
        String str = engine.affiche();
        assertTrue(str.equals("[["));

        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[["));

        buf = new Buffer("Test");
        sel = new Selection(4, 4);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("Test[["));

        sel = new Selection(3, 3);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("Tes[[t"));

        sel = new Selection(0, 4);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[Test["));

        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[[Test"));

        sel = new Selection(1, 3);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("T[es[t"));
    }

    @Test
    public void couper() throws Exception {
        Buffer buf;
        Selection sel;
        PressePapier pp = engine.getPP();

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.couper();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("Test");
        sel = new Selection(4, 4);
        engine.charger(buf, sel);
        engine.couper();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("Test"));
        assertTrue(sel.getDeb() == 4 && sel.getFin() == 4);

        buf = new Buffer("Test");
        sel = new Selection(0, 4);
        engine.charger(buf, sel);
        engine.couper();
        assertTrue(pp.getTxt().equals("Test"));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("12345");
        sel = new Selection(2, 3);
        engine.charger(buf, sel);
        engine.couper();
        assertTrue(pp.getTxt().equals("3"));
        assertTrue(buf.getTxt().equals("1245"));
        assertTrue(sel.getDeb() == 2 && sel.getFin() == 2);
    }

    @Test
    public void copier() throws Exception {
        Buffer buf;
        Selection sel;
        PressePapier pp = engine.getPP();

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.copier();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("123456");
        sel = new Selection(3, 3);
        engine.charger(buf, sel);
        engine.copier();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 3 && sel.getFin() == 3);

        buf = new Buffer("123456");
        sel = new Selection(0, 3);
        engine.charger(buf, sel);
        engine.copier();
        assertTrue(pp.getTxt().equals("123"));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 3);
    }

    @Test
    public void coller() throws Exception {
        Buffer buf;
        Selection sel;
        PressePapier pp = engine.getPP();

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.coller();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("123456");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.coller();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("123456");
        sel = new Selection(1, 5);
        engine.charger(buf, sel);
        engine.coller();
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("16"));
        assertTrue(sel.getDeb() == 1 && sel.getFin() == 1);

        buf = new Buffer("123456");
        sel = new Selection(1, 5);
        engine.charger(buf, sel);
        engine.copier();
        engine.coller();
        assertTrue(pp.getTxt().equals("2345"));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 5 && sel.getFin() == 5);

        buf = new Buffer("123456");
        sel = new Selection(6, 6);
        engine.charger(buf, sel);
        engine.coller();
        assertTrue(pp.getTxt().equals("2345"));
        assertTrue(buf.getTxt().equals("1234562345"));
        assertTrue(sel.getDeb() == 10 && sel.getFin() == 10);
    }

    @Test
    public void inserer() throws Exception {
        Buffer buf;
        Selection sel;
        PressePapier pp = engine.getPP();

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.inserer("");
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("123456");
        sel = new Selection(6, 6);
        engine.charger(buf, sel);
        engine.inserer("");
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.inserer("abc");
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("abc"));
        assertTrue(sel.getDeb() == 3 && sel.getFin() == 3);

        buf = new Buffer("123456");
        sel = new Selection(6, 6);
        engine.charger(buf, sel);
        engine.inserer("abc");
        assertTrue(buf.getTxt().equals("123456abc"));
        assertTrue(sel.getDeb() == 9 && sel.getFin() == 9);

        buf = new Buffer("123456");
        sel = new Selection(1, 5);
        engine.charger(buf, sel);
        engine.inserer("abc");
        assertTrue(buf.getTxt().equals("1abc6"));
        assertTrue(sel.getDeb() == 4 && sel.getFin() == 4);
    }

    @Test
    public void selectionner() throws Exception {
        Buffer buf;
        Selection sel;
        PressePapier pp = engine.getPP();

        buf = new Buffer("");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.selectionner(0,0);
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals(""));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        buf = new Buffer("123456");
        sel = new Selection(0, 0);
        engine.charger(buf, sel);
        engine.selectionner(0,0);
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        engine.selectionner(1,3);
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 1 && sel.getFin() == 3);

        engine.selectionner(3,1);
        assertTrue(pp.getTxt().equals(""));
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 1 && sel.getFin() == 3);

        engine.selectionner(-10,0);
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        engine.selectionner(0,100);
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 6);

        engine.selectionner(-100,-10);
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 0 && sel.getFin() == 0);

        engine.selectionner(10,100);
        assertTrue(buf.getTxt().equals("123456"));
        assertTrue(sel.getDeb() == 6 && sel.getFin() == 6);
    }

    @Test
    public void charger() throws Exception {
		Buffer buf = new Buffer("Testing148/*-+\"Test");
		Selection sel = new Selection(0,0);
		engine.charger(buf, sel);
		assertTrue(engine.getbuf().getTxt().equals("Testing148/*-+\"Test"));
		
		buf = new Buffer("Testing148/*-+\"Test");
		sel = new Selection(-84, -89);
		engine.charger(buf, sel);
		assertTrue(engine.getSel().getDeb() == 0 && engine.getSel().getFin() == 0);
		
		
    }
}
