SELECT * FROM t_accounts ta JOIN t_roles tr ON ta.role_id = tr.id;

SELECT tr.authority, COUNT(*) FROM t_accounts ta JOIN t_roles tr ON ta.role_id = tr.id GROUP BY tr.authority;

SELECT COUNT(*) FROM t_accounts ta JOIN t_roles tr ON ta.role_id = tr.id WHERE tr.authority = 'ROLE_ELEVE';

//pour chaque rôle il y a combien d'account



