--spécific schema pour test
--CREATE SCHEMA girlsintech_schema_test;

--SELECT * FROM t_formations tf ;
SELECT * FROM t_accounts ta ;

DROP TABLE IF EXISTS t_cities CASCADE;
DROP TABLE IF EXISTS t_diplomas CASCADE;
DROP TABLE IF EXISTS t_schools CASCADE;
DROP TABLE IF EXISTS t_formations CASCADE;
DROP TABLE IF EXISTS t_roles CASCADE;
DROP TABLE IF EXISTS t_accounts CASCADE;

--spécific ddl pour test
CREATE TABLE girlsintech_schema_test.t_cities(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(50) NOT NULL,
   CONSTRAINT t_cities_pkey PRIMARY KEY(id),
   CONSTRAINT t_cities_ukey UNIQUE (name)
);

CREATE TABLE girlsintech_schema_test.t_schools(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(200) NOT NULL,
   city_id INT,
   CONSTRAINT t_schools_pkey PRIMARY KEY(id),
   CONSTRAINT t_schools_ukey UNIQUE (name, city_id),
   CONSTRAINT t_schools_city_fkey FOREIGN KEY(city_id) REFERENCES t_cities(id)  -- 町とのリレーション
);

CREATE TABLE girlsintech_schema_test.t_diplomas(
	id INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(200) NOT NULL,
	CONSTRAINT t_diplomas_pkey PRIMARY KEY(id),
	CONSTRAINT t_diplomas_ukey UNIQUE (name)
	);

CREATE TABLE girlsintech_schema_test.t_formations(
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

CREATE TABLE girlsintech_schema_test.t_roles(
	id INT GENERATED ALWAYS AS IDENTITY,
	authority varchar(60),
	CONSTRAINT t_roles_pkey PRIMARY KEY (id),
	CONSTRAINT t_roles_ukey UNIQUE (authority)
	);

CREATE TABLE girlsintech_schema_test.t_accounts(
	id INT GENERATED ALWAYS AS IDENTITY,
	username varchar(255),
	password varchar(60),
	role_id INT,
	CONSTRAINT t_accounts_pkey PRIMARY KEY (id),
	CONSTRAINT t_accounts_ukey UNIQUE (username),
	CONSTRAINT t_accounts_roles_fkey FOREIGN KEY(role_id) REFERENCES t_roles(id)
);

--spécific DML pour test
INSERT INTO girlsintech_schema_test.t_roles (authority) VALUES ('ROLE_ADMIN'), ('ROLE_ELEVE'), ('ROLE_ALUMNI');
INSERT INTO girlsintech_schema_test.t_cities (name) VALUES
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

INSERT INTO girlsintech_schema_test.t_diplomas (name) VALUES
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

INSERT INTO girlsintech_schema_test.t_schools (name, city_id) VALUES
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

INSERT INTO girlsintech_schema_test.t_formations (name, school_id, diploma_id, description, url) VALUES
('Cycle ingénieur polytechnicien', 1, 3, 'Programme pluridisciplinaire de haut niveau en sciences et ingénierie.', 'https://www.polytechnique.edu/formation1'),
('Ingénieur Télécom - Informatique', 2, 2, 'Formation d’ingénieur en télécoms et réseaux avancés.', 'https://www.telecom-paris.fr/formation2'),
('Ingénieur Informatique et Réseaux', 3, 1, 'Spécialisation en cybersécurité, réseau et cloud.', 'https://telecomnancy.univ-lorraine.fr/formation3'),
('Ingénieur Généraliste1', 4, 1, 'Formation pluridisciplinaire avec options spécialisées.', 'https://www.imt-atlantique.fr/formation4'),
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
