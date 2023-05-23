/*
 * decouverte.java
 *                                     29/09/2022
 * IUT Rodez
 * pas de droits d'auteurs
 */

package iut.info1.decouverte;

/**
 * Découverte du fonctionnement de java et tests sur les notions
 * vu en cours 
 *
 * @author Quentin COSTES
 */

public class Decouverte {

    /**
    * Tests sur le typage et les types primitifs entiers
    */
    public static void main(String[] args){

        /* valeurs minimales et maximales des types primitfs */
        
	byte minByte = Byte.MIN_VALUE ;    // valeur minimale pour le type Byte
        byte maxByte = Byte.MAX_VALUE ;    // valeur maximale pour le type Byte

        System.out.println("La valeur minimale du type Byte est :" + minByte);
        System.out.println("La valeur maximale du type Byte est :" + maxByte);

        Short minShort = Short.MIN_VALUE ; // valeur minimale pour le type Short
        short maxShort = Short.MAX_VALUE ; // valeur maximale pour le type Short

        System.out.println("La valeur minimale du type Short est :" + minShort);
        System.out.println("La valeur maximale du type Short est :" + minShort);

        int minInt = Int.MIN_VALUE ;       // valeur minimale pour le type Int
        int maxInt = Int.MAX_VALUE ;       // valeur maximale pour le type Int

        System.out.println("La valeur minimale du type Int est :" + minInt);
        System.out.println("La valeur maximale du type Int est :" + minInt);

        long minLong = Long.MIN_VALUE ;    // valeur minimale pour le type Long
        long maxLong = Long.MAX_VALUE ;    // valeur maximale pour le type Long

        System.out.println("La valeur minimale du type Long est :" + minLong);
        System.out.println("La valeur maximale du type Long est :" + minLong);

    }

}
