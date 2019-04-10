-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 10 Avril 2019 à 08:18
-- Version du serveur :  10.1.8-MariaDB
-- Version de PHP :  5.6.14

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `abssence`
--

-- --------------------------------------------------------

--
-- Structure de la table `absences`
--

CREATE TABLE `absences` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `anneeuniversitaire`
--

CREATE TABLE `anneeuniversitaire` (
  `ID` int(11) NOT NULL,
  `debut_Annee` int(11) DEFAULT NULL,
  `fin_Annee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `competence_a_acquirir`
--

CREATE TABLE `competence_a_acquirir` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

CREATE TABLE `comptes` (
  `ID` int(11) NOT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `id_utilisateur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conditions_acces`
--

CREATE TABLE `conditions_acces` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `debouches`
--

CREATE TABLE `debouches` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `departements`
--

CREATE TABLE `departements` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `id_chef_dept` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `elementsmodule`
--

CREATE TABLE `elementsmodule` (
  `ID` int(11) NOT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `CONTENU` varchar(255) DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `VOLUMEHORAIREAP` int(11) DEFAULT NULL,
  `VOLUMEHORAIRECOURS` int(11) DEFAULT NULL,
  `VOLUMEHORAIRETP` int(11) DEFAULT NULL,
  `VOLUMEHORAIRETD` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `id` int(11) NOT NULL,
  `CODEAPOGEE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filieres`
--

CREATE TABLE `filieres` (
  `ID` int(11) NOT NULL,
  `DATEACCREDITATION` date DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `coordinateur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filieres_options`
--

CREATE TABLE `filieres_options` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

CREATE TABLE `groupes` (
  `ID` int(11) NOT NULL,
  `INTITULE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_etudiant`
--

CREATE TABLE `groupe_etudiant` (
  `groupe_id` int(11) NOT NULL,
  `etudiant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `interventions`
--

CREATE TABLE `interventions` (
  `IDPROFESSEUR` int(11) NOT NULL,
  `IDELEMENTMODULE` int(11) NOT NULL,
  `VOLUMEHORAIREAP` int(11) DEFAULT NULL,
  `VOLUMEHORAIRECOURS` int(11) DEFAULT NULL,
  `VOLUMEHORAIRETP` int(11) DEFAULT NULL,
  `VOLUMEHORAIRETD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `jours`
--

CREATE TABLE `jours` (
  `ID` int(11) NOT NULL,
  `DATE` date DEFAULT NULL,
  `id_semaine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `modules`
--

CREATE TABLE `modules` (
  `ID` int(11) NOT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `NATURE` varchar(255) DEFAULT NULL,
  `SYLLABUS` varchar(255) DEFAULT NULL,
  `VOLUMEHORAIRE` int(11) DEFAULT NULL,
  `id_coordonnateur` int(11) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `objectifs_formation`
--

CREATE TABLE `objectifs_formation` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `objectifs_module`
--

CREATE TABLE `objectifs_module` (
  `Module_ID` int(11) DEFAULT NULL,
  `contenu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `partenaires`
--

CREATE TABLE `partenaires` (
  `Filiere_ID` int(11) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `professeurs`
--

CREATE TABLE `professeurs` (
  `id` int(11) NOT NULL,
  `GRADE` varchar(255) DEFAULT NULL,
  `SPECIALITE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `ID` int(11) NOT NULL,
  `NUMERO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seances`
--

CREATE TABLE `seances` (
  `ID` int(11) NOT NULL,
  `HEUREDEBUT` int(11) DEFAULT NULL,
  `HEUREFIN` int(11) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `id_element_module` int(11) DEFAULT NULL,
  `id_salle` int(11) DEFAULT NULL,
  `id_jour` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seances_groupes`
--

CREATE TABLE `seances_groupes` (
  `seance_id` int(11) NOT NULL,
  `groupe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `semaines`
--

CREATE TABLE `semaines` (
  `ID` int(11) NOT NULL,
  `DATEDEBUT` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `id_plannification_semestre` int(11) DEFAULT NULL,
  `id_plannification_ann` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `semestres`
--

CREATE TABLE `semestres` (
  `ID` int(11) NOT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `VOLUMEHORAIRE` int(11) DEFAULT NULL,
  `filiere` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `ID` int(11) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `CIN` varchar(255) DEFAULT NULL,
  `DATENAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `absences`
--
ALTER TABLE `absences`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `anneeuniversitaire`
--
ALTER TABLE `anneeuniversitaire`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `debut_Annee` (`debut_Annee`),
  ADD UNIQUE KEY `fin_Annee` (`fin_Annee`);

--
-- Index pour la table `competence_a_acquirir`
--
ALTER TABLE `competence_a_acquirir`
  ADD KEY `FK_competence_a_acquirir_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_comptes_id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `conditions_acces`
--
ALTER TABLE `conditions_acces`
  ADD KEY `FK_conditions_Acces_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `debouches`
--
ALTER TABLE `debouches`
  ADD KEY `FK_debouches_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `departements`
--
ALTER TABLE `departements`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_departements_id_chef_dept` (`id_chef_dept`);

--
-- Index pour la table `elementsmodule`
--
ALTER TABLE `elementsmodule`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_elementsmodule_module_id` (`module_id`);

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `filieres`
--
ALTER TABLE `filieres`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_filieres_coordinateur` (`coordinateur`);

--
-- Index pour la table `filieres_options`
--
ALTER TABLE `filieres_options`
  ADD KEY `FK_filieres_options_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `groupe_etudiant`
--
ALTER TABLE `groupe_etudiant`
  ADD PRIMARY KEY (`groupe_id`,`etudiant_id`),
  ADD KEY `FK_groupe_etudiant_etudiant_id` (`etudiant_id`);

--
-- Index pour la table `interventions`
--
ALTER TABLE `interventions`
  ADD PRIMARY KEY (`IDPROFESSEUR`,`IDELEMENTMODULE`),
  ADD KEY `FK_interventions_IDELEMENTMODULE` (`IDELEMENTMODULE`);

--
-- Index pour la table `jours`
--
ALTER TABLE `jours`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_jours_id_semaine` (`id_semaine`);

--
-- Index pour la table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_modules_semestre` (`semestre`),
  ADD KEY `FK_modules_id_coordonnateur` (`id_coordonnateur`);

--
-- Index pour la table `objectifs_formation`
--
ALTER TABLE `objectifs_formation`
  ADD KEY `FK_objectifs_formation_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `objectifs_module`
--
ALTER TABLE `objectifs_module`
  ADD KEY `FK_objectifs_module_Module_ID` (`Module_ID`);

--
-- Index pour la table `partenaires`
--
ALTER TABLE `partenaires`
  ADD KEY `FK_partenaires_Filiere_ID` (`Filiere_ID`);

--
-- Index pour la table `professeurs`
--
ALTER TABLE `professeurs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `seances`
--
ALTER TABLE `seances`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_seances_id_jour` (`id_jour`),
  ADD KEY `FK_seances_id_element_module` (`id_element_module`),
  ADD KEY `FK_seances_id_salle` (`id_salle`);

--
-- Index pour la table `seances_groupes`
--
ALTER TABLE `seances_groupes`
  ADD PRIMARY KEY (`seance_id`,`groupe_id`),
  ADD KEY `FK_seances_groupes_groupe_id` (`groupe_id`);

--
-- Index pour la table `semaines`
--
ALTER TABLE `semaines`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `semestres`
--
ALTER TABLE `semestres`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_semestres_filiere` (`filiere`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `anneeuniversitaire`
--
ALTER TABLE `anneeuniversitaire`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `departements`
--
ALTER TABLE `departements`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `elementsmodule`
--
ALTER TABLE `elementsmodule`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `filieres`
--
ALTER TABLE `filieres`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `jours`
--
ALTER TABLE `jours`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `modules`
--
ALTER TABLE `modules`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `seances`
--
ALTER TABLE `seances`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `semaines`
--
ALTER TABLE `semaines`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `semestres`
--
ALTER TABLE `semestres`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `competence_a_acquirir`
--
ALTER TABLE `competence_a_acquirir`
  ADD CONSTRAINT `FK_competence_a_acquirir_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD CONSTRAINT `FK_comptes_id_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `conditions_acces`
--
ALTER TABLE `conditions_acces`
  ADD CONSTRAINT `FK_conditions_Acces_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `debouches`
--
ALTER TABLE `debouches`
  ADD CONSTRAINT `FK_debouches_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `departements`
--
ALTER TABLE `departements`
  ADD CONSTRAINT `FK_departements_id_chef_dept` FOREIGN KEY (`id_chef_dept`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `elementsmodule`
--
ALTER TABLE `elementsmodule`
  ADD CONSTRAINT `FK_elementsmodule_module_id` FOREIGN KEY (`module_id`) REFERENCES `modules` (`ID`);

--
-- Contraintes pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD CONSTRAINT `FK_etudiants_id` FOREIGN KEY (`id`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `filieres`
--
ALTER TABLE `filieres`
  ADD CONSTRAINT `FK_filieres_coordinateur` FOREIGN KEY (`coordinateur`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `filieres_options`
--
ALTER TABLE `filieres_options`
  ADD CONSTRAINT `FK_filieres_options_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `groupe_etudiant`
--
ALTER TABLE `groupe_etudiant`
  ADD CONSTRAINT `FK_groupe_etudiant_etudiant_id` FOREIGN KEY (`etudiant_id`) REFERENCES `utilisateurs` (`ID`),
  ADD CONSTRAINT `FK_groupe_etudiant_groupe_id` FOREIGN KEY (`groupe_id`) REFERENCES `groupes` (`ID`);

--
-- Contraintes pour la table `interventions`
--
ALTER TABLE `interventions`
  ADD CONSTRAINT `FK_interventions_IDELEMENTMODULE` FOREIGN KEY (`IDELEMENTMODULE`) REFERENCES `elementsmodule` (`ID`),
  ADD CONSTRAINT `FK_interventions_IDPROFESSEUR` FOREIGN KEY (`IDPROFESSEUR`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `jours`
--
ALTER TABLE `jours`
  ADD CONSTRAINT `FK_jours_id_semaine` FOREIGN KEY (`id_semaine`) REFERENCES `semaines` (`ID`);

--
-- Contraintes pour la table `modules`
--
ALTER TABLE `modules`
  ADD CONSTRAINT `FK_modules_id_coordonnateur` FOREIGN KEY (`id_coordonnateur`) REFERENCES `utilisateurs` (`ID`),
  ADD CONSTRAINT `FK_modules_semestre` FOREIGN KEY (`semestre`) REFERENCES `semestres` (`ID`);

--
-- Contraintes pour la table `objectifs_formation`
--
ALTER TABLE `objectifs_formation`
  ADD CONSTRAINT `FK_objectifs_formation_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `objectifs_module`
--
ALTER TABLE `objectifs_module`
  ADD CONSTRAINT `FK_objectifs_module_Module_ID` FOREIGN KEY (`Module_ID`) REFERENCES `modules` (`ID`);

--
-- Contraintes pour la table `partenaires`
--
ALTER TABLE `partenaires`
  ADD CONSTRAINT `FK_partenaires_Filiere_ID` FOREIGN KEY (`Filiere_ID`) REFERENCES `filieres` (`ID`);

--
-- Contraintes pour la table `professeurs`
--
ALTER TABLE `professeurs`
  ADD CONSTRAINT `FK_professeurs_id` FOREIGN KEY (`id`) REFERENCES `utilisateurs` (`ID`);

--
-- Contraintes pour la table `seances`
--
ALTER TABLE `seances`
  ADD CONSTRAINT `FK_seances_id_element_module` FOREIGN KEY (`id_element_module`) REFERENCES `elementsmodule` (`ID`),
  ADD CONSTRAINT `FK_seances_id_jour` FOREIGN KEY (`id_jour`) REFERENCES `jours` (`ID`),
  ADD CONSTRAINT `FK_seances_id_salle` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`ID`);

--
-- Contraintes pour la table `seances_groupes`
--
ALTER TABLE `seances_groupes`
  ADD CONSTRAINT `FK_seances_groupes_groupe_id` FOREIGN KEY (`groupe_id`) REFERENCES `groupes` (`ID`),
  ADD CONSTRAINT `FK_seances_groupes_seance_id` FOREIGN KEY (`seance_id`) REFERENCES `seances` (`ID`);

--
-- Contraintes pour la table `semestres`
--
ALTER TABLE `semestres`
  ADD CONSTRAINT `FK_semestres_filiere` FOREIGN KEY (`filiere`) REFERENCES `filieres` (`ID`);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
