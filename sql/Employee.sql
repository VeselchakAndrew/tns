CREATE TABLE employees
(
    employee_id         SERIAL PRIMARY KEY,
    employee_firstname  VARCHAR(255) NOT NULL,
    employee_lastname   VARCHAR(255) NOT NULL,
    employee_role       VARCHAR(255) NOT NULL,
    employee_department INT          NOT NULL,
    employee_company    INT          NOT NULL
);