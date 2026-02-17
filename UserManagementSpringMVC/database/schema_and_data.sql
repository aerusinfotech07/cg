-- ============================================
-- UserManagement - Table Structure & Sample Data
-- Database: usermanagement
-- ============================================

-- Create database
CREATE DATABASE IF NOT EXISTS usermanagement;
USE usermanagement;

-- ============================================
-- TABLE STRUCTURES
-- ============================================

-- Geo table (geographic coordinates)
CREATE TABLE IF NOT EXISTS geo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lat VARCHAR(50),
    lng VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Address table (references geo)
CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    suite VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    zipcode VARCHAR(20) NOT NULL,
    geo_id BIGINT,
    FOREIGN KEY (geo_id) REFERENCES geo(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Company table
CREATE TABLE IF NOT EXISTS company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    catch_phrase VARCHAR(255),
    bs VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Users table (references address and company)
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50),
    website VARCHAR(255),
    address_id BIGINT,
    company_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Employees table (references address - same structure as user for address)
CREATE TABLE IF NOT EXISTS employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    employee_code VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50),
    designation VARCHAR(100),
    department VARCHAR(100),
    join_date DATE,
    salary DECIMAL(12,2),
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- SAMPLE RECORDS
-- ============================================

-- Clear existing data (optional - comment out if preserving data)
-- SET FOREIGN_KEY_CHECKS = 0;
-- TRUNCATE TABLE users;
-- TRUNCATE TABLE address;
-- TRUNCATE TABLE company;
-- TRUNCATE TABLE geo;
-- SET FOREIGN_KEY_CHECKS = 1;

-- Insert Geo records
INSERT INTO geo (lat, lng) VALUES
('-37.3159', '81.1496'),
('-43.9509', '-34.4618'),
('-68.6102', '-47.0653'),
('29.4572', '-164.2990'),
('-31.8129', '62.5342'),
('-71.4197', '71.7478'),
('24.8918', '21.8984'),
('-14.3990', '-120.7677'),
('24.6463', '-168.8889'),
('-38.2386', '57.2232');

-- Insert Address records (linked to geo)
INSERT INTO address (street, suite, city, zipcode, geo_id) VALUES
('Kulas Light', 'Apt. 556', 'Gwenborough', '92998-3874', 1),
('Victor Plains', 'Suite 879', 'Wisokyburgh', '90566-7771', 2),
('Douglas Extension', 'Suite 847', 'McKenziehaven', '59590-4157', 3),
('Hoeger Mall', 'Apt. 692', 'South Elvis', '53919-4257', 4),
('Skiles Walks', 'Suite 351', 'Roscoeview', '33263', 5),
('Norberto Crossing', 'Apt. 950', 'South Christy', '23505-1337', 6),
('Rex Trail', 'Suite 280', 'Howemouth', '58804-1099', 7),
('Ellsworth Summit', 'Suite 729', 'Aliyaview', '45169', 8),
('Dayna Park', 'Suite 449', 'Bartholomebury', '76495-3109', 9),
('Kattie Turnpike', 'Suite 198', 'Lebsackbury', '31428-2261', 10);

-- Insert Company records
INSERT INTO company (name, catch_phrase, bs) VALUES
('Romaguera-Crona', 'Multi-layered client-server neural-net', 'harness real-time e-markets'),
('Deckow-Crist', 'Proactive didactic contingency', 'synergize scalable supply-chains'),
('Romaguera-Jacobson', 'Face to face bifurcated interface', 'e-enable strategic applications'),
('Robel-Corkery', 'Multi-tiered zero tolerance productivity', 'transition cutting-edge web services'),
('Keebler LLC', 'User-centric fault-tolerant solution', 'revolutionize end-to-end systems'),
('Considine-Lockman', 'Synchronised bottom-line interface', 'e-enable innovative applications'),
('Johns Group', 'Configurable multimedia task-force', 'generate enterprise e-tailers'),
('Abernathy Group', 'Implemented secondary concept', 'e-enable extensible e-tailers'),
('Yost and Sons', 'Switchable contextually-based project', 'aggregate real-time technologies'),
('Hoeger LLC', 'Centralized empowering task-force', 'target end-to-end models');

-- Insert User records (linked to address and company)
INSERT INTO users (name, username, email, phone, website, address_id, company_id) VALUES
('Leanne Graham', 'Bret', 'Sincere@april.biz', '1-770-736-8031 x56442', 'hildegard.org', 1, 1),
('Ervin Howell', 'Antonette', 'Shanna@melissa.tv', '010-692-6593 x09125', 'anastasia.net', 2, 2),
('Clementine Bauch', 'Samantha', 'Nathan@yesenia.net', '1-463-123-4447', 'ramiro.info', 3, 3),
('Patricia Lebsack', 'Karianne', 'Julianne.OConner@kory.org', '493-170-9623 x156', 'kale.biz', 4, 4),
('Chelsey Dietrich', 'Kamren', 'Lucio_Hettinger@annie.ca', '(254)954-1289', 'demarco.info', 5, 5),
('Mrs. Dennis Schulist', 'Leopoldo_Corkery', 'Karley_Dach@jasper.info', '1-477-935-8478 x6430', 'ola.org', 6, 6),
('Kurtis Weissnat', 'Elwyn.Skiles', 'Telly.Hoeger@billy.biz', '210.067.6132', 'elvis.io', 7, 7),
('Nicholas Runolfsdottir V', 'Maxime_Nienow', 'Sherwood@rosamond.me', '586.493.6943 x140', 'jacynthe.com', 8, 8),
('Glenna Reichert', 'Delphine', 'Chaim_McDermott@dana.io', '(775)976-6794 x41206', 'conrad.com', 9, 9),
('Clementina DuBuque', 'Moriah.Stanton', 'Rey.Padberg@karina.biz', '024-648-3804', 'ambrose.net', 10, 10);
