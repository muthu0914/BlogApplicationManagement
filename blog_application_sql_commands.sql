-- Create Database
CREATE DATABASE blog
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_IN'
    LC_CTYPE = 'en_IN'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
-- Create Blog Post Management Schema
CREATE SCHEMA blog_post_management
    AUTHORIZATION postgres;

-- Create User Management Schema
CREATE SCHEMA user_management
    AUTHORIZATION postgres;

-- Table: user_management.user_details

CREATE TABLE IF NOT EXISTS user_management.user_details
(
    user_id VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(150)  NOT NULL,
    email VARCHAR(150) NOT NULL,
    date_of_birth DATE NOT NULL,
	user_type VARCHAR(50) NOT NULL
);

-- Table: blog_post_management.blog_post

CREATE TABLE IF NOT EXISTS blog_post_management.blog_post
(
    blog_id VARCHAR(50) NOT NULL PRIMARY KEY,
    header_block VARCHAR(150) NOT NULL,
    footer_block VARCHAR(150)  NOT NULL,
    body_block VARCHAR(500) NOT NULL,
    contact_block VARCHAR(150) NOT NULL,
    status VARCHAR(15) NOT NULL,
    user_id VARCHAR(50) NOT NULL,
);

--Create SUPERUSER for admin to Update Blog Post Status
INSERT INTO user_management.user_details (user_id, name, email,date_of_birth,user_type) VALUES (UUID DEFAULT uuid_generate_v4(), 'SUPERUSER', 'super_user@supportblog.com','1989-05-08','SUPER_USER');

-- Sample data for user_management.user_details

INSERT INTO user_management.user_details (user_id, name, email,date_of_birth,user_type) VALUES (UUID DEFAULT uuid_generate_v4(), 'MAX', 'max@gmail.com','1989-05-08','USER');

