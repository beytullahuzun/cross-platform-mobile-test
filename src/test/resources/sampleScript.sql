CREATE DATABASE exampleDB;
use exampleDB;
CREATE TABLE exampleDB.accounts(
   First_Name VARCHAR(255),
   Last_Name VARCHAR(255),
   Date_Of_Birth date,
   Place_Of_Birth VARCHAR(255),
   Country VARCHAR(255)
);
insert into accounts values('Mobile', 'Samplea', DATE('1981-12-05'), 'Madrid', 'SP');
insert into accounts values('Mobile', 'Sampleb', DATE('1982-12-05'), 'Madrid', 'SP');
insert into accounts values('Mobile', 'Samplec', DATE('1983-12-05'), 'Madrid', 'SP');
insert into accounts values('Mobile', 'Sampled', DATE('1984-12-05'), 'Madrid', 'SP');
insert into accounts values('Mobile', 'Samplee', DATE('1985-12-05'), 'Madrid', 'SP');
select * from mydatabase.accounts;
