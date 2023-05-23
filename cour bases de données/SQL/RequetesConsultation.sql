/* Vac 01 Afficher les voyages qui se déroulent en Autriche ou en Italie du Nord. */

SELECT *
FROM VACANCES.tvoyage
WHERE zone = 'Autriche' OR zone = 'Italie du nord'

/* Vac 02 Y a-t-il des clients dans le Tarn ?*/

SELECT nom, prenom
FROM VACANCES.ttouriste
WHERE codepostal LIKE '81%'

/* Vac 03 En juillet 2022, combien y-a-t-il eu de réservations et pour combien d’adultes ?*/

SELECT count(*), SUM(NBADULTES)
FROM VACANCES.tresa
WHERE dateresa BETWEEN '01/07/22' AND '30/07/22'

/* Vac 04 Afficher les voyages qui ne sont pas proposés aux enfants (pas de prix enfant).*/

SELECT * 
FROM VACANCES.tvoyage
WHERE prixenfant IS NULL

/* Vac 05 Présenter le code de toutes les agences sauf celles de Rodez.*/

SELECT siret 
FROM VACANCES.tagence
WHERE ville != 'Rodez'

/* Vac 06 Dans quelles zones géographiques se déroulent les voyages ?*/

SELECT DISTINCT(zone)
FROM VACANCES.tvoyage

/* Vac 07 Afficher les réservations de François Fabié.*/

SELECT * 
FROM VACANCES.tresa
JOIN VACANCES.ttouriste ON vacances.tresa.codetr =  vacances.ttouriste.idtr
WHERE vacances.tresa.codetr =
(SELECT idtr 
FROM vacances.ttouriste 
WHERE nom = 'FABIE' AND prenom = 'Francois') 

/* Vac 08 Afficher les voyages prévus ou réalisés par les habitants de Cransac.*/

SELECT *
FROM VACANCES.tresa
JOIN VACANCES.ttouriste
ON tresa.codetr = ttouriste.idtr
WHERE ttouriste.ville = 'Cransac'

/* Vac 09 Afficher le voyage le plus cher (on considérera le prix adulte).*/

SELECT * 
FROM VACANCES.tvoyage
WHERE prixadulte = (SELECT MAX(prixadulte) FROM VACANCES.tvoyage)

/* Vac 10 Afficher la zone où l’on trouve le plus de voyages.*/

SELECT zone
FROM VACANCES.tvoyages
GROUP BY zone
HAVING COUNT(*)=(SELECT MAX(COUNT(*))
				FROM VACANCES.tvoyages
				GROUP BY zone)


/* Vac 11 Quel est le nombre de clients qui ne sont ni du Tarn ni de l’Aveyron.*/

SELECT COUNT(*)
FROM VACANCES.ttouriste
WHERE CODEPOSTAl NOT LIKE '12%' AND CODEPOSTAL NOT LIKE '81%'

/* Vac 12 Quel est le nombre de clients par ville ?*/

SELECT ville , COUNT(*)
FROM vacances.ttouriste
GROUP BY ville

/* Vac 13 Afficher les voyages en Asie qui coûtent plus chers que des voyages en Amérique du Sud.*/

SELECT DISTINCT asie.appellation , Asie.prixadulte
FROM VACANCES.tvoyage Asie, VACANCES.tvoyage AmSud
WHERE Asie.zone = 'Asie'
AND AmSud.zone = 'Amérique du Sud'
AND Asie.prixadulte > AmSud.prixadulte



/* Vac 14 Afficher les voyages en Asie qui coûtent plus chers que tous ceux d’Amérique du Sud.*/

SELECT DISTINCT appellation
FROM VACANCES.tvoyage
WHERE zone = 'Asie' 
AND prixadulte > ALL(SELECT prixadulte FROM VACANCES.tvoyage WHERE zone = 'Amérique du Sud')

/* Vac 15 Afficher les touristes qui disposent d'une agence dans leur ville. Requête 1.*/

SELECT ttouriste.nom , ttouriste.prenom
FROM VACANCES.ttouriste
JOIN vacances.tagence
ON vacances.ttouriste.ville = VACANCES.tagence.ville
WHERE ttouriste.ville = tagence.ville

/* Vac 16 Afficher les touristes qui disposent d'une agence dans leur ville. Requête 2.*/

SELECT nom , prenom
FROM VACANCES.ttouriste
WHERE EXISTS (SELECT ville FROM VACANCES.tagence WHERE ttouriste.ville = tagence.ville)

/* Vac 17 Afficher les touristes qui disposent d'une agence dans leur ville. Requête 3.*/

SELECT nom , prenom
FROM VACANCES.ttouriste
WHERE ville IN (SELECT ville FROM VACANCES.tagence)

/* Vac 18 Afficher les touristes qui ont effectué des réservations en juin 2022.*/

SELECT DISTINCT ttouriste.idtr , ttouriste.nom , ttouriste.prenom
FROM VACANCES.ttouriste
JOIN VACANCES.tresa
ON VACANCES.ttouriste.idtr = vacances.tresa.codetr
WHERE vacances.tresa.dateresa BETWEEN '01/06/2022' AND '30/06/2022'

/* Vac 19 Afficher les touristes qui n’ont effectué des réservations qu’en juin 2022.*/

SELECT DISTINCT ttouriste.idtr , ttouriste.nom , ttouriste.prenom
FROM VACANCES.ttouriste
JOIN VACANCES.tresa
ON VACANCES.ttouriste.idtr = vacances.tresa.codetr
WHERE vacances.tresa.dateresa BETWEEN '01/06/2022' AND '30/06/2022' 
AND vacances.tresa.dateresa NOT BETWEEN '01/01/2022' AND '01/06/2022' 
AND vacances.tresa.dateresa NOT BETWEEN '30/06/2022' AND '29/12/2022' 

/* Vac 20 Afficher les clients de Rodez ou de Millau en les affichant par ordre alphabétique inversé.*/

SELECT nom, prenom
FROM VACANCES.ttouriste
WHERE codepostal IN ('12000','12100')
ORDER BY nom DESC

/* Vac 21 Afficher les clients dont le nom contient la lettre A comme deuxième caractère.*/

SELECT nom 
FROM ttouriste
WHERE nom LIKE '_A%'

/* Vac 22 Quelles sont les villes où la compagnie n’est pas implantée alors que l’on y trouve pourtant
des clients ?*/

SELECT ville
FROM VACANCES.ttouriste
WHERE ville NOT IN (SELECT ville 
					FROM VACANCES.tagence)

/* Vac 23 Afficher la liste des agences groupées par ville.*/

SELECT nom, siret, ville
FROM VACANCES.tagence
ORDER BY ville


/* Vac 24 Quels sont les voyages offrant plus de 5 destinations ?*/

SELECT appellation
FROM VACANCES.tvoyage
JOIN VACANCES.tprogramme 
ON VACANCES.tvoyage.idvg = VACANCES.tprogramme.idvg
GROUP BY vacances.tvoyage.appellation
HAVING COUNT(*) > 5

/* Vac 25 Quels sont les voyages pour lesquels on trouve un départ en novembre et un départ en
décembre 2022 ?*/

SELECT appellation
FROM VACANCES.tvoyage
WHERE datedep BETWEEN '01/11/2022' AND '29/11/2022' 
AND datedep BETWEEN '01/12/2022' AND '29/12/2022'


/* Vac 26 Quels sont les montants des réservations du touriste ayant pour numéro ed5817.*/

SELECT montantpaye
FROM VACANCES.tresa
WHERE codetr = 'ed5817'

/* Vac 27 Quels sont les voyages de plus de 10 jours ?*/

SELECT * 
FROM VACANCES.tvoyage
WHERE (dateret-datedep) > 10

/* Vac 28 Quels sont les zones dont la durée moyenne des voyages est de plus de 10 jours ?*/

SELECT zone
FROM VACANCES.tvoyage
GROUP BY zone
HAVING AVG(dateret-datedep) > 10

/* Vac 29 Quels sont les voyages qui sont faits sur plusieurs pays ?*/



/* Vac 30 Afficher les informations touristiques dont on dispose sur le Chili.*/

SELECT infotour
FROM VACANCES.tdestination
WHERE pays = 'CHILI'


/* Vac 31 Afficher les touristes qui sont allés à Antofagasta près du célèbre désert d’Atacama.*/



/* Vac 32 Afficher les voyages qui passent par un des 4 villages du plateau de l’Aubrac : Laguiole,
SaintUrcize, Aubrac ou Nasbinals en triant ces voyages.*/
