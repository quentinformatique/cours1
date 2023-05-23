/*
 * FonctionsReelles.java                             6 feb. 2023
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.mathematiques;

/**
 * 
 * @author info1 TP2
 */
public class FonctionsReelles {

    /**
     * Elevation d'un flottant à une puissance entière naturelle
     * TODO cas particuliers
     * @param x nombre à exponentier
     * @param n exposant (positif ou nul)
     * @return <ul><li>x puissance n si calculable</li>
     *             <li>TODO cas NaN ou Infinis</li>
     *         </ul>
     * @throws IllegalArgumentException si n négatif
     */
    public static double puissance(double x, int n) {
        // TODO ecrire le corps
        if (n < 0) {
            throw new IllegalArgumentException("Exposant <0 non utilisable");
        }
        // else
        return 1.0; // bouchon
    }
}