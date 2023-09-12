/*
 * PileContigue.java                                    12 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.sdd;

import java.util.Arrays;

/** 
 * Collection d'objets à loi de gestion LIFO = Last In First Out
 * <p>
 * Classe non immuable (collection)
 * @author info1 2022-2023
 * @param <E> type (polymorphe) des éléments empilés
 */
public class PileContigue<E> implements Pile<E> {
    
    /** Nombre max d'objets empilables initialement */
    private static final int CAPACITE_INITIALE = 10;
    
    /** représentation contigue = bloc des références des objets empilés */
    private E[] elements;
    
    /** nombre effectif d'objets empilés = indice du sommet +1 */
    private int taille;

    /** 
     * Initialisation d'une pile vide
     */
    public PileContigue() {
        elements = (E[]) new Object[CAPACITE_INITIALE];
        // taille = 0;  // pile vide
    }
    
    /* non javadoc - @see iut.info1.sdd.Pile#isVide() */
    @Override
    public boolean isVide() {
        return taille == 0; 
    }
    
    /* non javadoc - @see iut.info1.sdd.Pile#empiler(E) */
    @Override
    public Pile<E> empiler(E aAjouter) {
        if (aAjouter == null) {
            throw new NullPointerException("Impossible d'empiler la réf. null");
        }
        assurerCapacite();
        elements[taille] = aAjouter;
        taille++;
        return this;
    }
    
    /** 
     * Re-allouer un nouveau tableau en cas de saturation du tableau elements
     * avec recopie des anciens éléments
     */
    private void assurerCapacite() {
        final double GROSSISSEMENT = 1.30;  // 30% de capacité 
        if (taille == elements.length) {
            elements = Arrays.copyOf(elements, 
                                     (int)Math.ceil(taille * GROSSISSEMENT));
        } // else TODO réallouer un tableau plus petit
          //           si le taux de remplissage est trop faible
    }

    /* non javadoc - @see iut.info1.sdd.Pile#depiler() */
    @Override
    public Pile<E> depiler() {
        preConditionPileNonVide();
        taille--;
        return this;
    }

    /* non javadoc - @see iut.info1.sdd.Pile#sommet() */
    @Override
    public E sommet() {
        preConditionPileNonVide();
        return elements[taille -1];
    }

    /**
     * Vérifie une pré-condition non vide avant opération
     * @throws PileVideException si pile vide
     */
    private void preConditionPileNonVide() throws PileVideException {
        /* pré-condition : pile non vide */
        if (isVide()) {
            throw new PileVideException("pre-condition pile non vide échoue");
        }
    }
}
