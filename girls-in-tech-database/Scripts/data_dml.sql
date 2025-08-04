--DELETE FROM t_formations;
--DELETE FROM t_schools;
--DELETE FROM t_diplomas;
--DELETE FROM t_cities;
--
--INSERT INTO t_cities (name) VALUES ('Montreuil'), ('Brest'), ('Nancy');
--INSERT INTO t_schools (name, city_id) VALUES ('Simplon', 1), ('IMT Atlantique', 2), ('Mine Nancy', 3);
--INSERT INTO t_diplomas (name) VALUES ('CDA'), ('Ingénieur généraliste'), ('Ingénieur Civil');
--INSERT INTO t_formations (name, school_id, diploma_id) VALUES ('IT school', 1, 1), ('Cycle Ingénieur', 2, 2), ('Ingénieur Civil', 3, 3);


INSERT INTO t_roles (authority) VALUES ('ROLE_ADMIN'), ('ROLE_ELEVE'), ('ROLE_ALUMNI');
--
/*SELECT * FROM t_formations tf ;
SELECT * FROM t_schools ts  ;
SELECT * FROM t_cities tc ;
SELECT * FROM t_diplomas; */
--SELECT * FROM t_accounts ta ;
--SELECT * FROM t_roles;
--SELECT * FROM t_associate;
--SELECT * FROM t_questions;
--SELECT * FROM t_answers;

--SELECT * FROM t_formations tf JOIN t_cities tc WHERE t_cities.name = 'Paris';
--
--DELETE FROM t_formations WHERE id = 3;
--DELETE FROM t_schools WHERE id = 5;
--
--SELECT * FROM t_formations tf JOIN t_diplomas td ON tf.diploma_id=td.id;
--SELECT * FROM t_formations tf JOIN t_schools ts ON tf.school_id =ts.id JOIN t_diplomas td ON tf.diploma_id=td.id;
--
--SELECT f.*
--FROM t_formations f
--JOIN t_schools s ON f.school_id = s.id
--JOIN t_diplomas d ON f.diploma_id = d.id
--JOIN t_cities c ON s.city_id = c.id
--WHERE
--    (:courseName IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :courseName, '%')))
--    AND (:schoolName IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :schoolName, '%')))
--    AND (:diplomaName IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :diplomaName, '%')))
--    AND (:cityName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :cityName, '%')));
--
--SELECT f."name", s."name", d."name", c."name"
--FROM t_formations f
--JOIN t_schools s ON f.school_id = s.id
--JOIN t_diplomas d ON f.diploma_id = d.id
--JOIN t_cities c ON s.city_id = c.id
--WHERE LOWER(d.name) LIKE LOWER(CONCAT('%ingénieur%'))
--    AND LOWER(c.name) LIKE LOWER(CONCAT('%Paris%'));
--
--
--SELECT tf."name", ts."name", td."name", tc."name", tf.description, tf.url FROM t_formations tf JOIN t_schools ts ON tf.school_id = ts.id JOIN t_diplomas td ON tf.diploma_id = td.id JOIN t_cities tc ON ts.city_id = tc.id WHERE tf.id = 1;

INSERT INTO t_cities (name) VALUES
('Paris'),
('Palaiseau'),
('Nancy'),
('Brest'),
('Toulouse'),
('Lyon'),
('Grenoble'),
('Lille'),
('Strasbourg'),
('Rennes');

INSERT INTO t_diplomas (name) VALUES
('Diplôme d’ingénieur'),
('Diplôme d’ingénieur Télécom'),
('Cycle ingénieur polytechnicien'),
('Diplôme d’ingénieur en Génie Civil'),
('Diplôme d’ingénieur en Énergie'),
('Licence Informatique'),
('Licence Physique'),
('Licence Chimie'),
('Diplôme d’ingénieur en Mécanique'),
('Diplôme d’ingénieur en Environnement'),
('Licence Électronique');

INSERT INTO t_schools (name, city_id) VALUES
('École Polytechnique', 2),     -- Palaiseau
('Télécom Paris', 1),           -- Paris
('Télécom Nancy', 3),           -- Nancy
('IMT Atlantique', 4),          -- Brest
('INSA Toulouse', 5),           -- Toulouse
('INSA Lyon', 6),               -- Lyon
('Grenoble INP - Ense3', 7),    -- Grenoble
('Centrale Lille', 8),          -- Lille
('ENSTA Paris', 1),             -- Paris
('ENS Paris-Saclay', 2),        -- Palaiseau
('Université de Strasbourg', 9),-- Strasbourg
('ENS Rennes', 10);             -- Rennes

INSERT INTO t_formations (name, school_id, diploma_id, description, url) VALUES
('Cycle ingénieur polytechnicien', 1, 3, 'Programme pluridisciplinaire de haut niveau en sciences et ingénierie.', 'https://www.polytechnique.edu/formation1'),
('Ingénieur Télécom - Informatique', 2, 2, 'Formation d’ingénieur en télécoms et réseaux avancés.', 'https://www.telecom-paris.fr/formation2'),
('Ingénieur Informatique et Réseaux', 3, 1, 'Spécialisation en cybersécurité, réseau et cloud.', 'https://telecomnancy.univ-lorraine.fr/formation3'),
('Ingénieur Généraliste', 4, 1, 'Formation pluridisciplinaire avec options spécialisées.', 'https://www.imt-atlantique.fr/formation4'),
('Ingénieur Génie Civil', 5, 4, 'Forme des ingénieurs en construction durable.', 'https://www.insa-toulouse.fr/formation5'),
('Ingénieur Énergie', 6, 5, 'Énergies renouvelables, réseaux intelligents, efficacité énergétique.', 'https://www.insa-lyon.fr/formation6'),
('Ingénieur Environnement', 7, 10, 'Développement durable, eau, pollution et énergie.', 'https://ense3.grenoble-inp.fr/formation7'),
('Ingénieur en Mécanique', 8, 9, 'Conception et modélisation des systèmes mécaniques.', 'https://centralelille.fr/formation8'),
('Ingénieur Data Science', 9, 1, 'Traitement de données massives et apprentissage automatique.', 'https://www.ensta-paris.fr/formation9'),
('Ingénieur Mathématiques Appliquées', 10, 1, 'Maths pour la physique, ingénierie et informatique.', 'https://ens-paris-saclay.fr/formation10'),
('Licence Informatique', 11, 6, 'Fondamentaux de l’algorithmique, programmation, bases de données.', 'https://www.unistra.fr/formation11'),
('Licence Physique Fondamentale', 11, 7, 'Physique classique, quantique, et expérimentale.', 'https://www.unistra.fr/formation12'),
('Licence Chimie Organique', 11, 8, 'Chimie moléculaire, analyse et synthèse organique.', 'https://www.unistra.fr/formation13'),
('Licence Électronique', 11, 11, 'Circuits, systèmes embarqués et traitement du signal.', 'https://www.unistra.fr/formation14'),
('Licence Informatique - Rennes', 12, 6, 'Développement logiciel, IA, programmation avancée.', 'https://www.ens-rennes.fr/formation15'),
('Ingénieur Télécom Réseaux', 2, 2, 'Télécommunications, protocoles et architecture réseau.', 'https://www.telecom-paris.fr/formation16'),
('Ingénieur Génie Logiciel', 3, 1, 'Architecture logicielle, génie logiciel et cloud.', 'https://telecomnancy.univ-lorraine.fr/formation17'),
('Ingénieur Multimédia', 3, 1, 'Traitement de l’image, vidéo, interfaces homme-machine.', 'https://telecomnancy.univ-lorraine.fr/formation18'),
('Ingénieur Robotique', 5, 1, 'Systèmes embarqués, robotique mobile et perception.', 'https://www.insa-toulouse.fr/formation19'),
('Ingénieur Systèmes Électriques', 6, 5, 'Machines électriques, convertisseurs et énergies.', 'https://www.insa-lyon.fr/formation20'),
('Ingénieur Hydraulique', 7, 10, 'Hydraulique urbaine, fluviale et modélisation.', 'https://ense3.grenoble-inp.fr/formation21'),
('Ingénieur BTP', 5, 4, 'Travaux publics, infrastructures et sécurité.', 'https://www.insa-toulouse.fr/formation22'),
('Ingénieur Matériaux', 6, 1, 'Science des matériaux, mécanique, durabilité.', 'https://www.insa-lyon.fr/formation23'),
('Ingénieur Aéronautique', 5, 1, 'Propulsion, structure et dynamique du vol.', 'https://www.insa-toulouse.fr/formation24'),
('Ingénieur Automobile', 6, 1, 'Systèmes mécaniques et électroniques embarqués.', 'https://www.insa-lyon.fr/formation25'),
('Licence Physique - Rennes', 12, 7, 'Ondes, optique, physique des matériaux.', 'https://www.ens-rennes.fr/formation26'),
('Licence Chimie - Rennes', 12, 8, 'Chimie analytique, thermochimie, catalyse.', 'https://www.ens-rennes.fr/formation27'),
('Ingénieur IA et Robotique', 9, 1, 'Robotique autonome, vision et apprentissage.', 'https://www.ensta-paris.fr/formation28'),
('Ingénieur Systèmes Embarqués', 8, 9, 'Temps réel, microcontrôleurs, électronique.', 'https://centralelille.fr/formation29'),
('Ingénieur Ingénierie Durable', 7, 10, 'Transition énergétique et éco-conception.', 'https://ense3.grenoble-inp.fr/formation30'),
('Licence Informatique - Strasbourg', 11, 6, 'Programmation, algorithmique, cybersécurité.', 'https://www.unistra.fr/formation31'),
('Licence Électronique - Rennes', 12, 11, 'Circuits numériques, traitement du signal.', 'https://www.ens-rennes.fr/formation32'),
('Ingénieur Mécatronique', 8, 9, 'Automatisation, contrôle et mécatronique.', 'https://centralelille.fr/formation33'),
('Ingénieur Réseaux Sécurisés', 3, 1, 'Cybersécurité, réseau privé virtuel et cloud.', 'https://telecomnancy.univ-lorraine.fr/formation34'),
('Licence Chimie - Strasbourg', 11, 8, 'Synthèse, analyse, et réactivité chimique.', 'https://www.unistra.fr/formation35'),
('Licence Informatique - Lille', 8, 6, 'Algorithmique, Java, Python, gestion de projets.', 'https://centralelille.fr/formation36'),
('Licence Électronique - Lyon', 6, 11, 'Systèmes numériques et analogiques.', 'https://www.insa-lyon.fr/formation37'),
('Licence Physique - Lille', 8, 7, 'Théorie électromagnétique et optique.', 'https://centralelille.fr/formation38'),
('Licence Chimie - Lyon', 6, 8, 'Chimie physique, organique et minérale.', 'https://www.insa-lyon.fr/formation39'),
('Ingénieur Mécanique - Rennes', 12, 9, 'Conception mécanique et fabrication.', 'https://www.ens-rennes.fr/formation40'),
('Licence Informatique - Nancy', 3, 6, 'Programmation orientée objet et algorithmique.', 'https://telecomnancy.univ-lorraine.fr/formation41'),
('Licence Physique - Grenoble', 7, 7, 'Physique appliquée et simulations.', 'https://ense3.grenoble-inp.fr/formation42'),
('Ingénieur Énergies Renouvelables', 7, 5, 'Solaire, hydraulique, stockage.', 'https://ense3.grenoble-inp.fr/formation43'),
('Licence Électronique - Nancy', 3, 11, 'Architecture des systèmes électroniques.', 'https://telecomnancy.univ-lorraine.fr/formation44'),
('Ingénieur Thermique', 7, 10, 'Énergie thermique, échangeurs et rendement.', 'https://ense3.grenoble-inp.fr/formation45'),
('Licence Informatique - Brest', 4, 6, 'Architecture logicielle et sécurité.', 'https://www.imt-atlantique.fr/formation46'),
('Licence Physique - Brest', 4, 7, 'Thermodynamique et électricité.', 'https://www.imt-atlantique.fr/formation47'),
('Licence Chimie - Paris', 1, 8, 'Bases en chimie et méthodologie expérimentale.', 'https://www.polytechnique.edu/formation48'),
('Ingénieur Généraliste - Rennes', 12, 1, 'Approche multidisciplinaire en sciences.', 'https://www.ens-rennes.fr/formation49'),
('Licence Électronique - Paris', 2, 11, 'Systèmes et communications embarqués.', 'https://www.telecom-paris.fr/formation50');


