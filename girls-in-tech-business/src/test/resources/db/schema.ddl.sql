--drop tables----
DROP TABLE IF EXISTS t_cities CASCADE;
DROP TABLE IF EXISTS t_diplomas CASCADE;
DROP TABLE IF EXISTS t_schools CASCADE;
DROP TABLE IF EXISTS t_formations CASCADE;
DROP TABLE IF EXISTS t_roles CASCADE;
DROP TABLE IF EXISTS t_accounts CASCADE;

--creation des tables
CREATE TABLE t_cities(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(50) NOT NULL,
   CONSTRAINT t_cities_pkey PRIMARY KEY(id),
   CONSTRAINT t_cities_ukey UNIQUE (name)
);

CREATE TABLE t_schools(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(200) NOT NULL,
   city_id INT,
   CONSTRAINT t_schools_pkey PRIMARY KEY(id),
   CONSTRAINT t_schools_ukey UNIQUE (name, city_id),
   CONSTRAINT t_schools_city_fkey FOREIGN KEY(city_id) REFERENCES t_cities(id)  -- 町とのリレーション
);

CREATE TABLE t_diplomas(
	id INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(200) NOT NULL,
	CONSTRAINT t_diplomas_pkey PRIMARY KEY(id),
	CONSTRAINT t_diplomas_ukey UNIQUE (name)
	);

CREATE TABLE t_formations(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(200) NOT NULL,
   school_id INT,
   diploma_id INT,
   description VARCHAR(1000),
   url VARCHAR(2083) unique,
   CONSTRAINT t_formations_schools_fkey FOREIGN KEY(school_id) REFERENCES t_schools(id),
   CONSTRAINT t_formations_diplomas_fkey FOREIGN KEY(diploma_id) REFERENCES t_diplomas(id),
   --CONSTRAINT t_formations_pkey PRIMARY KEY(id, school_id),
   CONSTRAINT t_formations_pkey PRIMARY KEY(id),
   CONSTRAINT t_formation_ukey UNIQUE (name, school_id, diploma_id)
);

CREATE TABLE t_roles(
	id INT GENERATED ALWAYS AS IDENTITY,
	authority varchar(60),
	CONSTRAINT t_roles_pkey PRIMARY KEY (id),
	CONSTRAINT t_roles_ukey UNIQUE (authority)
	);

CREATE TABLE t_accounts(
	id INT GENERATED ALWAYS AS IDENTITY,
	username varchar(255),
	password varchar(60),
	role_id INT,
	CONSTRAINT t_accounts_pkey PRIMARY KEY (id),
	CONSTRAINT t_accounts_ukey UNIQUE (username),
	CONSTRAINT t_accounts_roles_fkey FOREIGN KEY(role_id) REFERENCES t_roles(id)
);