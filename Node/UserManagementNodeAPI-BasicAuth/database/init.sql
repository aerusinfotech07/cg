-- User Management Database Schema (with Auth)
-- Run this script after creating the database

USE usermanagement;

-- Auth users for Basic Auth / JWT (username + hashed password)
CREATE TABLE IF NOT EXISTS auth_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_auth_username ON auth_users(username);

-- Create geo table
CREATE TABLE IF NOT EXISTS geo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lat VARCHAR(50) NOT NULL,
    lng VARCHAR(50) NOT NULL
);

-- Create address table
CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    suite VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    zipcode VARCHAR(50) NOT NULL,
    geo_id BIGINT,
    FOREIGN KEY (geo_id) REFERENCES geo(id) ON DELETE CASCADE
);

-- Create company table
CREATE TABLE IF NOT EXISTS company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    catch_phrase VARCHAR(500),
    bs VARCHAR(500)
);

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50),
    website VARCHAR(255),
    address_id BIGINT,
    company_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE SET NULL
);

CREATE INDEX idx_username ON users(username);
CREATE INDEX idx_email ON users(email);

-- Auth user: create via script: node scripts/seed-auth-user.js
-- Default: username=admin, password=admin123
