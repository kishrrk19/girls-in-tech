DELETE FROM t_formation_school;

INSERT INTO t_formation_school(school_name, formation_name, city) VALUES ('IMT Atlantique', 'Ingénieur généraliste', 'Brest'),('Simplon.co', 'CDA', 'Montreuil');

SELECT * FROM t_formation_school tfs ;

INSERT INTO t_roles (authority, default_role) VALUES ('ROLE_ADMIN', true);