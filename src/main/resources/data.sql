DROP TABLE IF EXISTS CodeMap;
CREATE TABLE CodeMap(ID INT PRIMARY KEY, CODE_TYPE VARCHAR(255), CODE VARCHAR(255), CODE_DESC VARCHAR(255));
insert into codemap values(1, 'LOAN_TYPE', '01', 'Secured Car Loan');
insert into codemap values(2, 'LOAN_TYPE', '02', 'Secured Home Loan');
insert into codemap values(3, 'LOAN_PURPOSE', '01', 'Purchase a new car');
insert into codemap values(4, 'LOAN_PURPOSE', '02', 'Purchase a new house');
insert into codemap values(5, 'LOAN_PERIOD', '01', '5 years');
insert into codemap values(6, 'LOAN_PERIOD', '02', '6 years');
insert into codemap values(7, 'LOAN_PERIOD', '03', '10 years');