package iut.info1.pile.tests;

import static org.junit.jupiter.api.Assertions.*;

import iut.info1.pile.*;

import org.junit.jupiter.api.Test;

class PileContigueTest {

        @Test
        void testConstructeur() {
                assertDoesNotThrow(()-> new PileContigue());
               
        }

        
        @Test
        void testEmpiler() {
                PileContigue p = new PileContigue();
                assertDoesNotThrow(()->p.empiler("bonjour"));
                assertDoesNotThrow(()->p.empiler(true));
                assertDoesNotThrow(()->p.empiler(1));
                assertThrows(IllegalArgumentException.class, ()->p.empiler(null));
        }

        @Test
        void testDepiler() {
                PileContigue p = new PileContigue();
                p = p.empiler(126).empiler(2);

                assertFalse(p.depiler().estVide());
                assertTrue(p.depiler().estVide());
        }

        @Test
        void testEstVide() {
                PileContigue p1 = new PileContigue();
                PileContigue p2 = new PileContigue().empiler("bonsoir");

                assertTrue(p1.estVide());
                assertFalse(p2.estVide());
        }

        @Test
        void testSommet() {
                PileContigue p = new PileContigue();
                p = p.empiler(1).empiler("2").empiler(true);

                assertEquals(p.sommet(), true);
                p.depiler();
                assertEquals(p.sommet(), "2");
                p.depiler();
                assertEquals(p.sommet(), 1);
                p.depiler();

                PileContigue temp = p;
                
                assertThrows(PileVideException.class, 
                                         ()-> temp.sommet());

        }


}
