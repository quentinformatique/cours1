/*
 * PersonneTest.java                                    9 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.population.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.datation.Date;
import iut.info1.population.Personne;

/** TODO comment class responsibility (SRP)
 * @author quent
 *
 */
class PersonneTest {
    
    private List<Personne> correctes;
    
    @BeforeEach
    public void genererjeuxTest() {
        correctes = new ArrayList<>(10);
        
        Date date1 = new Date(1, 1, 1850);
        Date date2 = new Date(2, 2, 1900);
        Date date3 = new Date(3, 3, 1950);
        Date date4 = new Date(4, 4, 1975);
        Date date5 = new Date(5, 5, 1985);
        Date date6 = new Date(6, 6, 1995);
        Date date7 = new Date(7, 7, 2000);
        Date date8 = new Date(8, 8, 2020);
        Date date9 = new Date(9, 9, 2050);
        Date date10 = new Date(10, 10, 2100);

        correctes.add(new Personne("210246501249067", "Dupont", "Jean-Paul", date1));
        correctes.add(new Personne("278127906624910", "Martin", "Sophie", date2));
        correctes.add(new Personne("140162854103812", "García", "Pablo", date3));
        correctes.add(new Personne("193857930460125", "L'Écuyer", "Julie", date4));
        correctes.add(new Personne("207104715678905", "Bernard", "Lucas", date5));
        correctes.add(new Personne("239016247832471", "Dubois", "Marie", date6));
        correctes.add(new Personne("284619071584296", "Lavigne", "Thiery", date7));
        correctes.add(new Personne("162388523048763", "Moreau", "Amélie", date8));
        correctes.add(new Personne("121547896315478", "O'Brien", "Patrick", date9));
        correctes.add(new Personne("298317632541297", "Smith", "John", date10));

 
    }

    /**
     * Test method for {@link iut.info1.population.Personne#compareTo(iut.info1.population.Personne)}.
     */
    @Test
    void testCompareTo() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link iut.info1.population.Personne#getNoNIR()}.
     */
    @Test
    void testGetNoNIR() {
        final String[] NIR_OK = { 
                "210246501249067", "278127906624910", "140162854103812",
                "193857930460125", "207104715678905", "239016247832471",
                "284619071584296", "162388523048763", "121547896315478",
                "298317632541297"
        };
        
        for (int i = 0; i < NIR_OK.length; i++) {
            assertEquals(NIR_OK[i], correctes.get(i).getNoNIR());
        }
    }
    /**
     * Test method for {@link iut.info1.population.Personne#getNom()}.
     */
    @Test
    void testGetNom() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link iut.info1.population.Personne#getPrenom()}.
     */
    @Test
    void testGetPrenom() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link iut.info1.population.Personne#getNaissance()}.
     */
    @Test
    void testGetNaissance() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link iut.info1.population.Personne#toString()}.
     */
    @Test
    void testToString() {
        fail("Not yet implemented");
    }

}
