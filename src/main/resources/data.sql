
/*roles*/

INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');


/*users*/

INSERT INTO users (id_user, username, password) VALUES (default, 'user', '$2b$12$EUZlXMBcF0KGxz1Q1zdaXOaHKPv0ttdx/G1zq5R3.1Px4BxoC3KDW'); /*user123*/
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO'); /*password*/


/*roles_users*/

INSERT INTO roles_users (id_role, id_user) VALUES (1, 1);  
INSERT INTO roles_users (id_role, id_user) VALUES (2, 2); 

/*escape_rooms*/

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('Derrota al hacker', 'Un hacker ha tomado el control de tu ordenador y se apoderará de todos tus archivos si no superas sus pruebas.', 'Baja', 'defeat_hacker.jpg');

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('Misión Espacial', 'Rescata la nave perdida en el espacio y regresa a salvo a la Tierra.', 'Alta', 'space_mission.jpg');

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('El Código Secreto', 'Descifra el código encriptado antes de que se agote el tiempo.', 'Media', 'secret_code.jpg');

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('La Habitación del Tiempo', 'Manipula relojes antiguos para escapar de una dimensión temporal atrapada.', 'Baja', 'time_room.jpg');

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('El Misterio del Faraón', 'Explora una antigua pirámide egipcia y resuelve los misterios ocultos.', 'Media', 'pharaoh_mystery.jpg');

INSERT INTO escape_rooms (nombre, descripcion, dificultad, image) 
VALUES 
('La Fortaleza Prohibida', 'Escapa de una fortaleza medieval repleta de trampas y enemigos.', 'Alta', 'forbidden_fortress.jpg');

