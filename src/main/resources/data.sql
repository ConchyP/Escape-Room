/*roles*/

INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_ADMIN');


/*users*/

INSERT INTO users (user_id, username, password) VALUES (default, 'user', '$2b$12$EUZlXMBcF0KGxz1Q1zdaXOaHKPv0ttdx/G1zq5R3.1Px4BxoC3KDW'); /*user123*/
INSERT INTO users (user_id, username, password) VALUES (default, 'admin', '$2a$12$CpLpmTSK3LqKcVcD/wJaj.URGybXR0fCtLnNynPvwlNQDJT8NGH.O'); /*password*/


/*roles_users*/

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);  
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2); 