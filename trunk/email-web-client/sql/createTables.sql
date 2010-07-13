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
	(`EMAIL_ACCOUNT_ID`, `PROTOCOL`, `HOST`,`PORT`, `USER_NAME`,`PASSWORD`,`USER_ID`, `USE_EMAIL_ACCOUNT`)
	VALUES
		(1, 'POP','GMAIL.COM',995, 'test1', 'test1', 1, 1),
		(2, 'POP3','GMAIL.COM',921, 'test2', 'test2', 1, 0);

		