/* BLG.01 : Quel est le poids du gateau le plus lourd ? */
SELECT nom, poids
FROM tgateau
WHERE poids = (SELECT MAX(poids)
               FROM tgateau);


/* BLG.02 : Présenter la list edes viennoiseries de manière à  voir les vienoniseries  les plus chères en premier. */

SELECT nom
FROM tgateau
ORDER BY prix DESC;


/* BLG.03 : Quel sont les gâteaux fabriqués avec de la " farine de petit épautre " ? */

SELECT nom
FROM tgateau
JOIN tcompose
ON tgateau.idgateau = tcompose.codegateau
JOIN taliment
ON tcompose.codealim = taliment.idalim
WHERE taliment.nomalim = 'farine de petit épautre';


/* BLG.04 : Quels sont les gâteaux pastelmin ? */

SELECT nom
FROM tgateau
JOIN tcompose
ON tgateau.idgateau = tcompose.codegateau
WHERE (SELECT SUM(codealim)
       FROM tcompose
       GROUP BY codealim) BETWEEN (5,6);


/* BLG.05 : Quelles sont les catégories de gâteaux contenant un laitage ? */

SELECT categorie
FROM tgateau
WHERE codepat LIKE '%L%'


/* BLG.06 : Parmi les aliments, il y a des épices et des arômes, affichez-les */

SELECT nomalim
FROM taliment
WHERE type IN ('épices', 'arômes')


/* BLG.07 : Y a-t-il des viennoiseries qui coûtent plus chers que des gâteaux individuels ? */

SELECT nom
FROM tgateau
WHERE categorie = 'viennoiseries'
AND pventettc > (SELECT MIN(pventettc)
                 FROM tgateau
                 WHERE categorie = 'individuel');


/* BLG.08 : Afficher le prix moyen hors taxe des gâteaux contenant des épices */
SELECT AVG(pventettc), nom
FROM tgateau
JOIN tcompose
ON tgateau.idgateau = tcompose.codegateau
JOIN taliment
ON tcompose.codealim = taliment.idalim
WHERE taliment.type = 'épices';


/* BLG.09 : Afficher la liste des types d'aliments */

SELECT DISTINCT type
FROM taliment


/* BLG.10 : Afficher les gâteaux sans gluten */

SELECT nom
FROM tgateau
JOIN tcompose
ON tgateau.idgateau = tcompose.codegateau
JOIN taliment
ON tcompose.codealim = taliment.idalim
WHERE taliment.gluten IS NULL;