/*
 * TestDate.java                                    29 mars 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.datation.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.datation.Date;

/** test de la classe Date avec JUnit
 * @author quentin.costes
 *
 */
class TestDate {
    
    private List<Date> correctes;
    
    @BeforeEach
    public void genererjeuxTest() {
        correctes = new ArrayList<>(12);
        correctes.add(new Date(1, 1, 1850));
        correctes.add(new Date(30, 3, 2023));
        correctes.add(new Date(31, 3, 2023));
        correctes.add(new Date(30, 4, 1895));
        correctes.add(new Date(30, 6, 1897));
        correctes.add(new Date(30, 9, 1999));
        correctes.add(new Date(30, 11, 2095));
        correctes.add(new Date(28, 2, 2023));
        correctes.add(new Date(29, 2, 2004));
        correctes.add(new Date(29, 2, 2000));
        correctes.add(new Date(7, 10, 2023));
        correctes.add(new Date(11, 5, 1983));
        correctes.add(new Date(3, 12, 1977));
    }
    
    @Test
    void testGetJour() {
        final int[] JOUR_OK
        = { 1, 30, 31, 30, 30, 30, 30, 28, 29, 29, 7, 11, 3 };
        
        for (int noTest = 0 ; noTest < correctes.size() ; noTest ++) {
            assertEquals(JOUR_OK[noTest], correctes.get(noTest).getJj());
        }
    }
    
    @Test
    void testGetMois() {
        final int[] MOIS_OK
        = { 1, 3, 3, 4, 6, 9, 11, 2, 2, 2, 10, 5, 12 };
        
        for (int noTest = 0 ; noTest < correctes.size() ; noTest ++) {
            assertEquals(MOIS_OK[noTest], correctes.get(noTest).getMm());
        }
    }
    
    @Test
    void testDateHashCode() {
        
        final int[] HASHCODE_OK = { 
                18500101, 20230330, 20230331, 18950430, 18970630, 19990930,
                20951130, 20230228, 20040229, 20000229, 20231007, 19830511,
                19771203
        };
        
        for (int noTest = 0 ; noTest < correctes.size() ; noTest ++) {
            assertEquals(HASHCODE_OK[noTest], correctes.get(noTest).hashCode());
        }
    }
    
    @Test
    void testGetAnnee() {
        final int[] ANNEE_OK
        = { 1850, 2023, 2023, 1895, 1897, 1999, 2095,
            2023, 2004, 2000, 2023, 1983, 1977};
        
        for (int noTest = 0 ; noTest < correctes.size() ; noTest ++) {
            assertEquals(ANNEE_OK[noTest], correctes.get(noTest).getAaaa());
        }
    }
    
    
    @Test
    void testDateToString() {
        final String[] STRING_OK
        = { "1/1/1850", "30/3/2023", "31/3/2023", "30/4/1895", "30/6/1897",
            "30/9/1999", "30/11/2095", "28/2/2023", "29/2/2004", "29/2/2000", 
            "7/10/2023", "11/5/1983", "3/12/1977"
        };
        
        for (int noTest = 0 ; noTest < correctes.size() ; noTest ++) {
            assertEquals(STRING_OK[noTest], correctes.get(noTest).toString());
        }
    }

    
    @Test
    void testDateEquals() {
        Date date1,
             date2;
        
        date1 = new Date(16, 12, 2004);
        date2 = new Date(16, 12, 2004);
        assertTrue(date1.equals(date2));
        date1 = new Date(1, 4, 2015);
        date2 = new Date(1, 4, 2015);
        assertTrue(date1.equals(date2));
        date1 = new Date(31, 12, 1900);
        date2 = new Date(31, 12, 1900);
        assertTrue(date1.equals(date2));
    }
    
    @Test 
    void testDateDifferenceAnnee() { 
        Date date1,
             date2;
   
        date1 = new Date(16, 12, 2000);
        date2 = new Date(16, 12, 2004);
        assertEquals(4, date1.differenceAnnee(date2));
        date1 = new Date(10, 10, 2020);
        date2 = new Date(19, 2, 2020);
        assertEquals(0, date1.differenceAnnee(date2));
        date1 = new Date(31, 12, 2050);
        date2 = new Date(1, 1, 1900);
        assertEquals(150, date1.differenceAnnee(date2));
    }
    
    @Test
    void testDateNOk() {
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 12, -1));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 12, 1849));
        assertThrows(IllegalArgumentException.class, ()->new Date(1, 1, 2101));
        assertThrows(IllegalArgumentException.class, ()->new Date(3, 0, 1910));
        assertThrows(IllegalArgumentException.class, ()->new Date(17, 13, 2020));
        assertThrows(IllegalArgumentException.class, ()->new Date(0, 1, 2000));
        assertThrows(IllegalArgumentException.class, ()->new Date(-1, 12, 2023));
        assertThrows(IllegalArgumentException.class, ()->new Date(32, 2, 2023));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 2, 2023));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 4, 2005));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 6, 1997));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 9, 1870));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 11, 2020));
        assertThrows(IllegalArgumentException.class, ()->new Date(30, 2, 1920));
        assertThrows(IllegalArgumentException.class, ()->new Date(29, 2, 2001));
    }

}
