/*
 * TestTarifSpectacleJunit.java                                    7 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package semestre2.gestiontest.spectacle;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** TODO comment class responsibility (SRP)
 * @author quentin.costes
 *
 */
class TestTarifSpectacleJunit {

    /** Valeur du code spectacle, pour le jeu de test contenant des valeurs correctes */
    private static final char[] SPECTACLE = {
        'T', 'T', 'T', 'T', 
        'O', 'O', 'O', 'O',
        'C', 'C', 'C', 'C', 
        'D', 'D', 'D', 'D'
    };

    /** Valeur du code catégorie, pour le jeu de test contenant des valeurs correctes */
    private static final char[] CATEGORIE = {
        'S', 'E', 'M', 'P', 
        'S', 'E', 'M', 'P',
        'S', 'E', 'M', 'P', 
        'S', 'E', 'M', 'P'
    };

    /** Valeur du boolean adherent, pour le jeu de test contenant des valeurs correctes */
    private static final  boolean[] ADHERENT = {
        true, false, true, false,
        false, true, false, true,
        true, false, true, false, 
        false, true, false, true
    };

    /** Valeur du résultat attendu, pour le jeu de test contenant des valeurs correctes */
    private static final int[] RESULTAT = {
        14, 17, 21, 25,
        24, 21, 28, 32,
        16, 19, 23, 27,
        21 ,18, 25, 26
    };
    
    /** Valeur du code spectacle, pour le jeu de tests avec valeurs incorrectes */
    private static char[] SPECTACLE_ERR = {'T', 'O', 'C', 'D', 'I', 't', 'c', '5' };

    /** Valeur du code catégorie, pour le jeu de tests avec valeurs incorrectes */
    private static char[] CATEGORIE_ERR = {'i', 'a', '5', 'x', 'ç', 'I', 'Q', '8'};

    /** Valeur du booléen adhérent, pour le jeu de tests avec valeurs correctes */
    private static boolean[] ADHERENT_ERR = {
    true, false, true, false, true, false, true, false, true }; 
    
    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
    }

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }
    
    @Test
    void testPrixAPayer() {
        for (int i = 0; i < SPECTACLE.length; i++) {
            assertEquals(RESULTAT[i], 
                         TarifSpectacle.prixAPayer(SPECTACLE[i], CATEGORIE[i], ADHERENT[i]));
        }
    }
    
    @Test
    void testPrixAPayerFaux() {
        for (int i = 0; i < SPECTACLE.length; i++) {
            assertThrows(TarifSpectacle.prixAPayer(SPECTACLE_ERR[i],
                                                   CATEGORIE_ERR[i],
                                                   ADHERENT_ERR[i]));
        }
    }
}
