--TEACHER
INSERT INTO TEACHER(ID, FIRSTNAME, LASTNAME) VALUES('1559127c-84b4-11e9-bc42-526af7764f64', 'Helen', 'Keller');

--STUDENTS
INSERT INTO STUDENT(ID, FIRSTNAME, LASTNAME, TEACHERID) VALUES('cf43c22a-84b5-11e9-bc42-526af7764f64', 'Stephen', 'Hawking', '1559127c-84b4-11e9-bc42-526af7764f64');
INSERT INTO STUDENT(ID, FIRSTNAME, LASTNAME, TEACHERID) VALUES('d68da5e6-84b5-11e9-bc42-526af7764f64', 'JK', 'Rowling', '1559127c-84b4-11e9-bc42-526af7764f64');

COMMIT;