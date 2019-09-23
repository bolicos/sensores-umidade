INSERT INTO roles VALUES (1, 'USER_BASIC');
INSERT INTO roles VALUES (2, 'USER_ADMIN');

INSERT INTO users VALUES (1, true, '$2a$10$EVYVmdn2u0DxfqcpDkOTA.iUh8It1rWosBzk.Gv5wlZH59y4xVt3C', 'maria.silva');
INSERT INTO users VALUES (2, true, '$2a$10$l77l/v.uw88gh5dp2NhttOfnzInQ7rqzC0qTDvrx2FC7GcR4oVARu', 'joao.souza');
INSERT INTO users VALUES (3, true, '$2a$10$ETblcaH7vdirKv0aqInMguh9.kxuVf3XX8ujpVNQ.8qcXu9JHgwpa', 'ariel.santos');
INSERT INTO users VALUES (4, true, '$2a$10$TqqULxVu9jtn0pS7V.7nx.GO3L2XRL3akNswY6lCWl1SiUBbiffOq', 'admin.admin');

INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (2, 1);
INSERT INTO users_roles VALUES (3, 1);
INSERT INTO users_roles VALUES (4, 2);

INSERT INTO types VALUES (1, 'STRAWBERRY', 60, 80);
INSERT INTO types VALUES (2, 'CACTUS', 20, 50);
INSERT INTO types VALUES (3, 'MUSHROOM', 80, 90);
INSERT INTO types VALUES (4, 'VIOLET', 40, 80);
INSERT INTO types VALUES (5, 'LAVENDER', 20, 30);

INSERT INTO plants VALUES (1, 1);
INSERT INTO plants VALUES (2, 2);
INSERT INTO plants VALUES (3, 3);
INSERT INTO plants VALUES (4, 4);
INSERT INTO plants VALUES (5, 5);
INSERT INTO plants VALUES (6, 1);
INSERT INTO plants VALUES (7, 2);
INSERT INTO plants VALUES (8, 3);
INSERT INTO plants VALUES (9, 4);
INSERT INTO plants VALUES (10, 5);
INSERT INTO plants VALUES (11, 1);
INSERT INTO plants VALUES (12, 2);
INSERT INTO plants VALUES (13, 3);
INSERT INTO plants VALUES (14, 4);
INSERT INTO plants VALUES (15, 5);

INSERT INTO sensors VALUES (1, 'Comparador LM393', 1, 1);
INSERT INTO sensors VALUES (2, 'Comparador CJMCU', 2, 1);
INSERT INTO sensors VALUES (3, 'Datasheet SHT20', 3, 1);
INSERT INTO sensors VALUES (4, 'solo Grove', 4, 1);
INSERT INTO sensors VALUES (5, 'Comparador LM7805', 5, 1);
INSERT INTO sensors VALUES (6, 'Comparador LM393', 6, 2);
INSERT INTO sensors VALUES (7, 'Comparador CJMCU', 7, 2);
INSERT INTO sensors VALUES (8, 'Datasheet SHT20', 8, 2);
INSERT INTO sensors VALUES (9, 'solo Grove', 9, 2);
INSERT INTO sensors VALUES (10, 'Comparador LM7805', 10, 2);
INSERT INTO sensors VALUES (11, 'Comparador LM393', 11, 3);
INSERT INTO sensors VALUES (12, 'Comparador CJMCU', 12, 3);
INSERT INTO sensors VALUES (13, 'Datasheet SHT20', 13, 3);
INSERT INTO sensors VALUES (14, 'solo Grove', 14, 3);
INSERT INTO sensors VALUES (15, 'Comparador LM7805', 15, 3);

INSERT INTO reads VALUES (1, '2019-07-10 07:00:00', 70, true, 1);
INSERT INTO reads VALUES (2, '2019-07-10 07:00:00', 30, true, 2);
INSERT INTO reads VALUES (3, '2019-07-10 07:00:00', 85, true, 3);
INSERT INTO reads VALUES (4, '2019-07-10 07:00:00', 60, true, 4);
INSERT INTO reads VALUES (5, '2019-07-10 07:00:00', 25, true, 5);
INSERT INTO reads VALUES (6, '2019-07-10 07:00:00', 70, true, 6);
INSERT INTO reads VALUES (7, '2019-07-10 07:00:00', 30, true, 7);
INSERT INTO reads VALUES (8, '2019-07-10 07:00:00', 85, true, 8);
INSERT INTO reads VALUES (9, '2019-07-10 07:00:00', 60, true, 9);
INSERT INTO reads VALUES (10, '2019-07-10 07:00:00', 25, true, 10);
INSERT INTO reads VALUES (11, '2019-07-10 07:00:00', 70, true, 11);
INSERT INTO reads VALUES (12, '2019-07-10 07:00:00', 30, true, 12);
INSERT INTO reads VALUES (13, '2019-07-10 07:00:00', 85, true, 13);
INSERT INTO reads VALUES (14, '2019-07-10 07:00:00', 60, true, 14);
INSERT INTO reads VALUES (15, '2019-07-10 07:00:00', 25, true, 15);

INSERT INTO reads VALUES (16, 1, 50, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (17, 2, 10, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (18, 3, 70, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (19, 4, 30, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (20, 5, 10, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (21, 6, 50, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (22, 7, 10, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (23, 8, 70, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (24, 9, 30, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (25, 10, 10, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (26, 11, 50, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (27, 12, 10, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (28, 13, 70, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (29, 14, 30, false, '2019-07-10 07:00:00');
INSERT INTO reads VALUES (30, 15, 10, false, '2019-07-10 07:00:00');

