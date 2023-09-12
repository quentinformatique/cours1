/*
 * Pile.java                                    2 juin 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.sdd;

/** TODO comment class responsibility (SRP)
 * @author quent
 *
 * @param <E>
 */
public interface Pile<E> {

    /**
     * Prédicat vérifiant que cette pile ne référence aucun élément
     * @return true si aucun élément empilé, false sinon
     */
    boolean isVide();

    /**
     * Ajoute un élément aAjouter au sommet de cette pile
     * <p>
     * Commande (style fonctionnel) modifiant l'état de this
     * @param aAjouter référence de l'élément à empiler (non nulle)
     * @return référence de cette pile après empilement (style fonctionnel)
     * @throws NullPointerException si aAjouter est null
     */
    default Pile<E> empiler(E aAjouter) {
        Pile.super.empiler(aAjouter);
        this.corps = new PileRecursive<E>(sommet, coprs);
        this.sommet = aAjouter;
        return this;
    }

    /**
     * Retire de cette pile la référence du dernier élément empilé
     * (dernier arrivé premier sorti DAPS)
     * <p>
     * Commande (fonctionnelle) modifiant l'état de cette pile
     * @return cette pile après "dépilement" (style fonctionnel)
     * @throws PileVideException si cette pile est vide
     */
    Pile<E> depiler();

    /**
     * Accès au dernier empilé sur cette pile
     * @return référence du dernier élément empilé
     * @throws PileVideException si cette pile est vide
     */
    E sommet();

}