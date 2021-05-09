create database Hospital
use hospital
create table clinicInfo(clinicid int primary key,
clinicname	varchar(50),
city	varchar(50),
state	varchar(50))

select * from clinicInfo

create table doctorinfo(IDNo int primary key,
lastname	varchar(50),
firstname	varchar(50),
city	varchar(50),
state	varchar(50),
clinicid int ,
foreign key(clinicid) references clinicInfo(clinicid))
select * from doctorinfo

create table patientinfo(PatID	int primary key,
practiceid int,
lastname	varchar(50),
firstname	varchar(50),
city	varchar(50),
state	varchar(50),
gender	varchar(30),
patientagegroup	varchar(30),
birthdate date,
age int)


select * from patientinfo


create table appointmentinfo(patid	int,
apptid	int primary key,
apptdate	date,
operatory	int,
provider	int,
appttime	time,
apptlength	int,
amount	int,
clinicid int,
foreign key(patid) references patientinfo(PatID),
foreign key(clinicid) references clinicInfo(clinicid))

select * from appointmentinfo




create table transactioninfo(transid int primary key,
patid	int,
proceduretype	varchar(30),
proceduredate	date,
prov	int,
amount	int,
clinicid int,
foreign key(patid) references patientinfo(patid),
foreign key(clinicid) references clinicInfo(clinicid))

select * from transactioninfo



 
