/*
 * PileContigue.java            12/05/2023
 * IUT de Rodez
 */

package iut.info1.pile;

/**
 * colection d'objet a loi de gestion LIFO
 * @author Costes Quentin
 */
public class PileContigue {

    /** tableau avec tous les elements */
    private Object[] elementsEmpiles = {};

    /**
     * constructeur d'une nouvelle pile vide
     */
    public PileContigue() {}

    /**
     * Constructeur d'une nouvelle a partir d'un tableau d'objet
     */
    private PileContigue(Object[] pileExistante) {
        elementsEmpiles = new Object[pileExistante.length];

        for (int i = 0; i < pileExistante.length; i++) {
            elementsEmpiles[i] = pileExistante[i];
        }
    }
    /**
     * permet de vérifier si la pile est vide
     * 
     * @return true si la pile est vide
     *         false sinon
     */
    public boolean estVide() {
        return elementsEmpiles.length == 0; 
    }

    /**
     * Ajoute un element de type object a une pile
     * @param element l'element a ajouter
     * @return la pile modifiee
     */
    public PileContigue empiler(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Erreur  : "
                    + "On ne peut pas empiler un element null");
        }
        Object[] nouvellePile = new Object[elementsEmpiles.length + 1];
        
        for (int i = 0; i < elementsEmpiles.length; i++) {
            nouvellePile[i] = elementsEmpiles[i];
        }
        nouvellePile[elementsEmpiles.length] = element;
        elementsEmpiles = nouvellePile;
 
        return new PileContigue(nouvellePile);
    }

    /**
     * retire le dernier element de la pile
     * @return la pile modifiee
     * @throws PileVideException si cette pille est vide
     */
    public PileContigue depiler() {
        if (estVide()) {
            throw new PileVideException();
        }

        Object[] nouvellePile = new Object[elementsEmpiles.length - 1];

        for (int i = 0; i < nouvellePile.length; i++) {
            nouvellePile[i] = elementsEmpiles[i];
        }
        elementsEmpiles = nouvellePile;
        
        return new PileContigue(nouvellePile);
    }

    /**
     * méthode permettant de récupérer le sommet de la pile
     * si la pile est vide, 
     * @return le sommet de la pile
     * @throws ileVideException si cette pille est vide
     */
    public Object sommet() {
        if (estVide()) {
            throw new PileVideException();
        }
        return elementsEmpiles[elementsEmpiles.length-1];
    }
}
