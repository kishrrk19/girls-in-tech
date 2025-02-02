DELETE FROM t_formations;
DELETE FROM t_schools;
DELETE FROM t_diplomas;
DELETE FROM t_cities;

INSERT INTO t_cities (name) VALUES ('Montreuil'), ('Brest'), ('Nancy');
INSERT INTO t_schools (name, city_id) VALUES ('Simplon', 1), ('IMT Atlantique', 2), ('Mine Nancy', 3);
INSERT INTO t_diplomas (name) VALUES ('CDA'), ('Ingénieur généraliste'), ('Ingénieur Civil');
INSERT INTO t_formations (name, school_id, diploma_id) VALUES ('IT school', 1, 1), ('Cycle Ingénieur', 2, 2), ('Ingénieur Civil', 3, 3);


INSERT INTO t_roles (authority, default_role) VALUES ('ROLE_ADMIN', true);

SELECT * FROM t_formations tf ;
SELECT * FROM t_schools ts  ;
SELECT * FROM t_cities tc ;
SELECT * FROM t_diplomas; 
SELECT * FROM t_accounts ta ;
SELECT * FROM t_roles;
SELECT * FROM t_associate;

SELECT * FROM t_formations tf JOIN t_cities tc WHERE t_cities.name = 'Paris';