-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  mer. 11 mars 2020 à 10:29
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS tennisbdd;
CREATE DATABASE tennisbdd;

USE `tennisbdd`;

DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `deptId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cot` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `cities`
--

INSERT INTO `cities` (`id`, `nom`, `deptId`) VALUES
(1, 'Suresnes', 1),
(2, 'Sucy', 2),
(3, 'Arras', 3),
(4, 'Lens', 3);

-- --------------------------------------------------------

--
-- Structure de la table `countries`
--

DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `countries`
--

INSERT INTO `countries` (`id`, `nom`, `code`) VALUES
(1, 'France', 'FRA'),
(2, 'Algérie', 'DZ'),
(3, 'Espagne', 'ES'),
(4, 'Allemagne', 'GER');

-- --------------------------------------------------------

--
-- Structure de la table `degrees`
--

DROP TABLE IF EXISTS `degrees`;
CREATE TABLE IF NOT EXISTS `degrees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(55) NOT NULL,
  `description` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `degrees`
--

INSERT INTO `degrees` (`id`, `nom`, `description`) VALUES
(1, 'Licence', 'Diplôme bac plus trois, premier cycle universitaire'),
(2, 'Master', 'Second cycle universitaire,diplôme bac plus cinq'),
(3, 'Doctorat', 'Diplôme bac plus ouitte. Ena DOCTEUR');

-- --------------------------------------------------------

--
-- Structure de la table `departments`
--

DROP TABLE IF EXISTS `departments`;
CREATE TABLE IF NOT EXISTS `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `regionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_region` (`regionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `departments`
--

INSERT INTO `departments` (`id`, `nom`, `regionId`) VALUES
(1, 'Hauts-De-Seine', 1),
(2, 'Seine Et Marne', 1),
(3, 'Pas-De-Calais', 3);

-- --------------------------------------------------------

--
-- Structure de la table `joueurs`
--

DROP TABLE IF EXISTS `joueurs`;
CREATE TABLE IF NOT EXISTS `joueurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `joueurs`
--

INSERT INTO `joueurs` (`id`, `nom`, `prenom`, `sexe`) VALUES
(3, 'dsqdsq', 'dqsdq', 'f'),
(2, 'Joe Wilfired', 'Tsonga', 'f'),
(1, 'Bee', 'Sid', 'h'),
(4, 'Toulouluo', 'Pououlou', 'f'),
(5, 'Maatouk', 'Fatiha', 'f'),
(6, '', '', 'f'),
(7, '', 'nabila', 'f'),
(8, 'ferrah', 'nabila', 'f');

-- --------------------------------------------------------

--
-- Structure de la table `members`
--

DROP TABLE IF EXISTS `members`;
CREATE TABLE IF NOT EXISTS `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pseudo` (`pseudo`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `members`
--

INSERT INTO `members` (`id`, `pseudo`, `password`) VALUES
(17, 'maatouk', '123edvdg'),
(18, 'maatoukfgqsd', '123edvdgfsdv'),
(19, 'sarahferrah', '123edvdgfsdv');

-- --------------------------------------------------------

--
-- Structure de la table `regions`
--

DROP TABLE IF EXISTS `regions`;
CREATE TABLE IF NOT EXISTS `regions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_country` (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `regions`
--

INSERT INTO `regions` (`id`, `code`, `countryId`) VALUES
(1, 'Ile-De-France', 1),
(2, 'Tlemcen', 2),
(3, 'Hauts de France', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cities`
--
ALTER TABLE `cities`
  ADD CONSTRAINT `FK_cot` FOREIGN KEY (`deptId`) REFERENCES `departments` (`id`);

--
-- Contraintes pour la table `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `FK_region` FOREIGN KEY (`regionId`) REFERENCES `regions` (`id`);

--
-- Contraintes pour la table `regions`
--
ALTER TABLE `regions`
  ADD CONSTRAINT `FK_country` FOREIGN KEY (`countryId`) REFERENCES `countries` (`id`);
COMMIT;

