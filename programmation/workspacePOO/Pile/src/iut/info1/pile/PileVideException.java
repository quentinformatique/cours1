/*
 * PileVideException.java                                    23 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.pile;

/** Exception levée si opération sur pile ne respecte pas
 *  une pré-condition pile non vide
 * @author quentin costes
 *
 */
public class PileVideException extends RuntimeException{
    
    /** Numéro de version du .class pour la "sérialisation" */
    private static final long serialVersionUID = 1L;
    
    /**
     * Exception dans description de la cause
     */
    public PileVideException() {
        super();
    }
    
    /** Description textuelle de l'exception
     * @param message description de la cause de cette exception
     */
    public PileVideException(String message) {
        super(message);
    }

}
