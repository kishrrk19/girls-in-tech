--spécific schema pour test
CREATE SCHEMA debo_schema_test;

--spécific ddl pour test
CREATE TABLE debo_schema_test.t_products(
	id serial PRIMARY KEY,
	code varchar NOT NULL,
	designation varchar NOT NULL,
	description TEXT
);

--spécific DML pour test
