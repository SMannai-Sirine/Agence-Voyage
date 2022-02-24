-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2022 at 04:28 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pialgo`
--

-- --------------------------------------------------------

--
-- Table structure for table `agence`
--

CREATE TABLE `agence` (
  `id_agence` int(11) NOT NULL,
  `nom_agence` varchar(30) NOT NULL,
  `adresse_agence` varchar(30) NOT NULL,
  `ville_agence` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `croisiere`
--

CREATE TABLE `croisiere` (
  `idCroisiere` int(11) NOT NULL,
  `refBateau` varchar(30) NOT NULL,
  `compagnieNavigation` varchar(30) NOT NULL,
  `portDepart` varchar(30) NOT NULL,
  `portArrive` varchar(30) NOT NULL,
  `dateDepart` varchar(30) NOT NULL,
  `dateArrivee` varchar(30) NOT NULL,
  `nbCabPopulaire` int(11) NOT NULL,
  `nbCabPremium` int(11) NOT NULL,
  `nbCabLuxe` int(11) NOT NULL,
  `prixCabPopulaire` float NOT NULL,
  `prixCabPremium` float NOT NULL,
  `prixCabLuxe` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `IdEvent` int(11) NOT NULL,
  `intitule` varchar(20) NOT NULL,
  `paysEvent` varchar(20) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `dateEvent` varchar(20) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `typeEvent` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`IdEvent`, `intitule`, `paysEvent`, `adresse`, `dateEvent`, `photo`, `typeEvent`) VALUES
(1, 'event Tunis', 'tunis', 'l avenue', '20-02-2022', 'carnaval', 'photo'),
(2, 'event Tunis', 'tunis', 'l avenue', '20-02-2022', 'carnaval', 'photo');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `idhotel` int(11) NOT NULL,
  `nom_hotel` varchar(15) NOT NULL,
  `nbetoile` int(11) NOT NULL,
  `nbchambre` int(11) NOT NULL,
  `nbrestaurant` int(11) NOT NULL,
  `nbpiscine` int(11) NOT NULL,
  `adresse_rest` varchar(30) NOT NULL,
  `villehotel` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `loc_voiture`
--

CREATE TABLE `loc_voiture` (
  `idvoiture` int(11) NOT NULL,
  `date_res` varchar(25) NOT NULL,
  `dure_res` varchar(25) NOT NULL,
  `type_dem` varchar(25) NOT NULL,
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservationagence`
--

CREATE TABLE `reservationagence` (
  `id_reservation` int(11) NOT NULL,
  `nom_hotel_rest` varchar(30) NOT NULL,
  `date_reservation` date NOT NULL,
  `id_hotel_rest` int(11) NOT NULL,
  `idU` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservationcroisiere`
--

CREATE TABLE `reservationcroisiere` (
  `idReservationCroisiere` int(11) NOT NULL,
  `dateReservationCroisiere` varchar(30) NOT NULL,
  `idU` int(11) NOT NULL,
  `idCroisiere` int(11) NOT NULL,
  `typeCabine` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservationvol`
--

CREATE TABLE `reservationvol` (
  `idReservationVol` int(11) NOT NULL,
  `dateReservationVol` varchar(30) NOT NULL,
  `idU` int(11) NOT NULL,
  `idVol` int(11) NOT NULL,
  `classe` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `id_rest` int(11) NOT NULL,
  `nom_rest` varchar(15) NOT NULL,
  `numtel_rest` bigint(12) NOT NULL,
  `adresse_rest` varchar(30) NOT NULL,
  `ville_rest` varchar(15) NOT NULL,
  `nbtable_rest` int(11) NOT NULL,
  `type_rest` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `taxi_aer`
--

CREATE TABLE `taxi_aer` (
  `idtaxi` int(11) NOT NULL,
  `taxi_matr` varchar(25) NOT NULL,
  `heure_arr` varchar(25) NOT NULL,
  `pays_des` varchar(25) NOT NULL,
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `idticket` int(11) NOT NULL,
  `prix_tick` float NOT NULL,
  `date_tick` varchar(20) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `idU` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idU` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `adresse` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `motpasse` varchar(25) NOT NULL,
  `photo` varchar(1000) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vol`
--

CREATE TABLE `vol` (
  `idVol` int(20) NOT NULL,
  `refAvion` varchar(30) NOT NULL,
  `CompagnieAerienne` varchar(30) NOT NULL,
  `aeroDepart` varchar(30) NOT NULL,
  `aeroArrive` varchar(30) NOT NULL,
  `dateDepart` varchar(30) NOT NULL,
  `dateArrivee` varchar(30) NOT NULL,
  `nbFirst` int(11) NOT NULL,
  `nbBusiness` int(11) NOT NULL,
  `nbEco` int(11) NOT NULL,
  `prixFirst` float NOT NULL,
  `prixBusiness` float NOT NULL,
  `prixEco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id_agence`);

--
-- Indexes for table `croisiere`
--
ALTER TABLE `croisiere`
  ADD PRIMARY KEY (`idCroisiere`);

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`IdEvent`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idhotel`);

--
-- Indexes for table `loc_voiture`
--
ALTER TABLE `loc_voiture`
  ADD PRIMARY KEY (`idvoiture`);

--
-- Indexes for table `reservationagence`
--
ALTER TABLE `reservationagence`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `fk_res_agence` (`idU`);

--
-- Indexes for table `reservationcroisiere`
--
ALTER TABLE `reservationcroisiere`
  ADD PRIMARY KEY (`idReservationCroisiere`),
  ADD KEY `fk_res_uti` (`idU`),
  ADD KEY `fk_res_utilisateur` (`idCroisiere`);

--
-- Indexes for table `reservationvol`
--
ALTER TABLE `reservationvol`
  ADD PRIMARY KEY (`idReservationVol`),
  ADD KEY `fk_res_util` (`idU`),
  ADD KEY `fk_res_vol` (`idVol`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id_rest`);

--
-- Indexes for table `taxi_aer`
--
ALTER TABLE `taxi_aer`
  ADD PRIMARY KEY (`idtaxi`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idticket`),
  ADD KEY `fk_ticket_user` (`idU`),
  ADD KEY `fk_ticket_event` (`idEvent`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idU`);

--
-- Indexes for table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`idVol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agence`
--
ALTER TABLE `agence`
  MODIFY `id_agence` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `croisiere`
--
ALTER TABLE `croisiere`
  MODIFY `idCroisiere` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `IdEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idhotel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loc_voiture`
--
ALTER TABLE `loc_voiture`
  MODIFY `idvoiture` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservationagence`
--
ALTER TABLE `reservationagence`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservationcroisiere`
--
ALTER TABLE `reservationcroisiere`
  MODIFY `idReservationCroisiere` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservationvol`
--
ALTER TABLE `reservationvol`
  MODIFY `idReservationVol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id_rest` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `taxi_aer`
--
ALTER TABLE `taxi_aer`
  MODIFY `idtaxi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idticket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vol`
--
ALTER TABLE `vol`
  MODIFY `idVol` int(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservationagence`
--
ALTER TABLE `reservationagence`
  ADD CONSTRAINT `fk_res_agence` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`);

--
-- Constraints for table `reservationcroisiere`
--
ALTER TABLE `reservationcroisiere`
  ADD CONSTRAINT `fk_res_uti` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`),
  ADD CONSTRAINT `fk_res_utilisateur` FOREIGN KEY (`idCroisiere`) REFERENCES `croisiere` (`idCroisiere`);

--
-- Constraints for table `reservationvol`
--
ALTER TABLE `reservationvol`
  ADD CONSTRAINT `fk_res_util` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`),
  ADD CONSTRAINT `fk_res_vol` FOREIGN KEY (`idVol`) REFERENCES `vol` (`idVol`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticket_event` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`IdEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticket_user` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
