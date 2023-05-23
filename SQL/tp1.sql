"afficher tout les voyages"
SELECT *
FROM VACANCES.tvoyage;

"afficher tout les noms voyages"
SELECT appellation
FROM VACANCES.tvoyage;

"afficher tout les noms voyages distinct"
SELECT DISTINCT(appellation)
FROM VACANCES.tvoyage;

SELECT DISTINCT(appellation)
FROM VACANCES.tvoyage
ORDER BY appellation;

"trier les voyage par durée "
SELECT DISTINCT appellation, dateret-datedep+1
FROM VACANCES.tvoyage
ORDER BY dateret-datedep+1 DESC;

"trier les voyages moins cher"
SELECT appellation, prixadulte
FROM VACANCES.tvoyage
ORDER BY prixadulte ASC;

"afficher LE voyage le moins cher"
SELECT appellation
FROM VACANCES.tvoyage
WHERE prixadulte=(SELECT MIN(prixadulte) FROM vacances.tvoyage)

"au chimborazo madame marsenac a perdue sa brosse 
a dents est ce que ça peut etre encore un coup de Kidjo
(est ce que kidjo est passer au kidjorado ?)"
