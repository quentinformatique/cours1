-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  mar. 21 mars 2023 à 08:36
-- Version du serveur :  10.3.38-MariaDB-0+deb10u1
-- Version de PHP :  7.3.31-1~deb10u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `qcostes`
--

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `V_MOY_MAT_PROMO`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `V_MOY_MAT_PROMO` (
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `V_MOY_MAT_PROMO_PROF`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `V_MOY_MAT_PROMO_PROF` (
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `V_notes`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `V_notes` (
);

-- --------------------------------------------------------

--
-- Structure de la vue `V_MOY_MAT_PROMO`
--
DROP TABLE IF EXISTS `V_MOY_MAT_PROMO`;

CREATE ALGORITHM=UNDEFINED DEFINER=`qcostes`@`localhost` SQL SECURITY DEFINER VIEW `V_MOY_MAT_PROMO`  AS  select avg(`note`.`note`) AS `moyenne`,min(`note`.`note`) AS `mini`,max(`note`.`note`) AS `maxi`,`note`.`id_matiere` AS `MAT_ID`,`promo`.`id` AS `PROMO_ID` from ((`note` join `etudiant` on(`note`.`ine` = `etudiant`.`ine`)) join `promo` on(`etudiant`.`id_promo` = `promo`.`id`)) group by `note`.`id_matiere`,`promo`.`id` ;

-- --------------------------------------------------------

--
-- Structure de la vue `V_MOY_MAT_PROMO_PROF`
--
DROP TABLE IF EXISTS `V_MOY_MAT_PROMO_PROF`;

CREATE ALGORITHM=UNDEFINED DEFINER=`qcostes`@`localhost` SQL SECURITY DEFINER VIEW `V_MOY_MAT_PROMO_PROF`  AS  select `V_MOY_MAT_PROMO`.`moyenne` AS `moyenne`,`V_MOY_MAT_PROMO`.`mini` AS `mini`,`V_MOY_MAT_PROMO`.`maxi` AS `maxi`,`V_MOY_MAT_PROMO`.`MAT_ID` AS `MAT_ID`,`V_MOY_MAT_PROMO`.`PROMO_ID` AS `PROMO_ID`,`enseigne`.`id_prof` AS `id_prof` from (`V_MOY_MAT_PROMO` left join `enseigne` on(`enseigne`.`id_matiere` = `V_MOY_MAT_PROMO`.`MAT_ID` and `enseigne`.`id_promo` = `V_MOY_MAT_PROMO`.`PROMO_ID`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `V_notes`
--
DROP TABLE IF EXISTS `V_notes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`qcostes`@`localhost` SQL SECURITY DEFINER VIEW `V_notes`  AS  select `e`.`nom` AS `nom`,`e`.`prenom` AS `prenom`,`m`.`nom` AS `matiere`,`s`.`nom` AS `semestre`,`n`.`note` AS `note`,`p`.`nom` AS `promo` from ((((`etudiant` `e` join `matiere` `m`) join `semestre` `s`) join `note` `n`) join `promo` `p`) where `e`.`ine` = `n`.`ine` and `e`.`id_promo` = `p`.`id` and `m`.`id` = `n`.`id_matiere` and `s`.`id` = `n`.`id_semestre` ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
