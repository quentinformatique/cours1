/*
 * TestPileContigue.java                                    23 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.sdd.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.sdd.Pile;
import iut.info1.sdd.PileContigue;
import iut.info1.sdd.PileVideException;

/** 
 * Tests unitaires de iut.info1.sdd.PileContigue
 * @author info1 2022-2023
 */
class TestPileContigue {
    
    /* fixture de test */
    private Pile<Double> lifoVide = new PileContigue<>();
    
    private Pile<Integer> pileEntier;
    
    private Pile<String> pileTexte;
    
    private Pile<Number> grandePile;
    
    @BeforeEach
    void creerFixturePilesNonVides() {
        
        pileEntier = new PileContigue<>();
        pileEntier.empiler(Integer.valueOf(12));
        pileEntier.empiler(Integer.valueOf(-3));
        
        pileTexte = new PileContigue<>();
        pileTexte.empiler("un");
        pileTexte.empiler("deux");
        pileTexte.empiler("trois");
        
        grandePile =  new PileContigue<>();
        for (int valeur = 1 ; valeur <= 100000 ; valeur++) {
            grandePile.empiler(Integer.valueOf(valeur));
        }
    }

    /**
     * Test method for {@link iut.info1.sdd.PileContigue#PileContigue()}.
     */
    @Test
    void testPileContigue() {
        assertTrue(new PileContigue<Scanner>().isVide());
        assertFalse(pileTexte.isVide());
    }

    /**
     * Test method for {@link iut.info1.sdd.PileContigue#isVide()}.
     */
    @Test
    void testIsVide() {
        assertTrue(lifoVide.isVide());
        assertFalse(pileEntier.isVide());
    }

    /**
     * Test method for {@link iut.info1.sdd.PileContigue#empiler(java.lang.Object)}.
     */
    @Test
    void testEmpiler() {
        assertThrows(NullPointerException.class, 
                     ()->pileTexte.empiler(null));
        
        Pile<Number> grande =  new PileContigue<Number>();
        for (int valeur = 1 ; valeur <= 100000 ; valeur++) {
            final Integer nombre = Integer.valueOf(valeur);
            assertDoesNotThrow(()->grande.empiler(nombre));
        }
    }

    /**
     * Test method for {@link iut.info1.sdd.PileContigue#depiler()}.
     */
    @Test
    void testDepiler() {
        assertThrows(PileVideException.class, ()->lifoVide.depiler());
        for (int valeur = 100000 ; valeur >= 1 ; valeur--) {
            assertEquals(Integer.valueOf(valeur), grandePile.sommet());
            grandePile.depiler();
        }
        assertTrue(grandePile.isVide());
    }

    /**
     * Test method for {@link iut.info1.sdd.PileContigue#sommet()}.
     */
    @Test
    void testSommet() {
        assertThrows(PileVideException.class, ()->lifoVide.sommet());
        assertEquals(Integer.valueOf(-3), pileEntier.sommet());
        pileEntier.depiler();
        assertEquals(Integer.valueOf(12), pileEntier.sommet());
        
        assertEquals("trois", pileTexte.sommet());
    }

}
