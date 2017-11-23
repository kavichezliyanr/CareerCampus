INSERT INTO user (host, user, password,select_priv, insert_priv, update_priv) VALUES ('localhost', 'admin', PASSWORD('admin'), 'Y', 'Y', 'Y');
-- Table COURSE
 create table COLLEGES (
        collegeId integer not null auto_increment,
        AICTEID varchar(255) not null,
        DISTRICT varchar(255) not null,
        INSTITUTIONTYPE varchar(255) not null,
        MINORITY varchar(255) not null,
        NAME varchar(255) not null,
        WOMEN varchar(255) not null,
        statewise_stateWiseId integer,
        primary key (collegeId)
    )

-- Table COURSE
    create table COURSES (
        courseId integer not null auto_increment,
        INTAKE integer not null,
        PROGRAMME varchar(255) not null,
        ENROLLMENT integer not null,
        FULLORPARTTIME varchar(255) not null,
        LEVEL varchar(255) not null,
        UNIVERSITY varchar(255) not null,
        colleges_collegeId integer,
        primary key (courseId)
    )
-- Table STATEWISE
    create table STATEWISE (
        stateWiseId integer not null auto_increment,
        COURSE varchar(255) not null,
        LEVEL varchar(255) not null,
        PROGRAM varchar(255) not null,
        STATE varchar(255) not null,
        YEAR integer not null,
        primary key (stateWiseId)
    )
-- Foreign Key COLLEGES and STATEWISE
    alter table COLLEGES 
        add constraint FK21gsctpqrvg82y5qy6wt3keus 
        foreign key (statewise_stateWiseId) 
        references STATEWISE (stateWiseId)
-- Foreign Key COURSES and COLLEGES
    alter table COURSES 
        add constraint FKhds0kweo4ieuul4jm18kxdiob 
        foreign key (colleges_collegeId) 
        references COLLEGES (collegeId)