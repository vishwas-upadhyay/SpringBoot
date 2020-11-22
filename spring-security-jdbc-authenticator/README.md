### DB setup
1. run oracle instance in local machine or EC2 instance 
2. provide below properties in applicaiton.properties to configure DataSource
        spring.datasource.url=jdbc:oracle:thin:@localhost:1527:xe
        spring.datasource.username=CRMDEV01
        spring.datasource.password=adidas123
        spring.datasource.driver.class.name=oracle.jdbc.driver.OracleDriver 
        
        
### Create schema for spring security UserDetailService
Below are oracle DDL statements it might vary for other DBs.

create table my_users(id number, username varchar(50),password varchar(50),enabled varchar(20),authority_id number);  
create table my_authorities(id number,authority varchar(30));

insert into my_users values (1,'jill','123456','true',2);

insert into my_users values (2,'jack','123456','true',1);

--Authority should be stored with prefix ROLE or you can handle while UserDetail object population.

insert into my_authorities values(1,'ROLE_USER');

insert into my_authorities values(2,'ROLE_ADMIN');


Once you are done with above setup then you can run application and check below url with jack and jill users:
http://localhost:8080/spring-security/

http://localhost:8080/spring-security/user

http://localhost:8080/spring-security/admin

