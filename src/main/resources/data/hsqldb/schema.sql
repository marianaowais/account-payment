DROP TABLE ACCOUNT IF EXISTS;
CREATE TABLE ACCOUNT (
  id VARCHAR(100) NOT NULL, 
   accountNumber BIGINT  NOT NULL UNIQUE ,
   accountHolderName  VARCHAR(100)  NOT NULL  ,
   accountHolderPhoneNumber  VARCHAR(100)  NOT NULL,
   accountDescription  VARCHAR(1000)  NULL ,
  PRIMARY KEY(id)
);

DROP TABLE PAYMENT IF EXISTS;
CREATE TABLE PAYMENT (
  id  VARCHAR(100) NOT NULL,
  sourceAccountNumber BIGINT  NOT NULL,
  destinationAccountNumber BIGINT  NOT NULL,
  amount DECIMAL  NOT NULL ,
  currencyCode  VARCHAR(100) NOT NULL ,
  paymentDescription VARCHAR(1000)  NULL ,
  
  PRIMARY KEY(id)
);




