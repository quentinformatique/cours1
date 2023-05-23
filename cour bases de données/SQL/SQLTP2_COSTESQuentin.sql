/* Par equipe équipe de 2 avec Groupe : Quentin Costes, Simon Guiraud, Tom Douaud */

/* SCOL 40 : Consulter les notes de vos étudiants, des étudiants du binôme. Une
attention particulière sera portée à la présentation et l’on pourra voir regroupées
toutes les notes de chacun des étudiants.*/

SELECT lecodeetudiant , note
FROM tnote
GROUP BY lecodeetudiant;

SELECT lecodeetudiant , note
FROM bd119.tnote
GROUP BY lecodeetudiant;


 /* SCOL 41 : Que se passe-t-il ? Comment remédier à cela ? */

-- n'yant pas les droits , je ne peut pas voir les données des tables
-- de mon binome , pour remedier a cela il faut qu'il me donne les droits
-- de selection avec un :

GRANT SELECT
ON tnote TO bd115;


/* SCOL 42 : Mettre à jour une note d’un de vos étudiants. Un seul ordre de base de
données, i.e une seule requête, est autorisé. */

UPDATE tnote
SET note = 16
WHERE idnote = '2';


/* SCOL 43 : Demander à votre binôme de consulter les notes de l’étudiant sur lequel
vous avez effectué la mise à jour. */

SELECT note
FROM bd119.tnote
WHERE idnote = '2';


/* SCOL 44. Que voit-il ? Pourquoi ? Comment remédier à ce problème ? */

-- il voit les anciennes les valeures car ma transaction n'a pas etée validée ,
-- celle ci est isolée mais pas encore publique 
-- afin de voir les nouvelles valeurs , je doit faire un COMMIT


/* SCOL 45 : Votre binôme doit pouvoir saisir des notes dans votre « espace » de
bases de données mais pas des étudiants. */

GRANT INSERT
ON tnote TO bd119;


/* SCOL 46 : Montrer que la demande précédente a bien été prise en compte. */

SELECT *
FROM bd119.tetudiant;


/* 47 Votre binôme doit maintenant non plus pouvoir saisir des notes mais modifier des notes. */

REVOKE SELECT
ON bd115.matiere
FROM bd119;

GRANT UPDATE
ON tnote TO bd119;


/* SCOL 48 : Montrer que la demande précédente a bien été prise en compte. */

UPDATE bd119.tnote
SET note = 4
WHERE idnote = '2';
 
 
/* SCOL 49 : Montrer que des modifications sur une même note peut conduire à un
blocage. Comment y remédier. */


--si on viens modifier la note d'un etudiant et qu'on demander au copain de
--modifier la note de ce meme etudiant ,
--la requete ne s'effectue pas , car il y a un conflit entre les deux transactions .
--la solution serait que la personne effectuant la requete en premier fasse un commit ou un rollback
--si commit : c'est le premier changement qui est effectuer
--si rollback c'est le second qui est effectuer


/* SCOL 50 : Effectuer à deux plusieurs manipulations sur la BD pour pratiquer LMD &
gestion des droits. */

UPDATE bd119.tnote
SET commentaire = 'Super bien !'
WHERE idNote ='1';

REVOKE ALL
ON bd115.tnote
FROM bd119;

UPDATE bd119.tnote
SET note = 1
WHERE idNote ='1';

GRANT INSERT 
ON tetudiant TO bd119;


 