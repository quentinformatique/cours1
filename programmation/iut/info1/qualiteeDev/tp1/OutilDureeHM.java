/*
* Différents traitements les durées exprimées en heures et minutes
* OutilDureeHM.java 
*/

package iut.info1.qualiteeDev.tp1;

import java.util.Scanner;

/**
* Traitements sur les durées exprimées en heures et minutes. Pour être valides, 
* les minutes doivent être comprises entre 0 et 59, et les heures supérieures à  0.
* 
* Une durée est représentée par un tableau de 2 entiers : à l'indice 0 les heures
* et à l'indice 1 les minutes.
* 
* @author INFO1
* @version 1.0
*/
public class OutilDureeHM {

   
   /**
    * Affiche une durée exprimée en heures, minutes et secondes
    * @param duree tableau de 2 entiers contenant les heures et les minutes    */
    public static void afficher(int[] duree) {

		if (!(estValide(duree))) {
			throw new IllegalArgumentException("La durée argument est invalide");
		}
		System.out.println(duree[0] + " heure(s) " + duree[1] + " minute(s) ");
    }

    /**
     * Affiche une durée exprimée en heures, minutes et secondes
     * @param duree tableau de 2 entiers contenant les heures et les minutes
     */
    public static boolean estValide(int[] duree) {

        return 0 <= duree[0] && 0 <= duree[1] && duree[1] <= 59;
    }

	/**
	 * renvoie la somme de deux durées exprimées en heures et minutes
	 * @param durree1 tableau de 2 entiers contenant les heures et les minutes
	 * @param durree2 tableau de 2 entiers contenant les heures et les minutes
	 * @return tableau de 2 entiers contenant les heures et les minutes
	 * @throws IllegalArgumentException si une des durées est invalide
	 */
    public static int[] somme2Durees(int[] durree1, int[] durree2) {

        if (!(estValide(durree1) && estValide(durree2))) {
            throw new IllegalArgumentException("Calcul de la somme impossible. L’une des 2 durées est invalide");
        }
        int[] somme = new int[2];
        somme[0] = durree1[0] + durree2[0];
        somme[1] = durree1[1] + durree2[1];
        if (somme[1] >= 60) {
            somme[0] += 1;
            somme[1] -= 60;
        }
        return somme;
    }

}
