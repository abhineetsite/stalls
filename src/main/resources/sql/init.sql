CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    hire_date DATE
);

ALTER TABLE employee
ADD COLUMN id_proof VARCHAR(255);



