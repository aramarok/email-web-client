CREATE database if NOT EXISTS `email_web_client`;

USE `email_web_client`;

CREATE TABLE `users` (                     
		  `USER_ID`  bigint(20) NOT NULL,
          `USER_NAME` varchar(50) NOT NULL,                        
          `PASSWORD` varchar(50) NOT NULL,                         
          `FIRST_NAME` varchar(50) default NULL,                   
          `LAST_NAME` varchar(50) default NULL,                    
          `CITY` varchar(32) default NULL,                         
          `AGE` int(11) default NULL,                              
          `SEX` int(11) default NULL,                              
          PRIMARY KEY  (`USER_ID`)                               
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
 
CREATE TABLE `email_accounts` (
          `EMAIL_ACCOUNT_ID` bigint(20) NOT NULL,
          `PROTOCOL` varchar(50) NOT NULL,
          `HOST` varchar(50) NOT NULL,
          `PORT` bigint(20) NOT NULL,
          `USER_NAME` varchar(50) NOT NULL,
          `PASSWORD` varchar(50) NOT NULL,
          `USER_ID` bigint(20) NOT NULL,
          `USE_EMAIL_ACCOUNT` bit(1) NOT NULL,
          PRIMARY KEY  (`EMAIL_ACCOUNT_ID`),
          KEY `USER_ID_2` (`USER_ID`),
          CONSTRAINT `email_accounts_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
        
        
INSERT INTO `users`
	(`USER_ID`, `USER_NAME`,`PASSWORD`,`FIRST_NAME`,`LAST_NAME`,`CITY`,`AGE`,`SEX`)
	VALUES
		(1, 'test','test','Jim','Smith','Timisoara',25,1),
		(2, 'test2','test2','Carl','Jason','Arad',32,1);
		

INSERT INTO `email_accounts`
	(`EMAIL_ACCOUNT_ID`, `USER_NAME`,`PASSWORD`,`POP_SERVER`,`PORT`,`USER_ID`)
	VALUES
		(1, 'dreytc','password for dreytc','smtp.gmail.com', 995, 1),
		(2, 'test','password for test','smtp.gmail.com', 995, 1);


		

	



CREATE TABLE `files` (
          `FILE_NAME` varchar(256) NOT NULL,
          `SIZE` bigint(20) default NULL,
          `USER_ID` bigint(20) NOT NULL,
          `CONTENT` longblob,
          `FILE_PATH` varchar(512) NOT NULL,
          PRIMARY KEY  (`FILE_NAME`),
          KEY `USER_ID_2` (`USER_ID`),                                                      
          CONSTRAINT `files_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)  
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC