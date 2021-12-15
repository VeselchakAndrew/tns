CREATE TABLE departments
(
    department_id   SERIAL PRIMARY KEY,
    department_name VARCHAR(255) UNIQUE NOT NULL
);