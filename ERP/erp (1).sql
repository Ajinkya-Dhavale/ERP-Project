-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2025 at 07:23 PM
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
(1, '2025', 'B.Sc. Data Science', 'Data Science & Artificial Intelligence', 'Ajinkya Dhavale', 'English', 'New Arts College Ahmednagr', 'B.Sc. Computer Science', '2024', '91.33', 'A', '2024-2026', '20250001'),
(2, '2025', '', 'Agriculture & Allied Sciences', '', '', '', '', '', '', '', '', '20250022'),
(3, '2025', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'Mali Ganesh Rajendra', 'English', 'New Arts College Ahmednagr', 'B.Sc. Computer Science', '2024', '90.99', 'A', '2024-2025', '20250014'),
(7, '2025', 'M.Sc. Computer Science', 'Computer Science & Applications', 'Mali Ganesh Rajendra', 'English', 'New Arts College Ahmednagr', 'B.Sc. Botany', '2024', '91.33', 'A', '2025-2026', '20250035');

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
(1, '671731011502', '20250001', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'Ajinkya@123', '14-02-2025'),
(14, '123456789012', '20250014', 'ganarm2003@gmail.com', 'Ganesh', 0, 'Mali', 'Rajendra ', 'student', '14-02-2025'),
(23, '132222213142', '20250022', 'vaibhavipasalkar2004@gmail.com', 'Vaibhavi', 0, 'Pasalkar', 'Sanjay', '123', '18-02-2025'),
(24, '873678682721', '20250024', 'jadhavsakshi137@gmail.com', 'Sakshi', 0, 'Sarpanch', 'Dagdu', 'student', '18-02-2025'),
(25, '675765757576', '20250025', 'ganeshmali.fc@gmail.com', 'Ganesh', 0, 'Mali', 'Rajendra ', 'Ganesh', '18-02-2025'),
(29, '861287686328', '20250029', 'krushnaandhale2246@gmail.com', 'Krushna', 0, 'Andhale', 'Sunil', 'student', '21-02-2025'),
(30, '786786676278', '20250030', 'tileharshad@gmail.com', 'Harshad', 0, 'Tile', 'Bhagwan', 'student', '25-02-2025'),
(32, '989234234234', '20250032', 'waykarvishal43@gmail.com', 'Vishal', 0, 'Waykar', 'Vijay', 'student', '07-03-2025'),
(33, '878686887878', '20250033', 'yuvasmail1@gmail.com', 'Yuvraj', 0, 'Sonawane', 'Tushar', 'student', '08-03-2025'),
(34, '878912883886', '20250034', 'uma.madje@fergusson.edu', 'Uma', 0, 'Madje', 'abc', 'student', '10-03-2025'),
(37, '671731011505', '20250035', 'shindea555555@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '14-03-2025'),
(39, '283778823778', '20250039', 'ganarm2002@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '17-03-2025'),
(47, '671711011502', '20250040', 'dhavaleajinkya9604@gmail.com', 'Ajinkya', 0, 'Dhavale', 'Balasaheb', 'student', '20-03-2025');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `admin_approval` int(11) DEFAULT NULL,
  `application_date` datetime(6) DEFAULT NULL,
  `certificate_reason` varchar(255) DEFAULT NULL,
  `certificate_type` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `division` varchar(255) DEFAULT NULL,
  `fee_reciept_path` varchar(255) DEFAULT NULL,
  `from_date` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identity_proof_path` varchar(255) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_verified_date` varchar(255) DEFAULT NULL,
  `to_date` varchar(255) DEFAULT NULL,
  `verification_letter_path` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `admin_approval`, `application_date`, `certificate_reason`, `certificate_type`, `course`, `department`, `division`, `fee_reciept_path`, `from_date`, `full_name`, `gender`, `identity_proof_path`, `issue_date`, `student_id`, `teacher_name`, `teacher_verified_date`, `to_date`, `verification_letter_path`, `year`) VALUES
(1, 1, '2025-03-12 16:34:58.000000', 'No', 'Attendance Certificate', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'A', '1741777498281_Figure_1.png', '2003-04-12', 'Dhavale Ajinkya Balasaheb', 'Male', '1741777498258_Figure_1.png', '2025-03-12 18:02:52.000000', '20250001', 'Uma Madje ', '2025-03-13', '2025-03-14', '1741777498296_attendance (2).jpg', NULL),
(5, 1, '2025-03-27 20:10:12.000000', 'Nokjhkjs.', 'Attendance Certificate', 'B.Sc. Data Science', 'Data Science & Artificial Intelligence', 'A', '1743086412513_photo New .jpg', '2025-03-21', 'Dhavale Ajinkya Balasaheb', 'Female', '1743086412486_photo New .jpg', NULL, '20250001', 'Mrs. Uma Madje Mam', '2025-03-26', '2025-03-22', '1743086412530_photo New .jpg', '2024-2025'),
(6, 0, '2025-03-27 20:43:33.000000', 'No\r\n', 'Attendance Certificate', 'M.Sc. Computer Science', 'Computer Science & Applications', 'A', '1743088413274_photo New .jpg', '2025-02-28', 'Dhavale Ajinkya Balasaheb', 'Male', '1743088413245_photo.jpg', NULL, '20250035', 'Mrs. Uma Madje Mam', '2025-03-20', '2025-03-13', '1743088413300_Photo New 2.jpg', '2024-2025');

-- --------------------------------------------------------

--
-- Table structure for table `bonafide`
--

CREATE TABLE `bonafide` (
  `id` bigint(20) NOT NULL,
  `admin_approval` int(11) DEFAULT NULL,
  `application_date` datetime(6) DEFAULT NULL,
  `birth_proof_path` varchar(255) DEFAULT NULL,
  `certificate_reason` varchar(255) DEFAULT NULL,
  `certificate_type` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `division` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `dob_in_words` varchar(255) DEFAULT NULL,
  `fee_receipt_path` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identity_proof_path` varchar(255) DEFAULT NULL,
  `local_address` varchar(255) DEFAULT NULL,
  `payment_id` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `total_fees` double DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bonafide`
--

INSERT INTO `bonafide` (`id`, `admin_approval`, `application_date`, `birth_proof_path`, `certificate_reason`, `certificate_type`, `course`, `department`, `division`, `dob`, `dob_in_words`, `fee_receipt_path`, `full_name`, `gender`, `identity_proof_path`, `local_address`, `payment_id`, `payment_status`, `permanent_address`, `student_id`, `total_fees`, `year`, `issue_date`) VALUES
(5, 1, '2025-03-09 15:27:59.000000', '1741514279793_Figure_1.png', 'No', 'Bonafide Certificate', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'A', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', '1741514279812_Figure_1.png', 'Dhavale Ajinkya Balasaheb', 'Male', '1741514279766_Figure_1.png', 'Shevgaon', 'pay_Q4eOPosGHTIcC2', 'Paid', 'Shevgaon', '20250001', 50, '2024-2025', '2025-03-09 20:08:46.000000'),
(6, 2, '2025-03-09 20:13:57.000000', '1741531437420_WhatsApp Image 2025-03-02 at 12.28.14_d9f59bf8.jpg', 'For scholarship', 'Bonafide Certificate', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'A', '2025-03-19', 'NINETEENTH MARCH TWO THOUSAND TWENTY FIVE', '1741531437442_WhatsApp Image 2025-03-02 at 12.28.14_d9f59bf8.jpg', 'Dhavale Ajinkya Balasaheb', 'Male', '1741531437376_WhatsApp Image 2025-03-02 at 12.28.14_d9f59bf8.jpg', 'Shevgaon', 'pay_Q4jGScSiPf0Weg', 'Paid', 'Shevgaon', '20250001', 50, '2024-2025', NULL),
(9, 2, '2025-03-10 10:36:50.000000', '1741583210788_Figure_1.png', 'No', 'Bonafide Certificate', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'A', '2003-09-07', 'SEVENTH SEPTEMBER TWO THOUSAND THREE', '1741583210799_Figure_1.png', 'Dhavale Ajinkya Balasaheb', 'Male', '1741583210774_Figure_1.png', 'Shevgaon', 'pay_Q4xy0ufZVng5VM', 'Paid', 'Shevgaon', '20250001', 50, '2024-2025', NULL),
(10, 1, '2025-03-10 10:43:14.000000', '1741583594334_Figure_1.png', 'Scholarship', 'Bonafide Certificate', 'M.Sc.Computer Scinece', 'Computer Science & Applications', 'A', '2003-09-07', 'SEVENTH SEPTEMBER TWO THOUSAND THREE', '1741583594346_Figure_1.png', 'Mali Ganesh Rajendra ', 'Male', '1741583594323_Figure_1.png', 'Dattawadi', 'pay_Q4y4ksUuRKs2r9', 'Paid', 'Dattawadi', '20250014', 50, '2024-2025', '2025-03-17 17:17:25.000000'),
(15, 1, '2025-03-27 17:04:54.000000', '1743075294164_photo New .jpg', 'No', 'Bonafide Certificate', 'B.Sc. Data Science', 'Data Science & Artificial Intelligence', 'A', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', '1743075294189_signature.jpg', 'Dhavale Ajinkya Balasaheb', 'Female', '1743075294045_photo New .jpg', 'Shevgaon', 'pay_QBneOeRxaf5seu', 'Paid', 'Shevgaon', '20250001', 50, '2024-2025', NULL),
(18, 0, '2025-03-27 20:14:28.000000', '1743086668669_photo New .jpg', 'Lk', 'Bonafide Certificate', 'B.Sc. Data Science', 'Data Science & Artificial Intelligence', 'A', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', '1743086668704_photo New .jpg', 'Dhavale Ajinkya Balasaheb', 'Female', '1743086668628_photo New .jpg', 'Shevgaon', 'pay_QBqso1fAySecuu', 'Paid', 'Shevgaon', '20250001', 50, '2024-2025', NULL),
(19, 0, '2025-03-27 20:28:11.000000', '1743087491579_photo New .jpg', 'No', 'Bonafide Certificate', 'M.Sc. Computer Science', 'Computer Science & Applications', 'A', '2010-03-25', 'TWENTY FIFTH MARCH TWO THOUSAND TEN', '1743087491597_photo New .jpg', 'Dhavale Ajinkya Balasaheb', 'Male', '1743087491560_photo New .jpg', 'S/o balasaheb dhavale , at hingangaon ne, post johrapur, tal shevgaon', 'pay_QBr7gaXnB3R28B', 'Paid', 'S/o balasaheb dhavale , at hingangaon ne, post johrapur, tal shevgaon', '20250035', 50, '2024-2025', NULL);

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
(3, '122345323332', 'B+', 'OBC', '2003-04-22', '8768678687', 'Balasaheb', 'Farmer', 'Female', 'No', NULL, 'Single', '9604912407', 'Ashabai', 'None', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '9922178258', 'Shevgaon', 'Hindu', '20250001', 'Kunbi'),
(5, '122345323332', 'O+', 'Maratha', '2004-01-15', '876876879', 'Sanjay', 'Machine Operator', 'Female', 'No', '00', 'Single', '1234567890', 'Ujwala', 'House wife', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '1234567890', 'Pune', 'Hindu', '20250022', 'Kunbi'),
(6, '122345323332', 'O+', 'Mali', '2003-09-07', '8768678687', 'Rajendra', 'Farmer', 'Male', 'No', '0', 'Single', '9021817579', 'Bebabai', 'House wife  ', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '9021817579', 'Nashik', 'Hindu', '20250014', 'FulMali'),
(7, '122345323332', 'A-', 'OBC', '2010-03-25', '8768678687', 'Balasaheb', 'Farmer', 'Male', 'Yes', '74', 'Single', '9604912407', 'Ashabai', 'House Wife', 'Marathi', 'Indian', 'Student', 'ABCDE2345F', '9604912407', 'Shevgaon', 'Hindu', '20250035', 'Kunbi ');

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
(1, 'Shevgaon', 'Ahmednagar', 'India ', 'Ahilyanagar', '414502', 'Maharashtra', 'Shevgaon', b'1', '20250001', 'Shevgaon', 'Ahmednagar', 'India ', 'Ahilyanagar', '414502', 'Maharashtraaksdkjh', 'Shevgaon'),
(2, 'Ahmednagar', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon', b'1', '20250022', 'Ahmednagar', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon'),
(3, 'Ahmednagar', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon', b'1', '20250032', 'Ahmednagar', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon'),
(4, 'Dattawadi', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon', b'1', '20250014', 'Dattawadi', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon'),
(5, 'Dss  akjd', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon', b'1', '20250040', 'Dss', 'AHMED NAGAR', 'India', 'Ahilyanagar', '414502', 'MAHARASHTRA', 'Shevgaon'),
(6, 'S/o balasaheb dhavale , at hingangaon ne, post johrapur, tal shevgaon', 'Ahmed nagar', 'India', 'Ahilyanagar', '414502', 'Maharashtra', 'Shevgaon', b'1', '20250035', 'S/o balasaheb dhavale , at hingangaon ne, post johrapur, tal shevgaon', 'Ahmed nagar', 'India', 'Ahilyanagar', '414502', 'Maharashtra', 'Shevgaon');

-- --------------------------------------------------------

--
-- Table structure for table `student_document`
--

CREATE TABLE `student_document` (
  `id` bigint(20) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_document`
--

INSERT INTO `student_document` (`id`, `photo`, `sign`, `student_id`) VALUES
(3, '1743070880333_Photo New 2.jpg', '1743070880357_signature.jpg', '20250001'),
(4, '1741583454889_WhatsApp Image 2025-03-10 at 10.28.18_4685223f.jpg', NULL, '20250014'),
(5, '1743086855009_Photo New 2.jpg', NULL, '20250035'),
(6, '1742495938597_photo New .jpg', NULL, '20250022');

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
  `university_name` varchar(255) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tc`
--

INSERT INTO `tc` (`id`, `account_approval`, `address`, `admin_approval`, `new_admission_type`, `alternate_no`, `application_date`, `application_fee`, `birth_date_proof`, `caste_category`, `certificate_reason`, `certificate_type`, `college_name`, `contact_no`, `course`, `department`, `dob`, `dob_in_words`, `email_id`, `first_name`, `gender`, `identity_proof`, `last_cgpa`, `last_class`, `last_exam_month`, `last_exam_name`, `last_exam_year`, `last_grade`, `last_name`, `last_result`, `last_seat_no`, `last_sem`, `latest_marksheet`, `library_approval`, `middle_name`, `new_course`, `passing_certificate`, `payment_date`, `payment_id`, `payment_status`, `processing_fee`, `proof_of_admission`, `scholarship_approval`, `student_id`, `tc_type`, `total_fee`, `university_name`, `issue_date`) VALUES
(8, 1, 'Shevgaon', 1, 'Maharashtra Student', '9604912407', '2025-03-05 23:40:15.000000', 100, '1741198215757_WhatsApp Image 2025-03-02 at 12.28.14_d9f59bf8.jpg', 'OBC', 'No\r\n', 'Transference Certificate', 'Fergusson College', '9604912407', 'B.Sc. Computer Science', 'Computer Science & Applications', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 'Male', '1741198215772_WhatsApp Image 2025-03-02 at 11.35.42_9b4aa567.jpg', '9.76', 'TY', 'April', 'TY B.Sc. Computer Science', '2024', 'O', 'Dhavale', 'Passed', '2100728', 'SEM VI', '1741198215716_Figure_1.png', 1, 'Balasaheb', 'M.Sc. Computer Science', '1741198215731_WhatsApp Image 2025-03-02 at 10.45.19_01c54615.jpg', '2025-03-05 23:40:15.000000', 'pay_Q3CdwgncyZeWip', 'Paid', 50, '1741198215744_WhatsApp Image 2025-03-02 at 11.35.42_9b4aa567.jpg', 1, '20250001', 'Original', 150, 'Sppu', '2025-03-08 22:30:56.000000'),
(19, 1, 'Shevgaon', 1, 'Maharashtra Student', '', '2025-03-08 17:25:45.000000', 100, '1741434945974_WhatsApp Image 2025-02-16 at 12.59.46_389b5887.jpg', 'OBC', 'No\r\n', 'Transference Certificate', 'Fergusson College', '9604912407', 'M.Sc. Computer Science', 'Computer Science & Applications', '', '', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 'Male', '1741434946000_WhatsApp Image 2025-03-02 at 11.35.42_9b4aa567.jpg', '9.23', 'M.Sc. II', 'April', 'M.Sc. II Computer Science', '2025', 'O', 'Dhavale', 'Passed', '123212', 'SEM IV', '1741434945888_Figure_1.png', 1, 'Balasaheb', 'B.Sc. Forensic Science', '1741434945924_WhatsApp Image 2025-03-02 at 10.45.19_01c54615.jpg', '2025-03-08 17:25:45.000000', 'pay_Q4Hraa7B22LUh7', 'Paid', 50, '1741434945953_WhatsApp Image 2025-03-02 at 11.35.42_9b4aa567.jpg', 1, '20250001', 'Duplicate', 150, 'Sppu', '2025-03-08 17:36:17.000000'),
(21, 1, 'Shevgaon', 1, 'Maharashtra Student', '', '2025-03-27 23:12:03.000000', 100, '1743097323825_photo New .jpg', 'OBC', 'No', 'Transference Certificate', 'Fergusson College', '9604912407', 'M.Sc. Computer Science', 'Computer Science & Applications', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 'Female', '1743097323841_photo New .jpg', '9.00', 'M.Sc. I', 'February', 'M.Sc. I Computer Science', '2024', 'O', 'Dhavale', 'Passed', '231235', 'SEM I', '1743097323778_photo New .jpg', 1, 'Balasaheb', 'B.Sc. Zoology', '1743097323798_photo New .jpg', '2025-03-27 23:12:03.000000', 'pay_QBtt50pmkrcq9O', 'Paid', 50, '1743097323810_photo New .jpg', 1, '20250001', 'Duplicate', 150, 'Sppu', NULL),
(22, 0, 'Shevgaon', 0, 'Maharashtra Student', '', '2025-03-27 23:47:12.000000', 200, '1743099433035_10th marksheet.jpg', 'OBC', 'Change the college\r\n', 'Migration Certificate', 'Fergusson College', '9604912407', 'M.Sc. Computer Science', 'Computer Science & Applications', '2003-04-22', 'TWENTY SECOND APRIL TWO THOUSAND THREE', 'ajinkyadhavale9604@gmail.com', 'Ajinkya', 'Female', '1743099433038_10th marksheet.jpg', '9.00', 'M.Sc. I', 'April', 'M.Sc. I Computer Science', '2025', 'O', 'Dhavale', 'Passed', '2100728', 'SEM I', '1743099433014_10th marksheet.jpg', 0, 'Balasaheb', 'B.Sc. Computer Science', '1743099433030_10th marksheet.jpg', '2025-03-27 23:47:12.000000', 'pay_QBuVl45e434sDZ', 'Paid', 50, '1743099433033_10th marksheet.jpg', 0, '20250001', 'Original', 250, 'Sppu', NULL);

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
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bonafide`
--
ALTER TABLE `bonafide`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `student_document`
--
ALTER TABLE `student_document`
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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `admission`
--
ALTER TABLE `admission`
  MODIFY `admission_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `bonafide`
--
ALTER TABLE `bonafide`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `personal_details`
--
ALTER TABLE `personal_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `student_address`
--
ALTER TABLE `student_address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `student_document`
--
ALTER TABLE `student_document`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tc`
--
ALTER TABLE `tc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
