CREATE TABLE tetudiant
(
ine CHAR(8) CONSTRAINT pk_ine PRIMARY KEY,
nom VARCHAR(30) NOT NULL,
prenom  VARCHAR(30) NOT NULL,
datenaiss DATE NOT NULL,
rue VARCHAR(30),
ville VARCHAR(30) NOT NULL,
codepostal CHAR(5) NOT NULL,
telephone CHAR(10) UNIQUE,
email VARCHAR(40) NOT NULL
)
;
CREATE TABLE tnote
(
idnote NUMERIC(10) CONSTRAINT pk_note PRIMARY KEY,
note NUMERIC(4,2) CONSTRAINT ck_note CHECK (note BETWEEN 0 AND 20),
matiere VARCHAR(30) NOT NULL,
datenote DATE NOT NULL,
lecodeetudiant CHAR(8) NOT NULL CONSTRAINT fk_note_etudiant REFERENCES tetudiant(ine)
)



/* SCOL 0.2 */

ALTER TABLE tnote ADD commentaire CLOB NOT NULL;

/* SCOL 0.3 */

ALTER TABLE tnote 
ADD CONSTRAINT ck_matiere 
CHECK (matiere IN('Bases de données','Programtion','Résaux','IHM','Web'));


/* SCOL 0.4 */

/* 
La contrainte sur les matieres impose une liste de matieres donc on suprime
le check , on creer une table des matieres afini de rajouter des matieres ,
dans la table des notes on va rajouter une contrainte fk pour que toutes les 
notes saisies soit faites sur une matiere presente dans la table des matieres
*/

ALTER TABLE tnote DROP CONSTRAINT ck_matiere;

CREATE TABLE matiere 
(
idMatiere CHAR(8) CONSTRAINT pk_matiere PRIMARY KEY,
nomMatirere VARCHAR(50) NOT NULL
);

ALTER TABLE tnote 
MODIFY ( matiere CHAR(8) CONSTRAINT fk_matiere REFERENCES matiere(idMatiere));

/* SCOL 0.5 */

INSERT INTO tetudiant
VALUES ('00000001','Douaud','Tom','17/05/2005','Avenue je sais pas','Rodez','12000','0795356472','tom.douaud@iut-rodez.fr');
INSERT INTO tetudiant
VALUES ('00000002','Guiraud','Simon','04/06/2004','Rue aucune idées','Rodez','12000','0699358473','simon.guiraud@iut-rodez.fr');

/* SCOL 0.6 */

INSERT INTO matiere
VALUES ('00000001','Bases de donnees');
INSERT INTO matiere
VALUES ('00000002','Interfaces WEB');
INSERT INTO matiere
VALUES ('00000003','Mathématiques discretes');
INSERT INTO matiere
VALUES ('00000004','Economie');


INSERT INTO tnote
VALUES ('0000000001','19','00000001','14/10/2022','00000001','Bon travail');
INSERT INTO tnote
VALUES ('0000000002','6','00000002','14/10/2022','00000001','pas sufisant');
INSERT INTO tnote
VALUES ('0000000003','16','00000003','14/10/2022','00000002','correct');
INSERT INTO tnote
VALUES ('0000000004','12','00000004','14/10/2022','00000002','passable');


/* SCOL 07 */

UPDATE tnote
SET note = note + 1
WHERE matiere = '00000002';

/* SCOL 08 */

/* si certains etudiants ont une note supérieure a 19 , le fait de faire
 +1 donnerai une note supérieure a 20 ce qui ne respecterais plus la
 contrainte d'intgriter */

UPDATE tnote
SET note = note + 1
WHERE matiere = '00000002' AND note <= 19;

/* SCOL 09 */

ROLLBACK

/* SCOL 10 */

DELETE FROM tnote
WHERE matiere = '00000002' and lecodeetudiant = '00000002';

/* SCOL 11 */

COMMIT 

/* SCOL 20 */

ALTER TABLE tnote
ADD(coeff NUMERIC(3,2) NOT NULL CONSTRAINT ck_coeff CHECK (coeff BETWEEN 0.1 AND 0.5));

/* la table doit etre vide lors de cette opération car coeff doit etre non null
or certains attributs n'auronts pas de coefs apres l'execution */





/* Par equipe équipe de 2 */

/* 41 Consulter les notes de vos étudiants , des etuduiants des copains*/
/* 42 Que se passe-t-il à la 41 */
/* 43 Donner les droites de consultations des notes au copain */
/* 44 = 41*/