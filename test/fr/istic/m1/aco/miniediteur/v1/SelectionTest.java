/**
 * @file Affiche.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionTest {
    Selection sel;

    @Before
    public void init() {
        sel = new Selection(0,0);
    }

    @Test
    public void getDeb() throws Exception {
        int test = sel.getDeb();
        assertTrue(test == 0);

        sel = new Selection(10,20);
        test = sel.getDeb();
        assertTrue(test == 10);

        sel = new Selection(20,0);
        test = sel.getDeb();
        assertTrue(test == 20);
    }

    @Test
    public void setDeb() throws Exception {
        sel.setDeb(1);
        int debut = sel.getDeb();
        int fin = sel.getFin();
        assertTrue(debut == 1);

        sel.setDeb(10);
        debut = sel.getDeb();
        assertTrue(debut == 10 && fin == 0);
    }

    @Test
    public void getFin() throws Exception {
        int test = sel.getFin();
        assertTrue(test == 0);

        sel = new Selection(10,20);
        test = sel.getFin();
        assertTrue(test == 20);

        sel = new Selection(20,0);
        test = sel.getFin();
        assertTrue(test == 0);
    }

    @Test
    public void setFin() throws Exception {
        sel.setFin(1);
        int debut = sel.getDeb();
        int fin = sel.getFin();
        assertTrue(fin == 1);

        sel.setFin(10);
        fin = sel.getFin();
        assertTrue(debut == 0 && fin == 10);
    }

    @Test
    public void Testclone() throws Exception {
        Selection cloneSel = sel.clone();
        assertTrue(sel != cloneSel);
        assertTrue(sel.getDeb() == cloneSel.getDeb() && sel.getFin() == cloneSel.getFin());

        sel = new Selection(10,12);
        cloneSel = sel.clone();
        assertTrue(sel != cloneSel);
        assertTrue(sel.getDeb() == cloneSel.getDeb() && sel.getFin() == cloneSel.getFin());
    }

}