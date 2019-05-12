DROP TABLE bank.account;
DROP TABLE bank.customer;
DROP SCHEMA bank;

CREATE SCHEMA bank;
CREATE TABLE bank.customer (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR,
    last_name VARCHAR
);

CREATE TABLE bank.account (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    number INT,
    amount NUMERIC
);

INSERT INTO bank.customer(first_name, last_name) VALUES ('Jonny', 'Cage');
INSERT INTO bank.customer(first_name, last_name) VALUES ('Sonya', 'Blade');
INSERT INTO bank.customer(first_name, last_name) VALUES ('Cassie', 'Cage');

INSERT INTO bank.account(number, amount) VALUES (123456, 243.45);
INSERT INTO bank.account(number, amount) VALUES (123457, 135.10);
INSERT INTO bank.account(number, amount) VALUES (123458, 9887.43);
