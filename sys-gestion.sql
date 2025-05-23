-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 23 mai 2025 à 16:14
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sys-gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `Matricule` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Filiere` varchar(50) NOT NULL,
  `Niveau` varchar(50) NOT NULL,
  `Montant` int(11) NOT NULL,
  `Objet` varchar(50) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Mois` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `caisse`
--

INSERT INTO `caisse` (`Matricule`, `Prenom`, `Nom`, `Filiere`, `Niveau`, `Montant`, `Objet`, `Date`, `Mois`) VALUES
('001', 'TIDIANE', 'BA', 'GELO', 'L1', 70000, 'Scolarite', '12/01/2025', '1'),
('DEV001', 'AWA', 'DIEYE', 'SRT', 'L2', 100000, 'Scolarite', '12/02/2025', '2');

-- --------------------------------------------------------

--
-- Structure de la table `caissier`
--

CREATE TABLE `caissier` (
  `Matricule` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `caissier`
--

INSERT INTO `caissier` (`Matricule`, `Prenom`, `Nom`, `Password`) VALUES
('CAISSIER1', 'Moussa', 'Diop', '123');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `Matricule` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Filiere` varchar(50) NOT NULL,
  `Niveau` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `dateInscription` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`Matricule`, `Prenom`, `Nom`, `Filiere`, `Niveau`, `Password`, `dateInscription`) VALUES
('DEVWEB01', 'Aida', 'Gaye Sarr', 'DEVWEB', 'L3', 'passer', '2025-05-14 20:32:59'),
('GELO1', 'Mamadou', 'Coulibaly', 'GELO', 'L2', 'passer', '2025-05-23 13:35:45'),
('GELO2', 'Ada', 'Diop', 'GELO', 'L2', 'passer', '2024-11-06 13:53:58'),
('GELO4', 'Fatou kine', 'Ndiaye', 'GELO', 'L3', 'passer', '2025-05-23 08:50:01'),
('GELO5', 'Ndeye Khoudia', 'Thiam', 'GELO', 'L3', 'passer', '2025-01-12 13:54:22'),
('GELO6', 'Nordick', 'Thickaya', 'GELO', 'L2', 'passer', '2025-05-14 17:04:28'),
('SRT1', 'Fatima', 'Ly', 'SRT', 'M1', 'passer', '2025-05-23 10:15:46'),
('SRT2', 'Ndeye Sokhna', 'Lo', 'SRT', 'M1', 'passer', '2025-05-22 15:21:49'),
('SRT3', 'Jeremy', 'William', 'SRT', 'L3', 'passer', '2025-05-22 16:22:50');

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` int(11) NOT NULL,
  `MatriculeEtudiant` varchar(50) NOT NULL,
  `MatriculeCaissier` varchar(50) NOT NULL,
  `Montant` float NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Statut` varchar(50) NOT NULL,
  `Mois` varchar(50) NOT NULL,
  `Objet` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`id`, `MatriculeEtudiant`, `MatriculeCaissier`, `Montant`, `Date`, `Statut`, `Mois`, `Objet`) VALUES
(9, 'GELO1', '', 800000, '2025-05-23 14:00:05', 'PAYE', 'Octobre', 'Inscription'),
(26, 'DEVWEB01', '', 900000, '2025-05-23 13:56:48', 'PAYE', 'Octobre', 'Inscription'),
(32, 'GELO5', '', 200000, '2025-05-23 14:05:40', 'PAYE', 'Octobre', 'Inscription'),
(34, 'GELO6', '', 80000, '2025-05-23 14:06:47', 'PAYE', 'Octobre', 'Scolarite'),
(35, 'GELO6', '', 80000, '2025-05-23 14:06:57', 'PAYE', 'Novembre', 'Scolarite'),
(36, 'GELO6', '', 80000, '2025-05-23 14:07:04', 'PAYE', 'Decembre', 'Scolarite'),
(37, 'GELO6', '', 80000, '2025-05-23 14:07:22', 'PAYE', 'Janvier', 'Scolarite'),
(38, 'GELO6', '', 80000, '2025-05-23 14:07:29', 'PAYE', 'Fevrier', 'Scolarite'),
(39, 'GELO6', '', 80000, '2025-05-23 14:07:35', 'PAYE', 'Mars', 'Scolarite'),
(40, 'GELO6', '', 80000, '2025-05-23 14:07:40', 'PAYE', 'Avril', 'Scolarite'),
(41, 'GELO6', '', 80000, '2025-05-23 14:07:45', 'PAYE', 'Mai', 'Scolarite');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`Matricule`);

--
-- Index pour la table `caissier`
--
ALTER TABLE `caissier`
  ADD PRIMARY KEY (`Matricule`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`Matricule`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_mois` (`MatriculeEtudiant`,`Mois`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
