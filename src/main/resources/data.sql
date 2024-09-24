
/*roles*/

INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');


/*users*/

INSERT INTO users (id_user, username, password) VALUES (default, 'user', '$2b$12$EUZlXMBcF0KGxz1Q1zdaXOaHKPv0ttdx/G1zq5R3.1Px4BxoC3KDW'); /*user123*/
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO'); /*password*/


/*roles_users*/

INSERT INTO roles_users (id_role, id_user) VALUES (1, 1);  
INSERT INTO roles_users (id_role, id_user) VALUES (2, 2); 