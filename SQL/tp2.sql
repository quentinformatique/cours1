"en juillet 2022 , combien de reasa et pour combien d'adultes"

SELECT count(*), SUM(NBADULTES)
FROM VACANCES.tresa
WHERE dateresa BETWEEN '01/07/22' AND '30/07/22'

"Afficher les voyages qui se font en
 autriche ou en du Italie du Nord "

SELECT *
FROM VACANCES.tvoyage
WHERE zone = 'Autriche' OR zone = 'Italie du nord'

"Y a-t-il des clients du Tarn"

SELECT nom, prenom
FROM VACANCES.ttouriste
WHERE codepostal LIKE '81%'

"Afficher les voyages qui sont proposés au enfants"

SELECT * 
FROM VACANCES.tvoyage
WHERE prixenfant IS NULL

"Presenter le code de toutes les agences sauf celles de rodez"

SELECT * 
FROM VACANCES.tagence
WHERE ville != 'Rodez'

"Quelles sont toutes les zones 
géographiques ou se deroulent les voyages"

SELECT DISTINCT(zone)
FROM VACANCES.tvoyage

"Afficher les reservation de Francois Fabié"

SELECT * 
FROM VACANCES.tresa
JOIN VACANCES.ttouriste ON vacances.tresa.codetr =  vacances.ttouriste.idtr
WHERE vacances.tresa.codetr =
(SELECT idtr 
FROM vacances.ttouriste 
WHERE nom = 'FABIE' AND prenom = 'Francois')

"Afficher les voyages prvus ou réalisés par les habitants de Cransac"



"afficher le voyage le plus cher(prixadult)"
SELECT * 
FROM VACANCES.tvoyage
WHERE prixadulte = (SELECT MAX(prixadulte) FROM VACANCES.tvoyage)