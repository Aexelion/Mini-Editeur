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

public class PressePapierTest {
    PressePapier pp;
    @Before
    public void init() {
        pp = new PressePapier("");
    }
    @Test
    public void getTxt() throws Exception {
        String str = pp.getTxt();
        assertTrue(str.equals(""));

        pp = new PressePapier("123456");
        str = pp.getTxt();
        assertTrue(str.equals("123456"));
    }

    @Test
    public void setTxt() throws Exception {
        String str;

        pp.setTxt("");
        str = pp.getTxt();
        assertTrue(str.equals(""));

        pp.setTxt("123");
        str = pp.getTxt();
        assertTrue(str.equals("123"));

        pp.setTxt("456");
        str = pp.getTxt();
        assertTrue(str.equals("456"));
    }

    @Test
    public void Testclone() throws Exception {
        PressePapier clonePP = pp.clone();
        assertTrue(pp != clonePP);
        assertTrue(pp.getTxt().equals(clonePP.getTxt()));

        pp = new PressePapier("123456");
        clonePP = pp.clone();
        assertTrue(pp != clonePP);
        assertTrue(pp.getTxt().equals(clonePP.getTxt()));
    }

}