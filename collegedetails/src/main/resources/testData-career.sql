
-- Table STATEWISE
    insert into STATEWISE (
        COURSE ,
        LEVEL ,
        PROGRAM ,
        STATE ,
        YEAR )values('cs','y','IT','TN',2018);
    )
	
-- Table COURSE
 insert into COLLEGES (
        AICTEID ,
        DISTRICT ,
        INSTITUTIONTYPE ,
        MINORITY ,
        NAME ,
        WOMEN  )values('123','Chennai','MIT','F','Kalirajaaaan','Y');

-- Table COURSE
    insert into COURSES (
        INTAKE ,
        PROGRAMME ,
        ENROLLMENT ,
        FULLORPARTTIME,
        LEVEL ,
        UNIVERSITY ) values (100,'CSE',40,'F','N','Anna University');

	update COURSES set colleges_collegeId = (select collegeId from COLLEGES where AICTEID ='123') where INTAKE=100;
		
	update COLLEGES SET statewise_stateWiseId=(select stateWiseId from STATEWISE where Course ='cs' )where AICTEID ='123';