-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2025 at 11:44 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `erp`
--

-- --------------------------------------------------------

--
-- Table structure for table `academic_details`
--

CREATE TABLE `academic_details` (
  `id` bigint(20) NOT NULL,
  `admission_year` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `previous_college_name` varchar(255) DEFAULT NULL,
  `previous_course_name` varchar(255) DEFAULT NULL,
  `previous_passing_year` varchar(255) DEFAULT NULL,
  `previous_year_percentage` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  `session` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `academic_details`
--

INSERT INTO `academic_details` (`id`, `admission_year`, `course`, `department`, `full_name`, `medium`, `previous_college_name`, `previous_course_name`, `previous_passing_year`, `previous_year_percentage`, `section`, `session`, `student_id`) VALUES
(1, '2025', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'Ajinkya Dhavale', 'English', 'New Arts College Ahmednagr', 'B.Sc. Computer Science', '2024', '91.33', 'A', '2024-2026', '20250001');

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `admin_id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `password`, `role`, `username`) VALUES
(1, 'account', 'account', 'account@gmail.com'),
(2, 'library', 'library', 'library@gmail.com'),
(3, 'scholarship', 'scholarship', 'scholarship@gmail.com'),
(4, 'admin', 'admin', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `admission`
--

CREATE TABLE `admission` (
  `admission_id` bigint(20) NOT NULL,
  `aadhar_no` varchar(255) NOT NULL,
  `admission_generated_id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `flag` int(11) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `start_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admission`
--

INSERT INTO `admission` (`admission_id`, `aadhar_no`, `admission_generated_id`, `email`, `first_name`, `flag`, `last_name`, `middle_name`, `password`, `start_date`) VALUES
(1, '671731011502', '20250001', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'admin', '14-02-2025'),
(14, '123456789012', '20250014', 'Ganarm2003@gmail.com', 'Ganesh', 0, 'Mali', 'Rajendra ', 'student', '14-02-2025'),
(15, '123456789013', '20250015', 'ajinkya@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(16, '671731011509', '20250016', 'ajinkyadhavale96041@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(17, '671731011504', '20250017', 'ajinkyadhava2le9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(18, '672731011502', '20250018', 'ajinkyadhav2ale9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(19, '671721011502', '20250019', 'ajinkyadhavale93604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(20, '611731011502', '20250020', 'ajinkyadavale9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-02-2025'),
(21, '127688712876', '20250021', 'vaibhavi@gmail.com', 'vaibhavi', 0, 'pasalkar', 'sanjay', 'student', '15-02-2025'),
(23, '132222213142', '20250022', 'vaibhavipasalkar2004@gmail.com', 'Vaibhavi', 0, 'Pasalkar', 'Sanjay', 'Vaibhavi@123', '18-02-2025'),
(24, '873678682721', '20250024', 'jadhavsakshi137@gmail.com', 'Sakshi', 0, 'Sarpanch', 'Dagdu', 'student', '18-02-2025'),
(25, '675765757576', '20250025', 'ganeshmali.fc@gmail.com', 'Ganesh', 0, 'Mali', 'Rajendra ', 'student', '18-02-2025'),
(26, '787678768767', '20250026', 'alvfcoc@gmail.com', 'Arin', 0, 'Dhimar', 'Ajinkya', 'student', '18-02-2025'),
(28, '923897987828', '20250027', 'dhavaleajinkya04@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '19-02-2025'),
(29, '861287686328', '20250029', 'krushnaandhale2246@gmail.com', 'Krushna', 0, 'Andhale', 'Sunil', 'student', '21-02-2025'),
(30, '786786676278', '20250030', 'tileharshad@gmail.com', 'Harshad', 0, 'Tile', 'Bhagwan', 'student', '25-02-2025');

-- --------------------------------------------------------

--
-- Table structure for table `personal_details`
--

CREATE TABLE `personal_details` (
  `id` bigint(20) NOT NULL,
  `abc_number` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `caste` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `family_income` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `father_occupation` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `handicap` varchar(255) DEFAULT NULL,
  `handicap_percentage` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `mother_occupation` varchar(255) DEFAULT NULL,
  `mother_tongue` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `pan_number` varchar(255) DEFAULT NULL,
  `parent_mobile` varchar(255) DEFAULT NULL,
  `place_of_birth` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `sub_caste` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `personal_details`
--

INSERT INTO `personal_details` (`id`, `abc_number`, `blood_group`, `caste`, `dob`, `family_income`, `father_name`, `father_occupation`, `gender`, `handicap`, `handicap_percentage`, `marital_status`, `mobile`, `mother_name`, `mother_occupation`, `mother_tongue`, `nationality`, `occupation`, `pan_number`, `parent_mobile`, `place_of_birth`, `religion`, `student_id`, `sub_caste`) VALUES
(3, '122345323332', 'B+', 'OBC', '2003-04-22', '8768678687', 'Balasaheb', 'Farmer', 'Male', 'Yes', '', 'Single', '9604912407', 'Ashabai', 'House wife', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '9922178258', 'Shevgaon', 'Hindu', '20250001', 'Kunbi'),
(5, '122345323332', 'O+', 'Maratha', '2004-01-15', '876876879', 'Sanjay', 'Machine Operator', 'Female', 'No', '00', 'Single', '1234567890', 'Ujwala', 'House wife', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '1234567890', 'Pune', 'Hindu', '20250022', 'Kunbi');

-- --------------------------------------------------------

--
-- Table structure for table `student_address`
--

CREATE TABLE `student_address` (
  `id` bigint(20) NOT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `permanent_city` varchar(255) DEFAULT NULL,
  `permanent_country` varchar(255) DEFAULT NULL,
  `permanent_district` varchar(255) DEFAULT NULL,
  `permanent_pincode` varchar(255) DEFAULT NULL,
  `permanent_state` varchar(255) DEFAULT NULL,
  `permanent_taluka` varchar(255) DEFAULT NULL,
  `same_as_permanent` bit(1) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `temporary_address` varchar(255) DEFAULT NULL,
  `temporary_city` varchar(255) DEFAULT NULL,
  `temporary_country` varchar(255) DEFAULT NULL,
  `temporary_district` varchar(255) DEFAULT NULL,
  `temporary_pincode` varchar(255) DEFAULT NULL,
  `temporary_state` varchar(255) DEFAULT NULL,
  `temporary_taluka` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_address`
--

INSERT INTO `student_address` (`id`, `permanent_address`, `permanent_city`, `permanent_country`, `permanent_district`, `permanent_pincode`, `permanent_state`, `permanent_taluka`, `same_as_permanent`, `student_id`, `temporary_address`, `temporary_city`, `temporary_country`, `temporary_district`, `temporary_pincode`, `temporary_state`, `temporary_taluka`) VALUES
(1, 'Shevgaon', 'Ahmednagar', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon', b'1', '20250001', 'Shevgaon', 'Ahmednagar', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon');

-- --------------------------------------------------------

--
-- Table structure for table `tc`
--

CREATE TABLE `tc` (
  `id` bigint(20) NOT NULL,
  `account_approval` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_approval` int(11) DEFAULT NULL,
  `new_admission_type` varchar(255) DEFAULT NULL,
  `alternate_no` varchar(255) DEFAULT NULL,
  `application_date` datetime(6) DEFAULT NULL,
  `application_fee` double DEFAULT NULL,
  `birth_date_proof` varchar(255) DEFAULT NULL,
  `caste_category` varchar(255) DEFAULT NULL,
  `certificate_reason` varchar(255) DEFAULT NULL,
  `certificate_type` varchar(255) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `dob_in_words` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identity_proof` varchar(255) DEFAULT NULL,
  `last_cgpa` varchar(255) DEFAULT NULL,
  `last_class` varchar(255) DEFAULT NULL,
  `last_exam_month` varchar(255) DEFAULT NULL,
  `last_exam_name` varchar(255) DEFAULT NULL,
  `last_exam_year` varchar(255) DEFAULT NULL,
  `last_grade` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `last_result` varchar(255) DEFAULT NULL,
  `last_seat_no` varchar(255) DEFAULT NULL,
  `last_sem` varchar(255) DEFAULT NULL,
  `latest_marksheet` varchar(255) DEFAULT NULL,
  `library_approval` int(11) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `new_course` varchar(255) DEFAULT NULL,
  `passing_certificate` varchar(255) DEFAULT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `payment_id` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `processing_fee` double DEFAULT NULL,
  `proof_of_admission` varchar(255) DEFAULT NULL,
  `scholarship_approval` int(11) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `tc_type` varchar(255) DEFAULT NULL,
  `total_fee` double DEFAULT NULL,
  `university_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_details`
--
ALTER TABLE `academic_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `UKmi8vkhus4xbdbqcac2jm4spvd` (`username`);

--
-- Indexes for table `admission`
--
ALTER TABLE `admission`
  ADD PRIMARY KEY (`admission_id`),
  ADD UNIQUE KEY `UKfpxhfssqbp21wwriuwi56cii1` (`aadhar_no`),
  ADD UNIQUE KEY `UKe64i7gtedoglh6cwagkxsweqh` (`admission_generated_id`),
  ADD UNIQUE KEY `UKkvoqktp8nnfqucx1ykwqmo9sm` (`email`);

--
-- Indexes for table `personal_details`
--
ALTER TABLE `personal_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_address`
--
ALTER TABLE `student_address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tc`
--
ALTER TABLE `tc`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academic_details`
--
ALTER TABLE `academic_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `admission`
--
ALTER TABLE `admission`
  MODIFY `admission_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `personal_details`
--
ALTER TABLE `personal_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `student_address`
--
ALTER TABLE `student_address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tc`
--
ALTER TABLE `tc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
