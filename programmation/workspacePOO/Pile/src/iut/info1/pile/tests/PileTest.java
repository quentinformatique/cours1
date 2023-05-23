/*
 * PileTest.java                                    12 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.pile.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import iut.info1.pile.Pile;

/** TODO comment class responsibility (SRP)
 * @author quent
 *
 */
class PileTest {

    @Test
    void testConstructeur() {
        assertDoesNotThrow(()-> new Pile());
    }

}
