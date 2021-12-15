CREATE TABLE companies
(
    company_id    SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);