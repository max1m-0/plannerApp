DROP DATABASE workers;
CREATE DATABASE IF NOT EXISTS workers;
USE workers;

CREATE TABLE employees (
	full_name VARCHAR(30),
    id_empl INT AUTO_INCREMENT primary key
);

CREATE TABLE tasks (
   completed BOOLEAN,
   task VARCHAR(30),
   start_date DATE,
   end_date DATE,
   completed_date DATE,
   id_empl INT,
   id_task INT AUTO_INCREMENT primary key
);    
# DROP DATABASE workers;