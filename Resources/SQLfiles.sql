show databases;
create database universitymanagement;
use universitymanagement;
create table login( username varchar(30), password varchar(30));
insert into login values('admin','admin');
insert into login values('gehu','gehu123');
select * from login;
create table teacher(name varchar(40),fname varchar(40),empID varchar(40),dob varchar(40),address varchar(40),phone varchar(40),email varchar(40), class_X varchar(40)
,class_XII varchar(40),education varchar (40), department varchar(40)); 
INSERT INTO teacher (name, fname, empID, dob, address, phone, email, class_X, class_XII, education, department)
VALUES
('Dr. Ramesh Kumar', 'Shiv Kumar', 'T12345', '1980-03-15', 'B-12, Sector 7, Noida, Uttar Pradesh', '9876543210', 'ramesh.kumar@email.com', 'Physics', 'Physics', 'Ph.D. in Physics', 'Physics'),
('Mrs. Sangeeta Rao', 'Vijay Rao', 'T12346', '1985-07-10', 'C-19, Vasant Vihar, Delhi', '9812345678', 'sangeeta.rao@email.com', 'Mathematics', 'Mathematics', 'M.Sc. in Mathematics', 'Mathematics'),
('Mr. Anil Gupta', 'Rajesh Gupta', 'T12347', '1978-11-25', 'D-8, Raj Nagar, Ghaziabad, Uttar Pradesh', '9898765432', 'anil.gupta@email.com', 'English', 'English', 'M.A. in English', 'English'),
('Mrs. Neelam Sharma', 'Amit Sharma', 'T12348', '1990-02-10', 'E-5, Indirapuram, Kanpur, Uttar Pradesh', '9999887766', 'neelam.sharma@email.com', 'Biology', 'Biology', 'M.Sc. in Biology', 'Biology'),
('Mr. Vikram Joshi', 'Harish Joshi', 'T12349', '1983-06-18', 'F-23, Sector 18, Chandigarh', '9976543210', 'vikram.joshi@email.com', 'Chemistry', 'Chemistry', 'M.Sc. in Chemistry', 'Chemistry'),
('Dr. Kavita Mehra', 'Raghav Mehra', 'T12350', '1982-10-05', 'G-12, Sector 12, Faridabad, Haryana', '9754321098', 'kavita.mehra@email.com', 'Computer Science', 'Computer Science', 'Ph.D. in Computer Science', 'Computer Science'),
('Mr. Sanjay Patel', 'Vijay Patel', 'T12351', '1975-01-20', 'H-18, Alince, Vanaras, Uttar Pradesh', '9654321098', 'sanjay.patel@email.com', 'History', 'History', 'M.A. in History', 'History'),
('Mrs. Priya Singh', 'Harvinder Singh', 'T12352', '1992-09-15', 'I-10, Kormangala, Bangalore, Karnataka', '9543219876', 'priya.singh@email.com', 'Geography', 'Geography', 'M.A. in Geography', 'Geography');
select * from teacher;
create table student(name varchar(40),fname varchar(40),rollno varchar(40),dob varchar(40),address varchar(40),phone varchar(40),email varchar(40), class_X varchar(40)
,class_XII varchar(40),course varchar (40), branch varchar(40));
select * from student;
INSERT INTO student (name, fname, rollno, dob, address, phone, email, class_X, class_XII, course, branch)
VALUES
('Rahul Sharma', 'Amit Sharma', '12345', '2005-04-20', 'B-15, Sector 12, Noida, Uttar Pradesh', '9876543210', 'rahul.sharma@email.com', '89%', '85%', 'B.Tech', 'Computer Science'),
('Priya Verma', 'Sushil Verma', '12346', '2004-08-15', 'E-22, Vasant Vihar, Delhi', '9812345678', 'priya.verma@email.com', '92%', '90%', 'B.Tech', 'Electrical'),
('Amit Gupta', 'Ramesh Gupta', '12347', '2005-01-25', 'C-13, Raj Nagar,Kanpur, Uttar Pradesh', '9898765432', 'amit.gupta@email.com', '75%', '78%', 'B.Com', 'Commerce'),
('Meera Singh', 'Anil Singh', '12348', '2006-03-10', 'D-3, Mall Road, Lucknow, Uttar Pradesh', '9876123456', 'meera.singh@email.com', '88%', '82%', 'B.Tech', 'Mechanical'),
('Sahil Kumar', 'Vikram Kumar', '12349', '2005-05-30', 'F-17, Sector 8, Faridabad, Haryana', '9976543210', 'sahil.kumar@email.com', '85%', '80%', 'BCA', 'Information Technology'),
('Neha Kapoor', 'Rajesh Kapoor', '12350', '2005-11-12', 'G-10, Indirapuram, Paryagraj, UP', '9765432109', 'neha.kapoor@email.com', '95%', '92%', 'MBBS', 'Medicine'),
('Karan Joshi', 'Ravi Joshi', '12351', '2005-07-22', 'H-20, Sector 15, Chandigarh', '9654321098', 'karan.joshi@email.com', '80%', '85%', 'B.Tech', 'Civil'),
('Anjali Rao', 'Harish Rao', '12352', '2005-12-01', 'I-8, Kormangala, Bangalore, Karnataka', '9543219876', 'anjali.rao@email.com', '87%', '89%', 'B.Sc', 'Physics');

create table StudentLeave(rollno varchar(20),date varchar(20),Time varchar(20));
select * from StudentLeave;
create table TeacherLeave(empID varchar(20),date varchar(20),Time varchar(20));
select * from TeacherLeave;
create table subject(rollno varchar(40),semester varchar(40),subj1 varchar(40),subj2 varchar(40),subj3 varchar(40),subj4 varchar(40),subj5 varchar(40));
select * from subject;
create table marks(rollno varchar(40),semester varchar(40),mrk1 varchar(40),mrk2 varchar(40),mrk3 varchar(40),mrk4 varchar(40),mrk5 varchar(40));
select * from marks;
create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));
select * from fee;


insert into fee values("BTech", "49000", "43000","43000","43000","43000","43000","43000","43000");
insert into fee values("Bsc", "44000", "35000","35000","35000","35000","35000","","");
insert into fee values("BCA", "39000", "34000","34000","34000","34000","34000","","");
insert into fee values("MTech", "70000", "60000","60000","60000","","","","");
insert into fee values("MSc", "44000", "45000","45000","45000","","","","");
insert into fee values("MCA", "66000", "42000","42000","49000","","","","");
insert into fee values("Bcom", "32000", "20000","20000","20000","20000","20000","","");
insert into fee values("Mcom", "46000", "30000","30000","30000","","","","");
create table feecollege(rollno varchar(40),course varchar(40),branch varchar(40),semester varchar(40),total varchar(40));
show tables;
select * from feecollege; 

truncate table teacher;


