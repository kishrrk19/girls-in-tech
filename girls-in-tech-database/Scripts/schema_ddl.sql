
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

--SELECT * FROM t_formations tf ;
--SELECT * FROM t_schools ts  ;
--SELECT * FROM t_cities tc ;
--SELECT * FROM t_have th  ;



DROP TABLE IF EXISTS t_have CASCADE;
DROP TABLE IF EXISTS t_graduate CASCADE;
DROP TABLE IF EXISTS t_formations CASCADE;
DROP TABLE IF EXISTS t_schools CASCADE;
DROP TABLE IF EXISTS t_cities CASCADE;
DROP TABLE IF EXISTS t_alumnis CASCADE;

CREATE TABLE t_cities(
   id_city INT GENERATED ALWAYS AS IDENTITY,
   city VARCHAR(50) NOT NULL,
   CONSTRAINT t_cities_pkey PRIMARY KEY(id_city),
   CONSTRAINT t_cities_ukey UNIQUE (city)
);

CREATE TABLE t_formations(
   id_formation INT GENERATED ALWAYS AS IDENTITY,
   formation_name VARCHAR(200) NOT NULL,
   CONSTRAINT t_formations_pkey PRIMARY KEY(id_formation),
   CONSTRAINT t_formations_ukey UNIQUE (formation_name)
);

CREATE TABLE t_schools(
   id_school INT GENERATED ALWAYS AS IDENTITY,
   school_name VARCHAR(200) NOT NULL,
   city_id INT,
   CONSTRAINT t_schools_pkey PRIMARY KEY(id_school),
   CONSTRAINT t_schools_ukey UNIQUE (school_name),
   CONSTRAINT t_schools_city_fkey FOREIGN KEY(city_id) REFERENCES t_cities(id_city)  -- 町とのリレーション
);



CREATE TABLE t_alumnis(
   id_alumni INT GENERATED ALWAYS AS IDENTITY,
   alumni_name VARCHAR(50) NOT NULL,
   CONSTRAINT t_alumnis_pkey PRIMARY KEY(id_alumni),
   CONSTRAINT t_alumnis_ukey UNIQUE (alumni_name)
);

CREATE TABLE t_have(
   id_have INT GENERATED ALWAYS AS IDENTITY,
   have_school_id INT,
   have_formation_id INT,
   CONSTRAINT t_have_pkey PRIMARY KEY(id_have),
   CONSTRAINT t_have_ukey UNIQUE(have_school_id, have_formation_id),
   CONSTRAINT t_have_schools_fkey FOREIGN KEY(have_school_id) REFERENCES t_schools(id_school),
   CONSTRAINT t_have_formations_fkey FOREIGN KEY(have_formation_id) REFERENCES t_formations(id_formation)
);

CREATE TABLE t_graduate(
   graduate_formation_school_id INT,
   graduate_alumni_id INT,
   CONSTRAINT t_graduate_pkey PRIMARY KEY(graduate_formation_school_id, graduate_alumni_id),
   CONSTRAINT t_graduate_alumnis_fkey FOREIGN KEY(graduate_alumni_id) REFERENCES t_alumnis(id_alumni),
   CONSTRAINT t_graduate_have_fkey FOREIGN KEY(graduate_formation_school_id) REFERENCES t_have(id_have)
);