#Role
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_DOCTOR');
INSERT INTO role (id, name) VALUES (3, 'ROLE_RECEPTION');
#Users
INSERT INTO users(id, username, password, name, surname)VALUES(1,'admin','$2a$10$A.InkJ2OlxIkEsg00/zdneWraWqSpESB5IIv8.QlShCxnwdWOjpRK','Jan','Kowalski');
INSERT INTO users(id, username, password, name, surname)VALUES(2,'patryk','$2a$10$A.InkJ2OlxIkEsg00/zdneWraWqSpESB5IIv8.QlShCxnwdWOjpRK','Patryk','Półtorak');
INSERT INTO users(id, username, password, name, surname)VALUES(3,'kinia','$2a$10$A.InkJ2OlxIkEsg00/zdneWraWqSpESB5IIv8.QlShCxnwdWOjpRK','Kinga','Furga');
INSERT INTO users(id, username, password, name, surname)VALUES(4,'mikolaj','$2a$10$A.InkJ2OlxIkEsg00/zdneWraWqSpESB5IIv8.QlShCxnwdWOjpRK','Mikołaj','Kabała');
#Users Role
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (4, 2);
#Patients
INSERT INTO patient(id, name, surname, city, street, street_number, pesel)VALUES(1, 'Jacek', 'Wojciechowski', 'Kielce', 'Wesoła', 13, 12345123451);
INSERT INTO patient(id, name, surname, city, street, street_number, pesel)VALUES(2, 'Tomasz', 'Nowak', 'Kielce', 'Wesoła', 203, 55544563218);
INSERT INTO patient(id, name, surname, city, street, street_number, pesel)VALUES(3, 'Damian', 'Wójcik', 'Kielce', 'Morska', 15, 87459874134);

#Dates
INSERT INTO dates(id, time)VALUES(1,'8:00');
INSERT INTO dates(id, time)VALUES(2,'8:15');
INSERT INTO dates(id, time)VALUES(3,'8:30');
INSERT INTO dates(id, time)VALUES(4,'8:45');
INSERT INTO dates(id, time)VALUES(5,'9:00');
INSERT INTO dates(id, time)VALUES(6,'9:15');
INSERT INTO dates(id, time)VALUES(7,'9:30');
INSERT INTO dates(id, time)VALUES(8,'9:45');
INSERT INTO dates(id, time)VALUES(9,'10:00');
INSERT INTO dates(id, time)VALUES(10,'10:15');
INSERT INTO dates(id, time)VALUES(11,'10:30');
INSERT INTO dates(id, time)VALUES(12,'10:45');
INSERT INTO dates(id, time)VALUES(13,'11:00');
INSERT INTO dates(id, time)VALUES(14,'11:15');
INSERT INTO dates(id, time)VALUES(15,'11:30');
INSERT INTO dates(id, time)VALUES(16,'11:45');

#Visits
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(1,false,'2021-05-12',1,1,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(2,false,'2021-05-12',2,2,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(3,false,'2021-05-12',3,3,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(4,false,'2021-05-12',1,1,4)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(5,false,'2021-05-12',2,2,4)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(5,false,'2021-05-12',3,3,4)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(6,true,'2021-05-13',1,1,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(7,true,'2021-05-13',2,2,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(8,true,'2021-05-13',3,3,3)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(9,true,'2021-05-13',1,1,4)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(10,true,'2021-05-13',2,2,4)
INSERT INTO visit(id, status, visit_date, dates_id, Patient_id, Users_id)VALUES(11,true,'2021-05-13',3,3,4)