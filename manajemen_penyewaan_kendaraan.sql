/*
 Navicat Premium Data Transfer

 Source Server         : global-mysql-8
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:4406
 Source Schema         : manajemen_penyewaan_kendaraan

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 16/02/2025 22:22:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for failed_jobs
-- ----------------------------
DROP TABLE IF EXISTS `failed_jobs`;
CREATE TABLE `failed_jobs`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `failed_jobs_uuid_unique`(`uuid` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of failed_jobs
-- ----------------------------

-- ----------------------------
-- Table structure for migrations
-- ----------------------------
DROP TABLE IF EXISTS `migrations`;
CREATE TABLE `migrations`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of migrations
-- ----------------------------
INSERT INTO `migrations` VALUES (33, '2014_10_12_000000_create_users_table', 1);
INSERT INTO `migrations` VALUES (34, '2014_10_12_100000_create_password_reset_tokens_table', 1);
INSERT INTO `migrations` VALUES (35, '2019_08_19_000000_create_failed_jobs_table', 1);
INSERT INTO `migrations` VALUES (36, '2019_12_14_000001_create_personal_access_tokens_table', 1);
INSERT INTO `migrations` VALUES (37, '2025_02_12_230744_create_vehicles_table', 1);
INSERT INTO `migrations` VALUES (38, '2025_02_14_180931_create_vehicle_rental_customers_table', 1);

-- ----------------------------
-- Table structure for personal_access_tokens
-- ----------------------------
DROP TABLE IF EXISTS `personal_access_tokens`;
CREATE TABLE `personal_access_tokens`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `tokenable_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `personal_access_tokens_token_unique`(`token` ASC) USING BTREE,
  INDEX `personal_access_tokens_tokenable_type_tokenable_id_index`(`tokenable_type` ASC, `tokenable_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal_access_tokens
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `nik` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` enum('admin','pelanggan') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'pelanggan',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `users_nik_unique`(`nik` ASC) USING BTREE,
  UNIQUE INDEX `users_username_unique`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '1234567890', 'admin', '$2a$10$A5PWlfhYqqPXzYcixZP8juMKIihulNg/z5NSp.1F/fA.P5rOvbzN2', 'admin', '2025-02-16 14:27:42', '2025-02-16 14:27:42');
INSERT INTO `users` VALUES (2, '3273022806030015', 'ripscript', '$2a$10$4Ysk7Rc7x.3FtOIF0wIhm.wEcSgrjXZ9uygeCd261bkqM8mpObqEC', 'pelanggan', '2025-02-16 14:29:45', '2025-02-16 14:29:45');

-- ----------------------------
-- Table structure for vehicle_rental_customers
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_rental_customers`;
CREATE TABLE `vehicle_rental_customers`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint UNSIGNED NOT NULL,
  `vehicle_id` bigint UNSIGNED NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_rental_customers
-- ----------------------------

-- ----------------------------
-- Table structure for vehicles
-- ----------------------------
DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE `vehicles`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` enum('motor','mobil') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `license_plate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` enum('available','rented') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'available',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `vehicles_license_plate_unique`(`license_plate` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicles
-- ----------------------------
INSERT INTO `vehicles` VALUES (1, 'motor', 'Honda', 'MTR0001', 'available', '2025-02-16 14:27:48', '2025-02-16 15:19:20');
INSERT INTO `vehicles` VALUES (2, 'motor', 'Honda', 'MTR0002', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (3, 'motor', 'Honda', 'MTR0003', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (4, 'motor', 'Honda', 'MTR0004', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (5, 'motor', 'Honda', 'MTR0005', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (6, 'motor', 'Honda', 'MTR0006', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (7, 'motor', 'Honda', 'MTR0007', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (8, 'motor', 'Honda', 'MTR0008', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (9, 'motor', 'Honda', 'MTR0009', 'available', '2025-02-16 14:27:48', '2025-02-16 15:19:58');
INSERT INTO `vehicles` VALUES (10, 'motor', 'Honda', 'MTR0010', 'available', '2025-02-16 14:27:48', '2025-02-16 15:19:54');
INSERT INTO `vehicles` VALUES (11, 'mobil', 'Toyota', 'MBL0001', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (12, 'mobil', 'Toyota', 'MBL0002', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (13, 'mobil', 'Toyota', 'MBL0003', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (14, 'mobil', 'Toyota', 'MBL0004', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (15, 'mobil', 'Toyota', 'MBL0005', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (16, 'mobil', 'Toyota', 'MBL0006', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (17, 'mobil', 'Toyota', 'MBL0007', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (18, 'mobil', 'Toyota', 'MBL0008', 'available', '2025-02-16 14:27:48', '2025-02-16 15:19:39');
INSERT INTO `vehicles` VALUES (19, 'mobil', 'Toyota', 'MBL0009', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');
INSERT INTO `vehicles` VALUES (20, 'mobil', 'Toyota', 'MBL0010', 'available', '2025-02-16 14:27:48', '2025-02-16 14:27:48');

SET FOREIGN_KEY_CHECKS = 1;
