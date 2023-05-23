/*
 * Assertions.java                             6 feb. 2023
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */

package iut.info1.iutUnit;

/**
 * 
 * @author info1 TP2
 */
public class Assertions {

    /**
     * Assertion verifiant si le resultat attendu est bien Vrai
     * @param obtenu expression a tester
     * @param message String du message d'erreur
     * @throws Exception si echec du test
     */
    public static  void assurerVrai(boolean obtenu, String message) 
    throws Exception {

        assurerFaux(!obtenu, message);
    }

    /**
     * Assertion verifiant si le resultat attendu est bien Faux
     * @param obtenu expression a tester
     * @param message String du message d'erreur
     * @throws Exception si echec du test
     */
    public static  void assurerFaux(boolean obtenu, String message) 
    throws Exception {

        if (obtenu) {
            throw new Exception("Echec de test : " + message);
        }
    }

    /**
     * Assertion verifiant si le double attendu est egal au double obtenu
     * Avec les cas particulies suivants :
     * <ul><li>Nan est égal à NaN</li>
     *     <li>0.0 est égal à 0.0 mais different de -0.0</li>
     *     <li>POSITIVE_INFINITY n'est égal qu'a lui même</li>
     *     <li>NEGATIVE_INFINITY n'est égal qu'a lui même</li>
     * </ul>
     * @param obtenu résultat obtenu
     * @param attendu résultat attendu
     * @param message String du message d'erreur
     * @throws Exception si echec du test
     */
    public static  void assurrerEgalite(double obtenu, double attendu, String message) 
    throws Exception {

        // TODO ecrire le corp
        throw new Exception("Echec de test : " + message);
    } 
}