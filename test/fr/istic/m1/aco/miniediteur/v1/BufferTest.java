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

public class BufferTest {
    Buffer buf;

    @Before
    public void init() {
        buf = new Buffer("");
    }

    @Test
    public void getTxt() throws Exception {
        String str = buf.getTxt();
        assertTrue(str.equals(""));

        buf = new Buffer("123456");
        str = buf.getTxt();
        assertTrue(str.equals("123456"));
    }

    @Test
    public void setTxt() throws Exception {
        String str;

        buf.setTxt("");
        str = buf.getTxt();
        assertTrue(str.equals(""));

        buf.setTxt("123");
        str = buf.getTxt();
        assertTrue(str.equals("123"));

        buf.setTxt("456");
        str = buf.getTxt();
        assertTrue(str.equals("456"));
    }

    @Test
    public void Testclone() throws Exception {
        Buffer cloneBuf = buf.clone();
        assertTrue(buf != cloneBuf);
        assertTrue(buf.getTxt().equals(cloneBuf.getTxt()));

        buf = new Buffer("123456");
        cloneBuf = buf.clone();
        assertTrue(buf != cloneBuf);
        assertTrue(buf.getTxt().equals(cloneBuf.getTxt()));
    }

}