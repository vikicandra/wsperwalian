-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2016 at 04:46 AM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perwalian`
--

-- --------------------------------------------------------

--
-- Table structure for table `berita_acara`
--

CREATE TABLE `berita_acara` (
  `id_berita_acara` varchar(5) NOT NULL,
  `tgl` date NOT NULL,
  `perihal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `berita_acara`
--

INSERT INTO `berita_acara` (`id_berita_acara`, `tgl`, `perihal`) VALUES
('ba01', '2016-05-01', 'add IT203'),
('ba02', '2016-05-01', 'lorem lipsum'),
('ba03', '2016-05-04', 'Presensi menurun');

-- --------------------------------------------------------

--
-- Table structure for table `detail_perwalian`
--

CREATE TABLE `detail_perwalian` (
  `id_detail_perwalian` int(11) NOT NULL,
  `id_perwalian` int(11) NOT NULL,
  `kode_mk` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_perwalian`
--

INSERT INTO `detail_perwalian` (`id_detail_perwalian`, `id_perwalian`, `kode_mk`) VALUES
(1, 6, 'IT101'),
(2, 6, 'IT102'),
(3, 8, 'IT101'),
(4, 8, 'IT102'),
(5, 8, 'IT301'),
(6, 8, 'IT302');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_dosen` varchar(15) NOT NULL,
  `nama_dosen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_dosen`, `nama_dosen`) VALUES
('dos01', 'Badrus Salam ST'),
('dos02', 'Akmalulginan ST');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nrp` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` char(1) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `noTelp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nrp`, `nama`, `jk`, `alamat`, `noTelp`) VALUES
('01', 'Viki Candra T A', 'L', 'Bandung', '0811111'),
('02', 'Anggi', 'P', 'Bandung', '0812222'),
('03', 'Fadhiah', 'P', 'Buah Batu', '08180111'),
('04', 'Rifky', 'L', 'Cimahi', '0812131'),
('05', 'Aldila', 'P', 'Cibiru', '0821312');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `kode_mk` varchar(5) NOT NULL,
  `nama_mk` varchar(50) NOT NULL,
  `sks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`kode_mk`, `nama_mk`, `sks`) VALUES
('IT101', 'Agoritma Pemrograman 1', 3),
('IT102', 'Matematika Dasar', 3),
('IT201', 'Algoritma Pemrograman 2', 3),
('IT202', 'Matematika Logika', 3),
('IT203', 'Bahasa Indonesia', 2),
('IT204', 'Sistem Basis Data 1', 3),
('IT301', 'Sistem Basis Data 2', 3),
('IT302', 'Rekayasa Perangkat Lunak', 3),
('IT303', 'Ilmu Budaya Sunda', 2);

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `id_nilai` varchar(10) NOT NULL,
  `nrp` varchar(15) NOT NULL,
  `kode_mk` varchar(5) NOT NULL,
  `grade` char(1) DEFAULT NULL,
  `nilai_tugas` int(11) DEFAULT NULL,
  `nilai_quiz` int(11) DEFAULT NULL,
  `nilai_uts` int(11) DEFAULT NULL,
  `nilai_uas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `perwalian`
--

CREATE TABLE `perwalian` (
  `id_perwalian` int(11) NOT NULL,
  `nrp` varchar(15) NOT NULL,
  `id_dosen` varchar(15) NOT NULL,
  `semester` int(11) NOT NULL,
  `masa` int(11) NOT NULL,
  `status` varchar(5) NOT NULL,
  `id_berita_acara` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perwalian`
--

INSERT INTO `perwalian` (`id_perwalian`, `nrp`, `id_dosen`, `semester`, `masa`, `status`, `id_berita_acara`) VALUES
(6, '01', 'dos01', 1, 1, 'belum', NULL),
(8, '02', 'dos01', 1, 1, 'sudah', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `berita_acara`
--
ALTER TABLE `berita_acara`
  ADD PRIMARY KEY (`id_berita_acara`);

--
-- Indexes for table `detail_perwalian`
--
ALTER TABLE `detail_perwalian`
  ADD PRIMARY KEY (`id_detail_perwalian`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nrp`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`kode_mk`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_nilai`);

--
-- Indexes for table `perwalian`
--
ALTER TABLE `perwalian`
  ADD PRIMARY KEY (`id_perwalian`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_perwalian`
--
ALTER TABLE `detail_perwalian`
  MODIFY `id_detail_perwalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `perwalian`
--
ALTER TABLE `perwalian`
  MODIFY `id_perwalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
