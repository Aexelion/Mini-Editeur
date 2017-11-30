package fr.istic.m1.aco.miniediteur.v1;

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

        sel = new Selection(-1, 10);
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

        sel = new Selection(4, 0);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[Test["));

        sel = new Selection(-1, 10);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[Test["));

        sel = new Selection(-1, -10);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("[[Test"));

        sel = new Selection(42, 10);
        engine.charger(buf, sel);
        str = engine.affiche();
        assertTrue(str.equals("Test[["));
    }

    @Test
    public void couper() throws Exception {

    }

    @Test
    public void copier() throws Exception {

    }

    @Test
    public void coller() throws Exception {

    }

    @Test
    public void inserer() throws Exception {

    }

    @Test
    public void selectionner() throws Exception {

    }

    @Test
    public void charger() throws Exception {
		Buffer buf = new Buffer("Testing148/*-+\"Test");
		Selection sel = new Selection(0,0);
		engine.charger(buf, sel);
		assertTrue(engine.getbuf().getText().equals("Testing148/*-+\"Test"));
		
		Buffer buf = new Buffer("Testing148/*-+\"Test");
		Selection sel = new Selection(-84, -89);
		engine.charger(buf, sel);
		assertTrue(engine.getSel().getDeb() == 0 && engine.getSel().getFin() == 0);
		
		
    }

    @Test
    public void getbuf() throws Exception {
		// Acesseur, pas de tests ?
    }

    @Test
    public void getSel() throws Exception {
		// Accesseur, pas de tests ?
    }

    @Test
    public void getPP() throws Exception {
		// Accesseur, pas de tests ?
    }

}
