-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 10 mai 2023 à 17:26
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion de produit`
--

-- --------------------------------------------------------

--
-- Structure de la table `approvisionnement`
--

CREATE TABLE `approvisionnement` (
  `N_approvision` int(11) NOT NULL,
  `N_forn` int(11) NOT NULL,
  `N_prod` int(11) NOT NULL,
  `qteentree` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `approvisionnement`
--

INSERT INTO `approvisionnement` (`N_approvision`, `N_forn`, `N_prod`, `qteentree`) VALUES
(5, 16, 6, 2),
(8, 17, 6, 4),
(9, 18, 8, 12);

--
-- Déclencheurs `approvisionnement`
--
DELIMITER $$
CREATE TRIGGER `ajout_quantite_on_approvisionnement` AFTER INSERT ON `approvisionnement` FOR EACH ROW BEGIN
    UPDATE produit SET qte_totale = qte_totale + NEW.qteentree
    WHERE N_prod = NEW.N_prod;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audit_approvisionnement_delete` AFTER DELETE ON `approvisionnement` FOR EACH ROW BEGIN 
    INSERT INTO audit_approvisionnement (N_forn, nom, N_prod, designation, qteentree_ancien, qteentree_nouv,type, utilisateur) 
    VALUES ( OLD.N_forn, (SELECT nom_prenom FROM fornisseur WHERE N_forn = OLD.N_forn), OLD.N_prod, (SELECT designation FROM produit WHERE N_prod = OLD.N_prod), OLD.qteentree, 0,'DELETE', USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audit_approvisionnement_insert` AFTER INSERT ON `approvisionnement` FOR EACH ROW BEGIN 
    INSERT INTO audit_approvisionnement (N_forn, nom, N_prod, designation, qteentree_ancien, qteentree_nouv,type, utilisateur) 
    VALUES ( NEW.N_forn, (SELECT nom_prenom FROM fornisseur WHERE N_forn = NEW.N_forn), NEW.N_prod, (SELECT designation FROM produit WHERE N_prod = NEW.N_prod), 0, NEW.qteentree,'INSERT', USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audit_approvisionnement_update` AFTER UPDATE ON `approvisionnement` FOR EACH ROW BEGIN 
    INSERT INTO audit_approvisionnement (N_forn, nom, N_prod, designation, qteentree_ancien, qteentree_nouv,type, utilisateur) 
    VALUES ( NEW.N_forn, (SELECT nom_prenom FROM fornisseur WHERE N_forn = NEW.N_forn), NEW.N_prod, (SELECT designation FROM produit WHERE N_prod = NEW.N_prod), OLD.qteentree, NEW.qteentree,'UPDATE', USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `maj_qte_totale_produit_approvisionnement` AFTER UPDATE ON `approvisionnement` FOR EACH ROW BEGIN
    IF OLD.qteentree < NEW.qteentree THEN
        UPDATE produit SET qte_totale = qte_totale + (NEW.qteentree - OLD.qteentree)
        WHERE N_prod = NEW.N_prod;
    ELSE
        UPDATE produit SET qte_totale = qte_totale - (OLD.qteentree - NEW.qteentree)
        WHERE N_prod = NEW.N_prod;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `audit_approvisionnement`
--

CREATE TABLE `audit_approvisionnement` (
  `id` int(11) NOT NULL,
  `date` varchar(20) NOT NULL DEFAULT current_timestamp(),
  `N_forn` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `N_prod` int(11) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `qteentree_ancien` int(11) NOT NULL,
  `qteentree_nouv` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `utilisateur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `audit_approvisionnement`
--

INSERT INTO `audit_approvisionnement` (`id`, `date`, `N_forn`, `nom`, `N_prod`, `designation`, `qteentree_ancien`, `qteentree_nouv`, `type`, `utilisateur`) VALUES
(1, '2023-05-05 22:19:41', 16, 'Andry', 1, 'TelephoneS', 0, 3, 'INSERT', 'mls@localhost'),
(2, '2023-05-05 22:23:16', 16, 'Andry', 1, 'TelephoneS', 3, 0, 'DELETE', 'mls@localhost'),
(3, '2023-05-05 22:28:46', 17, 'Lovasoa', 6, 'Desktop', 0, 8, 'INSERT', 'mls@localhost'),
(4, '2023-05-05 22:29:10', 17, 'Lovasoa', 6, 'Desktop', 8, 8, 'UPDATE', 'mls@localhost'),
(5, '2023-05-05 22:30:30', 17, 'Lovasoa', 6, 'Desktop', 6, 4, 'UPDATE', 'mls@localhost'),
(6, '2023-05-07 10:12:11', 18, 'Randria', 8, 'LapTop', 0, 10, 'INSERT', 'mls@localhost'),
(7, '2023-05-07 10:12:25', 18, 'Randria', 8, 'LapTop', 10, 12, 'UPDATE', 'mls@localhost'),
(8, '2023-05-07 10:12:52', 16, 'Andry', 11, 'Ampli', 0, 50, 'INSERT', 'mls@localhost'),
(9, '2023-05-07 10:13:01', 16, 'Andry', 11, 'Ampli', 50, 0, 'DELETE', 'mls@localhost');

-- --------------------------------------------------------

--
-- Structure de la table `audit_produit`
--

CREATE TABLE `audit_produit` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL DEFAULT current_timestamp(),
  `N_prod` int(11) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `stock_ancien` int(11) NOT NULL,
  `stock_nouv` int(11) NOT NULL,
  `utilisateur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `audit_produit`
--

INSERT INTO `audit_produit` (`id`, `type`, `date`, `N_prod`, `designation`, `stock_ancien`, `stock_nouv`, `utilisateur`) VALUES
(1, 'INSERT', '2023-05-05 20:41:23', 9, 'Automobile', 0, 5, 'root@localhost'),
(2, 'INSERT', '2023-05-05 20:47:21', 10, 'V?tement', 0, 20, 'root@localhost'),
(3, 'INSERT', '2023-05-05 20:50:16', 11, 'fg', 0, 20, 'mls@localhost'),
(4, 'UPDATE', '2023-05-05 21:12:37', 11, 'fg', 20, 20, 'mls@localhost'),
(5, 'DELETE', '2023-05-05 21:14:18', 10, 'V?tement', 20, 0, 'mls@localhost'),
(7, 'UPDATE', '2023-05-05 21:43:25', 1, 'TelephoneS', 146, 144, 'mls@localhost'),
(8, 'UPDATE', '2023-05-05 21:59:44', 1, 'TelephoneS', 144, 142, 'mls@localhost'),
(10, 'UPDATE', '2023-05-05 22:19:41', 1, 'TelephoneS', 142, 145, 'mls@localhost'),
(11, 'UPDATE', '2023-05-05 22:28:46', 6, 'Desktop', 22, 30, 'mls@localhost'),
(12, 'UPDATE', '2023-05-05 22:29:10', 6, 'Desktop', 30, 28, 'mls@localhost'),
(13, 'UPDATE', '2023-05-05 22:30:30', 6, 'Desktop', 28, 26, 'mls@localhost'),
(14, 'UPDATE', '2023-05-07 10:06:33', 1, 'TelephoneS', 145, 145, 'mls@localhost'),
(15, 'UPDATE', '2023-05-07 10:08:48', 11, 'Lova', 20, 20, 'mls@localhost'),
(16, 'DELETE', '2023-05-07 10:08:57', 9, 'Automobile', 5, 0, 'mls@localhost'),
(17, 'INSERT', '2023-05-07 10:09:27', 12, 'Convertisseur', 0, 10, 'mls@localhost'),
(18, 'UPDATE', '2023-05-07 10:12:11', 8, 'LapTop', 20, 30, 'mls@localhost'),
(19, 'UPDATE', '2023-05-07 10:12:25', 8, 'LapTop', 30, 32, 'mls@localhost'),
(20, 'UPDATE', '2023-05-07 10:12:52', 11, 'Ampli', 20, 70, 'mls@localhost'),
(21, 'UPDATE', '2023-05-07 10:13:42', 12, 'Convertisseur', 10, 5, 'mls@localhost'),
(22, 'UPDATE', '2023-05-07 10:14:11', 12, 'Convertisseur', 5, 8, 'mls@localhost'),
(23, 'UPDATE', '2023-05-07 10:15:58', 11, 'Ampli', 70, 68, 'mls@localhost'),
(24, 'UPDATE', '2023-05-07 10:16:17', 1, 'Telephone', 145, 155, 'mls@localhost'),
(25, 'INSERT', '2023-05-07 11:13:03', 13, 'test', 0, 5, 'mls@localhost'),
(26, 'UPDATE', '2023-05-07 11:13:19', 13, 'test', 5, 5, 'mls@localhost'),
(27, 'DELETE', '2023-05-07 11:13:26', 13, 'testeee', 5, 0, 'mls@localhost');

-- --------------------------------------------------------

--
-- Structure de la table `audit_vente`
--

CREATE TABLE `audit_vente` (
  `id` int(11) NOT NULL,
  `N_client` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `N_prod` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `qtesortie_ancien` int(11) NOT NULL,
  `qtesortie_nouv` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `utilisateur` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `audit_vente`
--

INSERT INTO `audit_vente` (`id`, `N_client`, `nom`, `N_prod`, `designation`, `qtesortie_ancien`, `qtesortie_nouv`, `type`, `utilisateur`, `date`) VALUES
(1, 7, 'Lovasoa', 1, 'TelephoneS', 0, 2, 'INSERT', 'mls@localhost', '2023-05-05 21:43:25'),
(2, 7, 'Lovasoa', 1, 'TelephoneS', 2, 0, 'DELETE', 'mls@localhost', '2023-05-05 21:50:49'),
(3, 7, 'Lovasoa', 1, 'TelephoneS', 6, 8, 'UPDATE', 'mls@localhost', '2023-05-05 21:59:44'),
(4, 14, 'Rakoto', 12, 'Convertisseur', 0, 5, 'INSERT', 'mls@localhost', '2023-05-07 10:13:42'),
(5, 14, 'Rakoto', 12, 'Convertisseur', 5, 2, 'UPDATE', 'mls@localhost', '2023-05-07 10:14:11'),
(6, 10, 'Marie', 11, 'Ampli', 0, 2, 'INSERT', 'mls@localhost', '2023-05-07 10:15:58'),
(7, 7, 'Lovasoa', 1, 'Telephone', 80, 70, 'UPDATE', 'mls@localhost', '2023-05-07 10:16:17'),
(8, 7, 'Lovasoa', 1, 'Telephone', 8, 0, 'DELETE', 'mls@localhost', '2023-05-07 10:16:30');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `N_client` int(11) NOT NULL,
  `nom_prenom` varchar(30) NOT NULL,
  `N_telephone` varchar(20) DEFAULT NULL,
  `Adresse` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`N_client`, `nom_prenom`, `N_telephone`, `Adresse`) VALUES
(7, 'Lovasoa', '0343786353', 'Tanambao'),
(9, 'Andry', '03438695423', 'Antananarivo'),
(10, 'Marie', '0342548635', 'Tanambao'),
(13, 'Feno', '0321532562', 'Manakara'),
(14, 'Rakoto', '0321548625', 'Manakara');

-- --------------------------------------------------------

--
-- Structure de la table `fornisseur`
--

CREATE TABLE `fornisseur` (
  `N_forn` int(11) NOT NULL,
  `nom_prenom` varchar(30) NOT NULL,
  `N_telephone` varchar(20) DEFAULT NULL,
  `Adresse` varchar(60) NOT NULL,
  `Ville` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fornisseur`
--

INSERT INTO `fornisseur` (`N_forn`, `nom_prenom`, `N_telephone`, `Adresse`, `Ville`) VALUES
(16, 'Andry', '0345265845', 'Antananarivo', 'Antananarivo'),
(17, 'Lovasoa', '0343786353', 'Tanambao', 'Antananarivo'),
(18, 'Randria', '0343215324', 'Fianarantsoa', 'Antananarivo');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `N_prod` int(11) NOT NULL,
  `designation` varchar(50) CHARACTER SET latin1 NOT NULL,
  `qte_totale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`N_prod`, `designation`, `qte_totale`) VALUES
(1, 'Telephone', 155),
(6, 'Desktop', 26),
(8, 'LapTop', 32),
(11, 'Ampli', 68),
(12, 'Convertisseur', 8);

--
-- Déclencheurs `produit`
--
DELIMITER $$
CREATE TRIGGER `audit_produit_insert` AFTER INSERT ON `produit` FOR EACH ROW BEGIN
    INSERT INTO audit_produit (type, N_prod, designation, stock_ancien, stock_nouv, utilisateur)
    VALUES ('INSERT', NEW.N_prod, NEW.designation,0, NEW.qte_totale,USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audit_produit_modification` AFTER UPDATE ON `produit` FOR EACH ROW BEGIN
  INSERT INTO audit_produit (type, N_prod, designation, stock_ancien, stock_nouv, utilisateur)
  VALUES ('UPDATE', OLD.N_prod, OLD.designation, OLD.qte_totale, NEW.qte_totale, USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audit_suppression_produit` AFTER DELETE ON `produit` FOR EACH ROW BEGIN
INSERT INTO audit_produit (type, N_prod, designation, stock_ancien, stock_nouv, utilisateur)
VALUES ('DELETE', OLD.N_prod, OLD.designation, OLD.qte_totale,0, USER());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `user`, `password`) VALUES
(1, 'amine', '2610'),
(2, 'jean', '2020'),
(3, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `N_vente` int(11) NOT NULL,
  `N_client` int(11) NOT NULL,
  `N_prod` int(11) NOT NULL,
  `qtesortie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`N_vente`, `N_client`, `N_prod`, `qtesortie`) VALUES
(4, 7, 5, 20),
(6, 7, 5, 20),
(7, 7, 1, 70),
(11, 14, 12, 2),
(12, 10, 11, 2);

--
-- Déclencheurs `vente`
--
DELIMITER $$
CREATE TRIGGER `ajout_quantite_on_vente` BEFORE INSERT ON `vente` FOR EACH ROW BEGIN
    UPDATE produit SET qte_totale = qte_totale - NEW.qtesortie
    WHERE N_prod = NEW.N_prod;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `maj_qte_totale_produit_vente` AFTER UPDATE ON `vente` FOR EACH ROW BEGIN
    IF OLD.qtesortie > NEW.qtesortie THEN
        UPDATE produit SET qte_totale = qte_totale + (OLD.qtesortie - NEW.qtesortie)
        WHERE N_prod = NEW.N_prod;
    ELSE
        UPDATE produit SET qte_totale = qte_totale - (NEW.qtesortie - OLD.qtesortie)
        WHERE N_prod = NEW.N_prod;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `vente_delete_audit` AFTER DELETE ON `vente` FOR EACH ROW BEGIN 
    INSERT INTO audit_vente ( N_client, nom, N_prod, designation, qtesortie_ancien, qtesortie_nouv,type, utilisateur) 
    VALUES ( OLD.N_client, (SELECT nom_prenom FROM client WHERE N_client = OLD.N_client), OLD.N_prod, (SELECT designation FROM produit WHERE N_prod = OLD.N_prod), OLD.qtesortie, 0,'DELETE', USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `vente_insert_audit` AFTER INSERT ON `vente` FOR EACH ROW BEGIN 
    INSERT INTO audit_vente ( N_client, nom, N_prod, designation, qtesortie_ancien, qtesortie_nouv,type, utilisateur) 
    VALUES ( NEW.N_client, (SELECT nom_prenom FROM client WHERE N_client = NEW.N_client), NEW.N_prod, (SELECT designation FROM produit WHERE N_prod = NEW.N_prod), 0, NEW.qtesortie,'INSERT', USER());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `vente_update_audit` AFTER UPDATE ON `vente` FOR EACH ROW BEGIN 
    INSERT INTO audit_vente ( N_client, nom, N_prod, designation, qtesortie_ancien, qtesortie_nouv,type, utilisateur) 
    VALUES ( NEW.N_client, (SELECT nom_prenom FROM client WHERE N_client = NEW.N_client), NEW.N_prod, (SELECT designation FROM produit WHERE N_prod = NEW.N_prod), OLD.qtesortie, NEW.qtesortie,'UPDATE', USER());
END
$$
DELIMITER ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  ADD PRIMARY KEY (`N_approvision`);

--
-- Index pour la table `audit_approvisionnement`
--
ALTER TABLE `audit_approvisionnement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `audit_produit`
--
ALTER TABLE `audit_produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `audit_vente`
--
ALTER TABLE `audit_vente`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`N_client`);

--
-- Index pour la table `fornisseur`
--
ALTER TABLE `fornisseur`
  ADD PRIMARY KEY (`N_forn`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`N_prod`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`N_vente`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  MODIFY `N_approvision` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `audit_approvisionnement`
--
ALTER TABLE `audit_approvisionnement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `audit_produit`
--
ALTER TABLE `audit_produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `audit_vente`
--
ALTER TABLE `audit_vente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `N_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `fornisseur`
--
ALTER TABLE `fornisseur`
  MODIFY `N_forn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `N_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `N_vente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
