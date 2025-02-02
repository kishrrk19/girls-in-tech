
/*DROP TABLE IF EXISTS t_formation_school;
DROP TABLE IF EXISTS t_list_alumni;

CREATE TABLE t_formation_school(
   id_formation_school INT GENERATED ALWAYS AS IDENTITY,
   school_name VARCHAR(200) NOT NULL,
   formation_name VARCHAR(200) NOT NULL,
   city VARCHAR(50) NOT NULL,
   list_alumni VARCHAR(100),
   CONSTRAINT t_formation_school_pkey PRIMARY KEY(id_formation_school),
   CONSTRAINT t_formation_school_ukey UNIQUE (school_name, formation_name)
   --CONSTRAINT t_formation_school_fkey FOREIGN KEY (list_alumni) REFERENCES t_list_alumni(list_alumni)
);
*/


/*
CREATE TABLE t_spots(
	id_spot INT GENERATED ALWAYS AS IDENTITY, --SERIAL
	spot_name VARCHAR(200) NOT NULL ,
	spot_lat DECIMAL(9,6) NOT NULL,
	spot_lng DECIMAL(9,6) NOT NULL,
	spot_desc VARCHAR(2000),
	spot_img VARCHAR(41),
	spot_category_id INT,
	category_name VARCHAR(100),
	CONSTRAINT t_spots_pkey PRIMARY KEY(id_spot),
	CONSTRAINT t_spots_ukey UNIQUE(spot_name, spot_lat, spot_lng),
	CONSTRAINT t_spots_categories_fkey FOREIGN KEY(spot_category_id) REFERENCES t_categories(id_category)
);
*/


DROP TABLE IF EXISTS t_cities CASCADE;
DROP TABLE IF EXISTS t_graduate CASCADE;
DROP TABLE IF EXISTS t_diplomas;
DROP TABLE IF EXISTS t_schools CASCADE;
DROP TABLE IF EXISTS t_formations CASCADE;
DROP TABLE IF EXISTS t_alumnis CASCADE;
DROP TABLE IF EXISTS t_roles CASCADE;
DROP TABLE IF EXISTS t_associate;
DROP TABLE IF EXISTS t_accounts;



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
   CONSTRAINT t_formations_schools_fkey FOREIGN KEY(school_id) REFERENCES t_schools(id),
   CONSTRAINT t_formations_diplomas_fkey FOREIGN KEY(diploma_id) REFERENCES t_diplomas(id),
   CONSTRAINT t_formations_pkey PRIMARY KEY(id, school_id),
   CONSTRAINT t_formation_ukey UNIQUE (name, school_id, diploma_id)
);





CREATE TABLE t_alumnis(
   id_alumni INT GENERATED ALWAYS AS IDENTITY,
   alumni_name VARCHAR(50) NOT NULL,
   CONSTRAINT t_alumnis_pkey PRIMARY KEY(id_alumni),
   CONSTRAINT t_alumnis_ukey UNIQUE (alumni_name)
);

--CREATE TABLE t_have(
--   id_have INT GENERATED ALWAYS AS IDENTITY,
--   have_school_id INT,
--   have_formation_id INT,
--   CONSTRAINT t_have_pkey PRIMARY KEY(id_have),
--   CONSTRAINT t_have_ukey UNIQUE(have_school_id, have_formation_id),
--   CONSTRAINT t_have_schools_fkey FOREIGN KEY(have_school_id) REFERENCES t_schools(id_school),
--   CONSTRAINT t_have_formations_fkey FOREIGN KEY(have_formation_id) REFERENCES t_formations(id_formation)
--);

CREATE TABLE t_graduate(
   graduate_formation_school_id INT,
   graduate_alumni_id INT,
   CONSTRAINT t_graduate_pkey PRIMARY KEY(graduate_formation_school_id, graduate_alumni_id),
   CONSTRAINT t_graduate_alumnis_fkey FOREIGN KEY(graduate_alumni_id) REFERENCES t_alumnis(id_alumni),
   CONSTRAINT t_graduate_have_fkey FOREIGN KEY(graduate_formation_school_id) REFERENCES t_have(id_have)
);

CREATE TABLE t_accounts(
	id INT GENERATED ALWAYS AS IDENTITY,
	username varchar(255),
	password varchar(60),
	CONSTRAINT t_accounts_pkey PRIMARY KEY (id),
	CONSTRAINT t_accounts_ukey UNIQUE (username)
);

CREATE TABLE t_roles(
	id INT GENERATED ALWAYS AS IDENTITY,
	authority varchar(60),
	default_role boolean,
	CONSTRAINT t_roles_pkey PRIMARY KEY (id),
	CONSTRAINT t_roles_ukey UNIQUE (authority)
	);

CREATE TABLE t_associate(
	id_associate INT GENERATED ALWAYS AS IDENTITY,
	associate_account_id INT,
	associate_role_id INT,
	CONSTRAINT t_associate_pkey PRIMARY KEY (id_associate),
	CONSTRAINT t_associate_ukey UNIQUE (associate_account_id, associate_role_id),
	CONSTRAINT t_associate_accounts_fkey FOREIGN KEY (associate_account_id) REFERENCES t_accounts(id),
	CONSTRAINT t_associate_roles_fkey FOREIGN KEY (associate_role_id) REFERENCES t_roles(id)
);