--You can't directly store files like PDFs, DOCs, or images. Instead, you typically store the path to where the file is stored on the server or in a cloud storage service. 
--For the `id_proof`, `profile_picture`, and `resume` fields, `VARCHAR` type to store the file path is used.

--In this command, `phone` is a `VARCHAR(20)` field, which should be sufficient to store most phone numbers. `address` is a `TEXT` field, which can store a large amount of text. 
--`id_proof`, `profile_picture`, and `resume` are `VARCHAR(255)` fields, which can store the path to the respective files.

--Postgres

-- Employee table
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    hire_date DATE NOT NULL,
    role VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT NOT NULL,
    id_proof VARCHAR(255) NOT NULL,
    profile_picture VARCHAR(255),
    resume VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- Customer table
/* CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT NOT NULL,
    profile_picture VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user (id)
); */

-- User table
CREATE TABLE user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    --employee_id INT NOT NULL,
    --FOREIGN KEY (employee_id) REFERENCES employee (id)
);

-- Indexes
-- User
CREATE INDEX idx_user_username ON user (username);

-- role table
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- user_role table
CREATE TABLE user_role (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);














