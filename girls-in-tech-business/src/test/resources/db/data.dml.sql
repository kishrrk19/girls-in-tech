INSERT INTO t_roles (authority) VALUES ('ROLE_ADMIN'), ('ROLE_ELEVE'), ('ROLE_ALUMNI');

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
('Cycle ingénieur polytechnicien', 1, 3, 'Programme pluridisciplinaire de haut niveau en sciences et ingénierie.', 'https://www.polytechnique.edu/programmes/cycle-ingenieur-polytechnicien'),
('Ingénieur Télécom - Informatique', 2, 2, 'Formation d’ingénieur en télécoms et réseaux avancés.', 'https://www.telecom-paris.fr/programmes/ingenieur-telecom-informatique'),
('Ingénieur Informatique et Réseaux', 3, 1, 'Spécialisation en cybersécurité, réseau et cloud.', 'https://telecomnancy.univ-lorraine.fr/formations/ingenieur-informatique-reseaux'),
('Ingénieur Généraliste', 4, 1, 'Formation pluridisciplinaire avec options spécialisées.', 'https://www.imt-atlantique.fr/programmes/ingenieur-generaliste'),
('Ingénieur Génie Civil', 5, 4, 'Forme des ingénieurs en construction durable.', 'https://www.insa-toulouse.fr/formations/ingenieur-genie-civil'),
('Ingénieur Énergie', 6, 5, 'Énergies renouvelables, réseaux intelligents, efficacité énergétique.', 'https://www.insa-lyon.fr/formations/ingenieur-energie'),
('Ingénieur Environnement', 7, 10, 'Développement durable, eau, pollution et énergie.', 'https://ense3.grenoble-inp.fr/formations/ingenieur-environnement'),
('Ingénieur en Mécanique', 8, 9, 'Conception et modélisation des systèmes mécaniques.', 'https://centralelille.fr/formations/ingenieur-mecanique'),
('Ingénieur Data Science', 9, 1, 'Traitement de données massives et apprentissage automatique.', 'https://www.ensta-paris.fr/formations/ingenieur-data-science'),
('Ingénieur Mathématiques Appliquées', 10, 1, 'Maths pour la physique, ingénierie et informatique.', 'https://ens-paris-saclay.fr/formations/ingenieur-mathematiques-appliquees'),
('Licence Informatique', 11, 6, 'Fondamentaux de l’algorithmique, programmation, bases de données.', 'https://www.unistra.fr/formations/licence-informatique'),
('Licence Physique Fondamentale', 11, 7, 'Physique classique, quantique, et expérimentale.', 'https://www.unistra.fr/formations/licence-physique-fondamentale'),
('Licence Chimie Organique', 11, 8, 'Chimie moléculaire, analyse et synthèse organique.', 'https://www.unistra.fr/formations/licence-chimie-organique'),
('Licence Électronique', 11, 11, 'Circuits, systèmes embarqués et traitement du signal.', 'https://www.unistra.fr/formations/licence-electronique'),
('Licence Informatique - Rennes', 12, 6, 'Développement logiciel, IA, programmation avancée.', 'https://www.ens-rennes.fr/formations/licence-informatique-rennes'),
('Ingénieur Télécom Réseaux', 2, 2, 'Télécommunications, protocoles et architecture réseau.', 'https://www.telecom-paris.fr/programmes/ingenieur-telecom-reseaux'),
('Ingénieur Génie Logiciel', 3, 1, 'Architecture logicielle, génie logiciel et cloud.', 'https://telecomnancy.univ-lorraine.fr/formations/ingenieur-genie-logiciel'),
('Ingénieur Multimédia', 3, 1, 'Traitement de l’image, vidéo, interfaces homme-machine.', 'https://telecomnancy.univ-lorraine.fr/formations/ingenieur-multimedia'),
('Ingénieur Robotique', 5, 1, 'Systèmes embarqués, robotique mobile et perception.', 'https://www.insa-toulouse.fr/formations/ingenieur-robotique'),
('Ingénieur Systèmes Électriques', 6, 5, 'Machines électriques, convertisseurs et énergies.', 'https://www.insa-lyon.fr/formations/ingenieur-systemes-electriques'),
('Ingénieur Hydraulique', 7, 10, 'Hydraulique urbaine, fluviale et modélisation.', 'https://ense3.grenoble-inp.fr/formations/ingenieur-hydraulique'),
('Ingénieur BTP', 5, 4, 'Travaux publics, infrastructures et sécurité.', 'https://www.insa-toulouse.fr/formations/ingenieur-btp'),
('Ingénieur Matériaux', 6, 1, 'Science des matériaux, mécanique, durabilité.', 'https://www.insa-lyon.fr/formations/ingenieur-materiaux'),
('Ingénieur Aéronautique', 5, 1, 'Propulsion, structure et dynamique du vol.', 'https://www.insa-toulouse.fr/formations/ingenieur-aeronautique'),
('Ingénieur Automobile', 6, 1, 'Systèmes mécaniques et électroniques embarqués.', 'https://www.insa-lyon.fr/formations/ingenieur-automobile'),
('Licence Physique - Rennes', 12, 7, 'Ondes, optique, physique des matériaux.', 'https://www.ens-rennes.fr/formations/licence-physique-rennes'),
('Licence Chimie - Rennes', 12, 8, 'Chimie analytique, thermochimie, catalyse.', 'https://www.ens-rennes.fr/formations/licence-chimie-rennes'),
('Ingénieur IA et Robotique', 9, 1, 'Robotique autonome, vision et apprentissage.', 'https://www.ensta-paris.fr/formations/ingenieur-ia-robotique'),
('Ingénieur Systèmes Embarqués', 8, 9, 'Temps réel, microcontrôleurs, électronique.', 'https://centralelille.fr/formations/ingenieur-systemes-embarques'),
('Ingénieur Ingénierie Durable', 7, 10, 'Transition énergétique et éco-conception.', 'https://ense3.grenoble-inp.fr/formations/ingenierie-durable'),
('Licence Informatique - Strasbourg', 11, 6, 'Programmation, algorithmique, cybersécurité.', 'https://www.unistra.fr/formations/licence-informatique-strasbourg'),
('Licence Électronique - Rennes', 12, 11, 'Circuits numériques, traitement du signal.', 'https://www.ens-rennes.fr/formations/licence-electronique-rennes'),
('Ingénieur Mécatronique', 8, 9, 'Automatisation, contrôle et mécatronique.', 'https://centralelille.fr/formations/ingenieur-mecatronique'),
('Ingénieur Réseaux Sécurisés', 3, 1, 'Cybersécurité, réseau privé virtuel et cloud.', 'https://telecomnancy.univ-lorraine.fr/formations/ingenieur-reseaux-securises'),
('Licence Chimie - Strasbourg', 11, 8, 'Synthèse, analyse, et réactivité chimique.', 'https://www.unistra.fr/formations/licence-chimie-strasbourg'),
('Licence Informatique - Lille', 8, 6, 'Algorithmique, Java, Python, gestion de projets.', 'https://centralelille.fr/formations/licence-informatique-lille'),
('Licence Électronique - Lyon', 6, 11, 'Systèmes numériques et analogiques.', 'https://www.insa-lyon.fr/formations/licence-electronique-lyon'),
('Licence Physique - Lille', 8, 7, 'Théorie électromagnétique et optique.', 'https://centralelille.fr/formations/licence-physique-lille'),
('Licence Chimie - Lyon', 6, 8, 'Chimie physique, organique et minérale.', 'https://www.insa-lyon.fr/formations/licence-chimie-lyon'),
('Ingénieur Mécanique - Rennes', 12, 9, 'Conception mécanique et fabrication.', 'https://www.ens-rennes.fr/formations/ingenieur-mecanique-rennes'),
('Licence Informatique - Nancy', 3, 6, 'Programmation orientée objet et algorithmique.', 'https://telecomnancy.univ-lorraine.fr/formations/licence-informatique-nancy'),
('Licence Physique - Grenoble', 7, 7, 'Physique appliquée et simulations.', 'https://ense3.grenoble-inp.fr/formations/licence-physique-grenoble'),
('Ingénieur Énergies Renouvelables', 7, 5, 'Solaire, hydraulique, stockage.', 'https://ense3.grenoble-inp.fr/formations/ingenieur-energies-renouvelables'),
('Licence Électronique - Nancy', 3, 11, 'Architecture des systèmes électroniques.', 'https://telecomnancy.univ-lorraine.fr/formations/licence-electronique-nancy'),
('Ingénieur Thermique', 7, 10, 'Énergie thermique, échangeurs et rendement.', 'https://ense3.grenoble-inp.fr/formations/ingenieur-thermique'),
('Licence Informatique - Brest', 4, 6, 'Architecture logicielle et sécurité.', 'https://www.imt-atlantique.fr/formations/licence-informatique-brest'),
('Licence Physique - Brest', 4, 7, 'Thermodynamique et électricité.', 'https://www.imt-atlantique.fr/formations/licence-physique-brest'),
('Licence Chimie - Paris', 1, 8, 'Bases en chimie et méthodologie expérimentale.', 'https://www.polytechnique.edu/formations/licence-chimie-paris'),
('Ingénieur Généraliste - Rennes', 12, 1, 'Approche multidisciplinaire en sciences.', 'https://www.ens-rennes.fr/formations/ingenieur-generaliste-rennes'),
('Licence Électronique - Paris', 2, 11, 'Systèmes et communications embarqués.', 'https://www.telecom-paris.fr/formations/licence-electronique-paris');