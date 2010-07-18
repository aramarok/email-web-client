CREATE database if NOT EXISTS `email_web_client`;
USE `email_web_client`;

CREATE TABLE users (                     
	USER_ID  bigint(20) NOT NULL auto_increment,
	USER_NAME varchar(50) NOT NULL,                        
	PASSWORD varchar(50) NOT NULL,                         
	FIRST_NAME varchar(50) default NULL,                   
	LAST_NAME varchar(50) default NULL,                    
	CITY varchar(32) default NULL,                         
	AGE int(11) default NULL,                              
	SEX int(11) default NULL,                              
	PRIMARY KEY  (USER_ID)                               
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
 
CREATE TABLE email_accounts (
	EMAIL_ACCOUNT_ID bigint(20) NOT NULL auto_increment,
	PROTOCOL varchar(50) NOT NULL,
	HOST varchar(50) NOT NULL,
	PORT bigint(20) NOT NULL,
	USER_NAME varchar(50) NOT NULL,
	PASSWORD varchar(50) NOT NULL,
	EMAIL_ADDRESS varchar(50) NOT NULL,
	USER_ID bigint(20) NOT NULL,
	USE_EMAIL_ACCOUNT bit(1) NOT NULL,
	PRIMARY KEY  (EMAIL_ACCOUNT_ID),
	KEY USER_ID_2 (USER_ID),
	CONSTRAINT email_accounts_ibfk_1 FOREIGN KEY (USER_ID) REFERENCES users (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
        
CREATE TABLE emails (
	EMAIL_ID bigint(20) NOT NULL auto_increment,
	EMAIL_ACCOUNT_ID bigint(20) NOT NULL,
	FROM_ varchar(100) NULL,
	REPLY_TO varchar(100) NULL,
	TO_ varchar(100)  NULL,
	CC varchar(100)  NULL,
	BCC varchar(100)  NULL,
	DATE datetime NOT NULL,
	SUBJECT varchar(100)  NULL,
	CONTENT varchar(99999)  NULL,
	TYPE int NOT NULL,
	PRIMARY KEY  (EMAIL_ID),
	KEY EMAIL_ACCOUNT_ID_2 (EMAIL_ACCOUNT_ID),
	CONSTRAINT emails_ibfk_1 FOREIGN KEY (EMAIL_ACCOUNT_ID) REFERENCES EMAIL_ACCOUNTS (EMAIL_ACCOUNT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
       
INSERT INTO users
	(USER_ID, USER_NAME,PASSWORD,FIRST_NAME,LAST_NAME,CITY,AGE,SEX)
	VALUES
		(1, 'test','test','Jim','Smith','Timisoara',25,1),
		(2, 'test2','test2','Carl','Jason','Arad',32,1);
		
INSERT INTO email_accounts
	(EMAIL_ACCOUNT_ID, PROTOCOL, HOST,PORT, USER_NAME, PASSWORD, EMAIL_ADDRESS, USER_ID, USE_EMAIL_ACCOUNT)
	VALUES
		(1, 'POP',	'GMAIL.COM',	995, 	'test1', 'test1', 'test1@gmail.com', 1, 1),
		(2, 'POP3',	'yahoo.COM',	921, 	'test2', 'test3', 'test2@yahoo.com', 1, 0),
		(3, 'POP',	'test.COM',		123, 	'test3', 'test3', 'test3@test.com', 1, 1),
		(4, 'POP3',	'home.COM',		641, 	'test4', 'test4', 'test4@gome.com', 1, 1),
		(5, 'POP',	'GMAIL.COM',	125, 	'test5', 'test5', 'test5@gmail.com', 1, 1),
		(6, 'imap',	'GMAIL.COM',	905, 	'test6', 'test6', 'test6@gmail.com', 1, 0),
		(7, 'POP',	'GMAIL.COM',	3354, 	'test7', 'test7', 'test7@gmail.com', 1, 1),
		(8, 'POP3',	'GMAIL.COM',	92112, 	'test8', 'test8', 'test8@gmail.com', 1, 1);
		
INSERT INTO emails
	(EMAIL_ID, EMAIL_ACCOUNT_ID, FROM_,DATE, SUBJECT, TYPE)
	VALUES
		(1, 1,'ionescu popoescu', '2009/10/10 12:31:21', 'subject1'),
		(2, 2,'ionescu popoescu', '2010/10/10 12:31:21', 'subject2'),
		(3, 1,'ionescu popoescu', '2009/11/01 12:31:21', 'subject3'),
		(4, 2,'ionescu popoescu', '2009/10/10 12:31:21', 'subject4'),
		(5, 1,'ionescu popoescu', '2009/10/10 12:31:21', 'subject5'),
		(6, 3,'ionescu popoescu', '2009/10/10 12:31:21', 'subject6');
