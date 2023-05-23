
--https://kripken.github.io/sql.js/GUI/

DROP VIEW V_matiere_prof_promo 
;
DROP TABLE enseigne CASCADE CONSTRAINTS 
;
DROP TABLE etudiant CASCADE CONSTRAINTS 
;
DROP TABLE matiere CASCADE CONSTRAINTS 
;
DROP TABLE note CASCADE CONSTRAINTS 
;
DROP TABLE professeur CASCADE CONSTRAINTS 
;
DROP TABLE promo CASCADE CONSTRAINTS 
;
DROP TABLE semestre CASCADE CONSTRAINTS 
;

/* table professeur + sa contrainte PK */
create table professeur (id int, nom varchar(254), prenom varchar(254));
ALTER TABLE professeur ADD CONSTRAINT PK_professeur PRIMARY KEY (id);

/* table matiere + sa contrainte PK */
create table matiere (id int, nom varchar(254));
ALTER TABLE matiere ADD CONSTRAINT PK_matiere PRIMARY KEY (id);

/* table promo + sa contrainte PK */
create table promo (id int, nom varchar(254));
ALTER TABLE promo ADD CONSTRAINT PK_promo PRIMARY KEY (id);

/* Table enseigne + ses contraintes */
create table enseigne(id_prof int, id_matiere int, id_promo int);
ALTER TABLE enseigne ADD CONSTRAINT PK_enseigne PRIMARY KEY (id_prof,id_matiere,id_promo);
ALTER TABLE enseigne ADD CONSTRAINT FK_prof_enseigne FOREIGN KEY (id_prof) REFERENCES professeur(id);
ALTER TABLE enseigne ADD CONSTRAINT FK_mat_enseigne FOREIGN KEY (id_matiere) REFERENCES matiere(id);
ALTER TABLE enseigne ADD CONSTRAINT FK_promo_enseigne FOREIGN KEY (id_promo) REFERENCES promo(id);

/* table semestre + sa contrainte PK */
create table semestre(id int, nom varchar(254));
ALTER TABLE semestre ADD CONSTRAINT PK_semestre PRIMARY KEY (id);

/* table etudiant + ses contraintes */
create table etudiant (ine int, nom varchar(254), prenom varchar(254), id_promo int);
ALTER TABLE etudiant ADD CONSTRAINT PK_etudiant PRIMARY KEY (ine);
ALTER TABLE etudiant ADD CONSTRAINT FK_promo_etudiant foreign key(id_promo) references promo(id);

/* table note + ses contraintes */
create table note (ine int, id_matiere int, id_semestre int, note decimal);
ALTER TABLE note ADD CONSTRAINT PK_note PRIMARY KEY (ine,id_matiere,id_semestre);
ALTER TABLE note ADD CONSTRAINT FK_etu_note FOREIGN KEY (ine) REFERENCES etudiant(ine);
ALTER TABLE note ADD CONSTRAINT FK_mat_note FOREIGN KEY (id_matiere) REFERENCES matiere(id);
ALTER TABLE note ADD CONSTRAINT FK_semestre_note FOREIGN KEY (id_semestre) REFERENCES semestre(id);

/* création d'une vue affichant toutes les matières avec le prof enseignant par promo */
Create view V_matiere_prof_promo as 
select m.nom as Matiere, p1.nom as Nom_prof,p1.prenom as Prenom_prof, p2.nom as Promo, p1.id as ID_prof, p2.id as ID_promo, m.id as ID_Matiere from professeur p1, matiere m , promo p2, enseigne e where
p1.id=e.id_prof 
and
m.id = e.id_matiere
and
p2.id = e.id_promo;
