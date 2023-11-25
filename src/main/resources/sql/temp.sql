--You can't directly store files like PDFs, DOCs, or images. Instead, you typically store the path to where the file is stored on the server or in a cloud storage service. 
--For the `id_proof`, `profile_picture`, and `resume` fields, you can use a `VARCHAR` type to store the file path.

--In this command, `phone` is a `VARCHAR(20)` field, which should be sufficient to store most phone numbers. `address` is a `TEXT` field, which can store a large amount of text. 
--`id_proof`, `profile_picture`, and `resume` are `VARCHAR(255)` fields, which can store the path to the respective files.

--Please note that you will need to implement the file upload functionality in your application code, and save the path to the uploaded file in the database.

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
    resume VARCHAR(255)
);
