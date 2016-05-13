-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2016 at 08:35 PM
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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('01', '01'),
('02', '02'),
('03', '03'),
('04', '04'),
('dos01', 'dos01'),
('dos02', 'dos02'),
('ksbap1', 'ksbap1'),
('ksbap2', 'ksbap2');

-- --------------------------------------------------------

--
-- Table structure for table `berita_acara`
--

CREATE TABLE `berita_acara` (
  `id_berita_acara` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `perihal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `berita_acara`
--

INSERT INTO `berita_acara` (`id_berita_acara`, `tgl`, `perihal`) VALUES
(1, '2016-05-01', 'add IT203'),
(2, '2016-05-01', 'lorem lipsum'),
(3, '2016-05-04', 'Presensi menurun');

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
(7, 14, 'IT101'),
(8, 14, 'IT102'),
(9, 15, 'IT101'),
(10, 15, 'IT102'),
(11, 18, 'IT101');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_dosen` varchar(15) NOT NULL,
  `nama_dosen` varchar(50) NOT NULL,
  `tglLahir` date NOT NULL,
  `noTelp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_dosen`, `nama_dosen`, `tglLahir`, `noTelp`) VALUES
('dos01', 'Badrus Salam ST', '1970-04-01', '0812983427'),
('dos02', 'Akmalulginan ST', '1980-11-11', '08321321'),
('dos03', 'Sulaeman MT', '1980-07-01', '09821312'),
('dos04', 'Aan MT', '1978-12-01', '0212131231');

-- --------------------------------------------------------

--
-- Table structure for table `kontrak_matakuliah`
--

CREATE TABLE `kontrak_matakuliah` (
  `idKontrakMatakuliah` int(11) NOT NULL,
  `nrp` varchar(10) NOT NULL,
  `kode_mk` varchar(10) NOT NULL,
  `semester` int(11) NOT NULL,
  `status` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `krs`
--

CREATE TABLE `krs` (
  `idKrs` int(11) NOT NULL,
  `nrp` varchar(15) NOT NULL,
  `kode_mk` varchar(10) NOT NULL,
  `semester` int(11) NOT NULL,
  `status` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `krs`
--

INSERT INTO `krs` (`idKrs`, `nrp`, `kode_mk`, `semester`, `status`) VALUES
(13, '01', 'IT101', 1, 'tunda'),
(14, '01', 'IT102', 1, 'tunda'),
(15, '02', 'IT101', 1, 'tunda'),
(16, '02', 'IT102', 1, 'tunda'),
(17, '03', 'IT101', 1, 'tunda'),
(18, '03', 'IT102', 1, 'tunda');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nrp` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` char(1) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `noTelp` varchar(15) NOT NULL,
  `tglLahir` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `ipk` float NOT NULL,
  `kehadiran` float NOT NULL,
  `id_dosen` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nrp`, `nama`, `jk`, `alamat`, `noTelp`, `tglLahir`, `email`, `ipk`, `kehadiran`, `id_dosen`) VALUES
('01', 'Viki Candra T A', 'L', 'Bandung', '0811111', '1994-06-01', 'viki@gmail.com', 4, 95, 'dos01'),
('02', 'Anggi', 'P', 'Bandung', '0812222', '1995-05-11', 'anggi@yahoo.com', 3.8, 100, 'dos01'),
('03', 'Fadhiah', 'P', 'Buah Batu', '08180111', '1996-04-01', 'Fadhiah@rocketmail.com', 3.9, 100, 'dos01'),
('04', 'Rifky', 'L', 'Cimahi', '0812131', '1995-12-31', 'rifky@gmail.com', 3.6, 90, 'dos02'),
('05', 'Aldila', 'P', 'Cibiru', '0821312', '1997-01-27', 'dila@gmai.com', 3.8, 75, 'dos02');

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
  `semester` int(11) NOT NULL,
  `status` varchar(5) NOT NULL,
  `id_berita_acara` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perwalian`
--

INSERT INTO `perwalian` (`id_perwalian`, `nrp`, `semester`, `status`, `id_berita_acara`) VALUES
(14, '01', 1, 'tunda', NULL),
(15, '02', 1, 'tunda', NULL),
(18, '03', 1, 'tunda', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

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
-- Indexes for table `kontrak_matakuliah`
--
ALTER TABLE `kontrak_matakuliah`
  ADD PRIMARY KEY (`idKontrakMatakuliah`);

--
-- Indexes for table `krs`
--
ALTER TABLE `krs`
  ADD PRIMARY KEY (`idKrs`);

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
-- AUTO_INCREMENT for table `berita_acara`
--
ALTER TABLE `berita_acara`
  MODIFY `id_berita_acara` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `detail_perwalian`
--
ALTER TABLE `detail_perwalian`
  MODIFY `id_detail_perwalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `kontrak_matakuliah`
--
ALTER TABLE `kontrak_matakuliah`
  MODIFY `idKontrakMatakuliah` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `krs`
--
ALTER TABLE `krs`
  MODIFY `idKrs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `perwalian`
--
ALTER TABLE `perwalian`
  MODIFY `id_perwalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
