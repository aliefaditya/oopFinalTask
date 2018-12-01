-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30 Nov 2018 pada 18.29
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_learning`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `latihan_soal`
--

CREATE TABLE `latihan_soal` (
  `ID_latihan_soal` int(3) NOT NULL,
  `level` int(1) NOT NULL,
  `soal` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_pelajaran`
--

CREATE TABLE `mata_pelajaran` (
  `kode_matpel` varchar(20) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `jenis_materi` varchar(30) NOT NULL,
  `score_kelulusan` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mata_pelajaran`
--

INSERT INTO `mata_pelajaran` (`kode_matpel`, `nama`, `jenis_materi`, `score_kelulusan`) VALUES
('A100', 'Bahasa_Indonesia', 'Essai', 75),
('A100', 'Bahasa_Indonesia', 'Essai', 75);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penilaian`
--

CREATE TABLE `penilaian` (
  `nilai` int(3) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `nik` varchar(10) NOT NULL,
  `kode_matpel` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penilaian`
--

INSERT INTO `penilaian` (`nilai`, `nis`, `nik`, `kode_matpel`) VALUES
(80, '130117400', '123', 'ABCH'),
(80, '130117400', '123', 'ABCH'),
(80, '1300', '23', 'BVCD');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nama` varchar(50) NOT NULL,
  `umur` int(2) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tgl_lahir` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `asal_sd` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `test`
--

CREATE TABLE `test` (
  `id_test` int(3) NOT NULL,
  `jenis_test` varchar(10) NOT NULL,
  `level` int(1) NOT NULL,
  `soal` varchar(1000) NOT NULL,
  `solusi` varchar(1000) NOT NULL,
  `kode_matpel` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `test`
--

INSERT INTO `test` (`id_test`, `jenis_test`, `level`, `soal`, `solusi`, `kode_matpel`) VALUES
(1, 'essai', 1, 'Penyajian karangan yang panjang dalam bentuk singkat disebut ', 'ringkasan', 'A100'),
(2, 'essai', 1, 'Tempat dan waktu terjadinya cerita disebut ', 'latar', 'A100'),
(3, 'essai', 1, 'Tanggapan tentang baik buruknya sesuatu disebut ', 'kritikan-kritik', 'A100'),
(4, 'essai', 1, 'Laporan yang dibuat setelah mengunjungi suatu tempat disebut ', 'laporan kunjungan', 'A100'),
(5, 'essai', 1, 'Wisata yang dulakukan untuk mengenal keanekaragaman negara kita disebut wisata', 'budaya', 'A100'),
(6, 'essai', 1, 'Wisata yang dilakukan di laut disebut wisata', 'bahari', 'A100'),
(7, 'essai', 1, 'Karangan yang tidak terikat bait dan rima disebut ', 'prosa', 'A100'),
(8, 'essai', 1, 'Mengubah puisi ke bentuk prosa disebut', 'parafrasa puisi', 'A100'),
(9, 'essai', 1, 'Kumpulan dari beberapa kata disebut ', 'kalimat', 'A100'),
(10, 'essai', 1, 'Najwa sedang menikmati rangkaian peristiwa dalam cerita " Keong Mas " yang dibacanya. Bagian kalimat yang dicetak miring dapat diganti dengan istilah', 'alur', 'A100'),
(11, 'essai', 1, 'Dalam drama, tokoh yang baik disebut juga ', 'protagonis', 'A100'),
(12, 'essai', 2, 'Tokoh yang berperan sebagai karakter yang jahat disbut juga', 'antagonis', 'A100'),
(13, 'essai', 2, 'Tempat terjadinya sebuah peristiwa disebut juga dengan', 'latar', 'A100'),
(14, 'essai', 2, 'Orang yang ahli dalam bidang rancang bangunan disebut ', 'arsitek', 'A100'),
(15, 'essai', 2, 'Salah  satu  keunggulan kompos yaitu dapat (baik) struktur  tanah. Kata  dalam  kurung  seharusnya  ditulis ', 'memperbaiki', 'A100'),
(16, 'essai', 2, 'Anak-anak mendengarkan penjelasan guru dengan seksama. Sinonim kata seksama yaitu ', 'Cermat', 'A100'),
(17, 'essai', 2, 'Karangan yang tidak terikat bait dan rima disebut ', 'prosa', 'A100'),
(18, 'essai', 2, 'Tanggapan tentang baik buruknya sesuatu disebut ', 'kritik', 'A100'),
(19, 'essai', 2, 'Rangkaian peristiwa dari suatu cerita secara runtut disebut ', 'alur', 'A100'),
(20, 'essai', 2, 'Dalam membuat laporan, bahasa yang digunakan adalah bahasa ', 'baku', 'A100'),
(21, 'essai', 3, 'Kata yang berlebihan atau tumpang tindih dalam sebuah kalimat disebut ', 'pleonasme', 'A100'),
(22, 'essai', 3, '22.	Kalimat yang berisikan gagasan pembiacara atau penulis secara singkat, jelas dan tepat disebut kalimat ', 'efektif', 'A100'),
(23, 'essai', 3, 'Antonim dari kata jauh adalah ', 'dekat', 'A100'),
(24, 'essai', 3, 'Sinonim dara kata laba ', 'keuntungan', 'A100'),
(25, 'essai', 3, '2 baris awal yang terdapat pada pantun disebut  sebagai ', 'sampiran', 'A100'),
(26, 'essai', 3, '2 baris akhir yang terdapat pada pantun disebut sebagai ', 'isi', 'A100'),
(27, 'essai', 3, '27.	Gabungan dari beberapa kalimat yang di kendalikan oleh kalimat topik atau kalimat utama adalah ', 'paragraf', 'A100'),
(28, 'essai', 3, '28.	Kalimat yang terletak di awal pargraf dan di mulai dengan pernyataan umum disebut paragraph ', 'deduktif', 'A100'),
(29, 'essai', 3, '29.	Kalimat utama yang terletidak di akhir paragraph dan di awalai dengan uraian yang bersifat khusus dengan pernyataan umum di akhir disebut paragraph ', 'induktif', 'A100'),
(30, 'essai', 3, '30.	Kalimat utama terletidak di awal dan akhir paragraph dan bersifat penegasan kembali dengan susunan kalimat yang agak berbeda disebut sebagai paragraph ', 'campuran', 'A100'),
(1, 'essai', 1, 'Penyajian karangan yang panjang dalam bentuk singkat disebut ', 'ringkasan', 'A100'),
(2, 'essai', 1, 'Tempat dan waktu terjadinya cerita disebut ', 'latar', 'A100'),
(3, 'essai', 1, 'Tanggapan tentang baik buruknya sesuatu disebut ', 'kritikan-kritik', 'A100'),
(4, 'essai', 1, 'Laporan yang dibuat setelah mengunjungi suatu tempat disebut ', 'laporan kunjungan', 'A100'),
(5, 'essai', 1, 'Wisata yang dulakukan untuk mengenal keanekaragaman negara kita disebut wisata', 'budaya', 'A100'),
(6, 'essai', 1, 'Wisata yang dilakukan di laut disebut wisata', 'bahari', 'A100'),
(7, 'essai', 1, 'Karangan yang tidak terikat bait dan rima disebut ', 'prosa', 'A100'),
(8, 'essai', 1, 'Mengubah puisi ke bentuk prosa disebut', 'parafrasa puisi', 'A100'),
(9, 'essai', 1, 'Kumpulan dari beberapa kata disebut ', 'kalimat', 'A100'),
(10, 'essai', 1, 'Najwa sedang menikmati rangkaian peristiwa dalam cerita " Keong Mas " yang dibacanya. Bagian kalimat yang dicetak miring dapat diganti dengan istilah', 'alur', 'A100'),
(11, 'essai', 1, 'Dalam drama, tokoh yang baik disebut juga ', 'protagonis', 'A100'),
(12, 'essai', 2, 'Tokoh yang berperan sebagai karakter yang jahat disbut juga', 'antagonis', 'A100'),
(13, 'essai', 2, 'Tempat terjadinya sebuah peristiwa disebut juga dengan', 'latar', 'A100'),
(14, 'essai', 2, 'Orang yang ahli dalam bidang rancang bangunan disebut ', 'arsitek', 'A100'),
(15, 'essai', 2, 'Salah  satu  keunggulan kompos yaitu dapat (baik) struktur  tanah. Kata  dalam  kurung  seharusnya  ditulis ', 'memperbaiki', 'A100'),
(16, 'essai', 2, 'Anak-anak mendengarkan penjelasan guru dengan seksama. Sinonim kata seksama yaitu ', 'Cermat', 'A100'),
(17, 'essai', 2, 'Karangan yang tidak terikat bait dan rima disebut ', 'prosa', 'A100'),
(18, 'essai', 2, 'Tanggapan tentang baik buruknya sesuatu disebut ', 'kritik', 'A100'),
(19, 'essai', 2, 'Rangkaian peristiwa dari suatu cerita secara runtut disebut ', 'alur', 'A100'),
(20, 'essai', 2, 'Dalam membuat laporan, bahasa yang digunakan adalah bahasa ', 'baku', 'A100'),
(21, 'essai', 3, 'Kata yang berlebihan atau tumpang tindih dalam sebuah kalimat disebut ', 'pleonasme', 'A100'),
(22, 'essai', 3, '22.	Kalimat yang berisikan gagasan pembiacara atau penulis secara singkat, jelas dan tepat disebut kalimat ', 'efektif', 'A100'),
(23, 'essai', 3, 'Antonim dari kata jauh adalah ', 'dekat', 'A100'),
(24, 'essai', 3, 'Sinonim dara kata laba ', 'keuntungan', 'A100'),
(25, 'essai', 3, '2 baris awal yang terdapat pada pantun disebut  sebagai ', 'sampiran', 'A100'),
(26, 'essai', 3, '2 baris akhir yang terdapat pada pantun disebut sebagai ', 'isi', 'A100'),
(27, 'essai', 3, '27.	Gabungan dari beberapa kalimat yang di kendalikan oleh kalimat topik atau kalimat utama adalah ', 'paragraf', 'A100'),
(28, 'essai', 3, '28.	Kalimat yang terletak di awal pargraf dan di mulai dengan pernyataan umum disebut paragraph ', 'deduktif', 'A100'),
(29, 'essai', 3, '29.	Kalimat utama yang terletidak di akhir paragraph dan di awalai dengan uraian yang bersifat khusus dengan pernyataan umum di akhir disebut paragraph ', 'induktif', 'A100'),
(30, 'essai', 3, '30.	Kalimat utama terletidak di awal dan akhir paragraph dan bersifat penegasan kembali dengan susunan kalimat yang agak berbeda disebut sebagai paragraph ', 'campuran', 'A100');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tutor`
--

CREATE TABLE `tutor` (
  `nama` varchar(50) NOT NULL,
  `umur` int(2) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `tgl_lahir` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nik` varchar(10) NOT NULL,
  `no_ijazah` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
