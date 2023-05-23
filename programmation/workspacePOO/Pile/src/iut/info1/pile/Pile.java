/*
 * Pile.java                                    12 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.pile;

/** TODO comment class responsibility (SRP)
 * @author quent
 *
 */
public class Pile {
    
    private Object[] pile;
    
    /** Constructeur de Pile
     * 
     */
    public Pile() {
        // TODO faire le constructeur
    }
    
    /** Verifie si une pile est vide
     * @return true si pile vide false sinon
     */
    public boolean estVide() {
        return this.pile.length == 0;
        
    }
    
    /** empile un objet a la Pile
     * @param aAjouter
     * @return Pile modifiée
     */
    public Pile empiler(Object aAjouter) {
        // TODO finir
        this.pile += aAjouter;
        return this.pile;
        
    }
    
    /** TODO comment method role
     * @return
     */
    public Object[] getPile() {
        return this.pile;
    }

}
