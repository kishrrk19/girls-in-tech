DELETE FROM t_formations;
DELETE FROM t_schools;
DELETE FROM t_diplomas;
DELETE FROM t_cities;

INSERT INTO t_cities (name) VALUES ('Montreuil'), ('Brest'), ('Nancy');
INSERT INTO t_schools (name, city_id) VALUES ('Simplon', 1), ('IMT Atlantique', 2), ('Mine Nancy', 3);
INSERT INTO t_diplomas (name) VALUES ('CDA'), ('Ingénieur généraliste'), ('Ingénieur Civil');
INSERT INTO t_formations (name, school_id, diploma_id) VALUES ('IT school', 1, 1), ('Cycle Ingénieur', 2, 2), ('Ingénieur Civil', 3, 3);


INSERT INTO t_roles (authority) VALUES ('ROLE_ADMIN'), ('ROLE_ELEVE'), ('ROLE_ALUMNI');

SELECT * FROM t_formations tf ;
SELECT * FROM t_schools ts  ;
SELECT * FROM t_cities tc ;
SELECT * FROM t_diplomas; 
SELECT * FROM t_accounts ta ;
SELECT * FROM t_roles;
SELECT * FROM t_associate;

SELECT * FROM t_formations tf JOIN t_cities tc WHERE t_cities.name = 'Paris';

DELETE FROM t_formations WHERE id = 3;
DELETE FROM t_schools WHERE id = 5;

SELECT * FROM t_formations tf JOIN t_diplomas td ON tf.diploma_id=td.id;
SELECT * FROM t_formations tf JOIN t_schools ts ON tf.school_id =ts.id JOIN t_diplomas td ON tf.diploma_id=td.id;

SELECT f.*
FROM t_formations f
JOIN t_schools s ON f.school_id = s.id
JOIN t_diplomas d ON f.diploma_id = d.id
JOIN t_cities c ON s.city_id = c.id
WHERE
    (:courseName IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :courseName, '%')))
    AND (:schoolName IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :schoolName, '%')))
    AND (:diplomaName IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :diplomaName, '%')))
    AND (:cityName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :cityName, '%')));

SELECT f."name", s."name", d."name", c."name"
FROM t_formations f
JOIN t_schools s ON f.school_id = s.id
JOIN t_diplomas d ON f.diploma_id = d.id
JOIN t_cities c ON s.city_id = c.id
WHERE LOWER(d.name) LIKE LOWER(CONCAT('%ingénieur%'))
    AND LOWER(c.name) LIKE LOWER(CONCAT('%Paris%'));


SELECT tf."name", ts."name", td."name", tc."name", tf.description, tf.url FROM t_formations tf JOIN t_schools ts ON tf.school_id = ts.id JOIN t_diplomas td ON tf.diploma_id = td.id JOIN t_cities tc ON ts.city_id = tc.id WHERE tf.id = 1;
