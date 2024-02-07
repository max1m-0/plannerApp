USE	workers;
SET GLOBAL local_infile=1;
LOAD DATA LOCAL INFILE 'D:/Programming/Files/employees.txt' INTO TABLE employees
       LINES TERMINATED BY '\r\n' IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'D:/Programming/Files/tasks.txt' INTO TABLE tasks
       LINES TERMINATED BY '\r\n' IGNORE 1 LINES;