use ormlearn;

CREATE TABLE user (
    us_id INT PRIMARY KEY,
    us_name VARCHAR(45),
    us_email VARCHAR(45)
);

CREATE TABLE question (
    qt_id INT PRIMARY KEY,
    qt_text VARCHAR(150)
);

CREATE TABLE options (
    op_id INT PRIMARY KEY,
    op_qt_id INT,
    op_score DOUBLE,
    op_text VARCHAR(100),
    FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt (
    at_id INT PRIMARY KEY,
    at_date DATE,
    at_us_id INT,
    at_score DOUBLE,
    FOREIGN KEY (at_us_id) REFERENCES user(us_id)
);

CREATE TABLE attempt_question (
    aq_id INT PRIMARY KEY,
    aq_at_id INT,
    aq_qt_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt_option (
    ao_id INT PRIMARY KEY,
    ao_op_id INT,
    ao_aq_id INT,
    ao_selected BIT,
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id),
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id)
);

INSERT INTO user (us_id, us_name, us_email) VALUES
(1, 'Alice', 'alice@example.com'),
(2, 'Bob', 'bob@example.com'),
(3, 'Charlie', 'charlie@example.com'),
(4, 'David', 'david@example.com'),
(5, 'Eve', 'eve@example.com'),
(6, 'Frank', 'frank@example.com'),
(7, 'Grace', 'grace@example.com'),
(8, 'Hank', 'hank@example.com'),
(9, 'Ivy', 'ivy@example.com'),
(10, 'Jack', 'jack@example.com'),
(11, 'Karen', 'karen@example.com'),
(12, 'Leo', 'leo@example.com'),
(13, 'Mia', 'mia@example.com'),
(14, 'Nina', 'nina@example.com'),
(15, 'Oscar', 'oscar@example.com'),
(16, 'Paul', 'paul@example.com'),
(17, 'Quincy', 'quincy@example.com'),
(18, 'Rachel', 'rachel@example.com'),
(19, 'Steve', 'steve@example.com'),
(20, 'Tina', 'tina@example.com'),
(21, 'Uma', 'uma@example.com'),
(22, 'Victor', 'victor@example.com'),
(23, 'Wendy', 'wendy@example.com'),
(24, 'Xavier', 'xavier@example.com'),
(25, 'Yara', 'yara@example.com'),
(26, 'Zane', 'zane@example.com'),
(27, 'Anita', 'anita@example.com'),
(28, 'Brian', 'brian@example.com'),
(29, 'Cathy', 'cathy@example.com'),
(30, 'Derek', 'derek@example.com'),
(31, 'Ella', 'ella@example.com'),
(32, 'Felix', 'felix@example.com'),
(33, 'Gina', 'gina@example.com'),
(34, 'Harold', 'harold@example.com'),
(35, 'Iris', 'iris@example.com'),
(36, 'Jason', 'jason@example.com'),
(37, 'Kylie', 'kylie@example.com'),
(38, 'Liam', 'liam@example.com'),
(39, 'Monica', 'monica@example.com'),
(40, 'Nathan', 'nathan@example.com'),
(41, 'Olivia', 'olivia@example.com'),
(42, 'Peter', 'peter@example.com'),
(43, 'Queen', 'queen@example.com'),
(44, 'Ron', 'ron@example.com'),
(45, 'Sara', 'sara@example.com'),
(46, 'Tom', 'tom@example.com'),
(47, 'Usha', 'usha@example.com'),
(48, 'Vikram', 'vikram@example.com'),
(49, 'Waleed', 'waleed@example.com'),
(50, 'Xena', 'xena@example.com'),
(51, 'Yusuf', 'yusuf@example.com'),
(52, 'Zara', 'zara@example.com'),
(53, 'Aarav', 'aarav@example.com'),
(54, 'Bhavya', 'bhavya@example.com'),
(55, 'Chirag', 'chirag@example.com'),
(56, 'Diya', 'diya@example.com'),
(57, 'Eshan', 'eshan@example.com'),
(58, 'Fiza', 'fiza@example.com'),
(59, 'Gaurav', 'gaurav@example.com'),
(60, 'Hema', 'hema@example.com');

INSERT INTO question (qt_id, qt_text) VALUES
(1, 'What is the extension of the hyper text markup language file?'),
(2, 'What is the maximum level of heading tag in HTML?'),
(3, 'The HTML document starts with <html>. State True or False'),
(4, 'Choose the correct way to store a text value');

INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES
(1, 1, 0.0, '.xhtm'),
(2, 1, 0.0, '.ht'),
(3, 1, 1.0, '.html'),
(4, 1, 0.0, '.htmx'),

(5, 2, 0.0, '5'),
(6, 2, 0.0, '3'),
(7, 2, 0.0, '4'),
(8, 2, 1.0, '6'),

(9, 3, 0.0, 'false'),
(10, 3, 1.0, 'true'),

(11, 4, 0.5, "'John'"),
(12, 4, 0.0, 'John'),
(13, 4, 0.5, '"John"'),
(14, 4, 0.0, '/John/');

INSERT INTO attempt VALUES (1, '2025-07-10', 1, 3.5);
INSERT INTO attempt_question VALUES (1, 1, 1);
INSERT INTO attempt_option VALUES (1, 3, 1, 1);
INSERT INTO attempt_question VALUES (2, 1, 2);
INSERT INTO attempt_option VALUES (2, 8, 2, 1);
INSERT INTO attempt_question VALUES (3, 1, 3);
INSERT INTO attempt_option VALUES (3, 10, 3, 1);
INSERT INTO attempt_question VALUES (4, 1, 4);
INSERT INTO attempt_option VALUES (4, 11, 4, 1);
INSERT INTO attempt VALUES (2, '2025-07-10', 2, 4.5);
INSERT INTO attempt_question VALUES (5, 2, 1);
INSERT INTO attempt_option VALUES (5, 3, 5, 1);
INSERT INTO attempt_question VALUES (6, 2, 2);
INSERT INTO attempt_option VALUES (6, 8, 6, 1);
INSERT INTO attempt_question VALUES (7, 2, 3);
INSERT INTO attempt_option VALUES (7, 10, 7, 1);
INSERT INTO attempt_question VALUES (8, 2, 4);
INSERT INTO attempt_option VALUES (8, 11, 8, 1);
INSERT INTO attempt VALUES (3, '2025-07-10', 3, 5.5);
INSERT INTO attempt_question VALUES (9, 3, 1);
INSERT INTO attempt_option VALUES (9, 3, 9, 1);
INSERT INTO attempt_question VALUES (10, 3, 2);
INSERT INTO attempt_option VALUES (10, 8, 10, 1);
INSERT INTO attempt_question VALUES (11, 3, 3);
INSERT INTO attempt_option VALUES (11, 10, 11, 1);
INSERT INTO attempt_question VALUES (12, 3, 4);
INSERT INTO attempt_option VALUES (12, 11, 12, 1);
INSERT INTO attempt VALUES (4, '2025-07-10', 4, 6.5);
INSERT INTO attempt_question VALUES (13, 4, 1);
INSERT INTO attempt_option VALUES (13, 3, 13, 1);
INSERT INTO attempt_question VALUES (14, 4, 2);
INSERT INTO attempt_option VALUES (14, 8, 14, 1);
INSERT INTO attempt_question VALUES (15, 4, 3);
INSERT INTO attempt_option VALUES (15, 10, 15, 1);
INSERT INTO attempt_question VALUES (16, 4, 4);
INSERT INTO attempt_option VALUES (16, 11, 16, 1);
INSERT INTO attempt VALUES (5, '2025-07-10', 5, 2.5);
INSERT INTO attempt_question VALUES (17, 5, 1);
INSERT INTO attempt_option VALUES (17, 3, 17, 1);
INSERT INTO attempt_question VALUES (18, 5, 2);
INSERT INTO attempt_option VALUES (18, 8, 18, 1);
INSERT INTO attempt_question VALUES (19, 5, 3);
INSERT INTO attempt_option VALUES (19, 10, 19, 1);
INSERT INTO attempt_question VALUES (20, 5, 4);
INSERT INTO attempt_option VALUES (20, 11, 20, 1);
INSERT INTO attempt VALUES (6, '2025-07-10', 6, 3.5);
INSERT INTO attempt_question VALUES (21, 6, 1);
INSERT INTO attempt_option VALUES (21, 3, 21, 1);
INSERT INTO attempt_question VALUES (22, 6, 2);
INSERT INTO attempt_option VALUES (22, 8, 22, 1);
INSERT INTO attempt_question VALUES (23, 6, 3);
INSERT INTO attempt_option VALUES (23, 10, 23, 1);
INSERT INTO attempt_question VALUES (24, 6, 4);
INSERT INTO attempt_option VALUES (24, 11, 24, 1);
INSERT INTO attempt VALUES (7, '2025-07-10', 7, 4.5);
INSERT INTO attempt_question VALUES (25, 7, 1);
INSERT INTO attempt_option VALUES (25, 3, 25, 1);
INSERT INTO attempt_question VALUES (26, 7, 2);
INSERT INTO attempt_option VALUES (26, 8, 26, 1);
INSERT INTO attempt_question VALUES (27, 7, 3);
INSERT INTO attempt_option VALUES (27, 10, 27, 1);
INSERT INTO attempt_question VALUES (28, 7, 4);
INSERT INTO attempt_option VALUES (28, 11, 28, 1);
INSERT INTO attempt VALUES (8, '2025-07-10', 8, 5.5);
INSERT INTO attempt_question VALUES (29, 8, 1);
INSERT INTO attempt_option VALUES (29, 3, 29, 1);
INSERT INTO attempt_question VALUES (30, 8, 2);
INSERT INTO attempt_option VALUES (30, 8, 30, 1);
INSERT INTO attempt_question VALUES (31, 8, 3);
INSERT INTO attempt_option VALUES (31, 10, 31, 1);
INSERT INTO attempt_question VALUES (32, 8, 4);
INSERT INTO attempt_option VALUES (32, 11, 32, 1);
INSERT INTO attempt VALUES (9, '2025-07-10', 9, 6.5);
INSERT INTO attempt_question VALUES (33, 9, 1);
INSERT INTO attempt_option VALUES (33, 3, 33, 1);
INSERT INTO attempt_question VALUES (34, 9, 2);
INSERT INTO attempt_option VALUES (34, 8, 34, 1);
INSERT INTO attempt_question VALUES (35, 9, 3);
INSERT INTO attempt_option VALUES (35, 10, 35, 1);
INSERT INTO attempt_question VALUES (36, 9, 4);
INSERT INTO attempt_option VALUES (36, 11, 36, 1);
INSERT INTO attempt VALUES (10, '2025-07-10', 10, 2.5);
INSERT INTO attempt_question VALUES (37, 10, 1);
INSERT INTO attempt_option VALUES (37, 3, 37, 1);
INSERT INTO attempt_question VALUES (38, 10, 2);
INSERT INTO attempt_option VALUES (38, 8, 38, 1);
INSERT INTO attempt_question VALUES (39, 10, 3);
INSERT INTO attempt_option VALUES (39, 10, 39, 1);
INSERT INTO attempt_question VALUES (40, 10, 4);
INSERT INTO attempt_option VALUES (40, 11, 40, 1);
INSERT INTO attempt VALUES (11, '2025-07-10', 11, 3.5);
INSERT INTO attempt_question VALUES (41, 11, 1);
INSERT INTO attempt_option VALUES (41, 3, 41, 1);
INSERT INTO attempt_question VALUES (42, 11, 2);
INSERT INTO attempt_option VALUES (42, 8, 42, 1);
INSERT INTO attempt_question VALUES (43, 11, 3);
INSERT INTO attempt_option VALUES (43, 10, 43, 1);
INSERT INTO attempt_question VALUES (44, 11, 4);
INSERT INTO attempt_option VALUES (44, 11, 44, 1);
INSERT INTO attempt VALUES (12, '2025-07-10', 12, 4.5);
INSERT INTO attempt_question VALUES (45, 12, 1);
INSERT INTO attempt_option VALUES (45, 3, 45, 1);
INSERT INTO attempt_question VALUES (46, 12, 2);
INSERT INTO attempt_option VALUES (46, 8, 46, 1);
INSERT INTO attempt_question VALUES (47, 12, 3);
INSERT INTO attempt_option VALUES (47, 10, 47, 1);
INSERT INTO attempt_question VALUES (48, 12, 4);
INSERT INTO attempt_option VALUES (48, 11, 48, 1);
INSERT INTO attempt VALUES (13, '2025-07-10', 13, 5.5);
INSERT INTO attempt_question VALUES (49, 13, 1);
INSERT INTO attempt_option VALUES (49, 3, 49, 1);
INSERT INTO attempt_question VALUES (50, 13, 2);
INSERT INTO attempt_option VALUES (50, 8, 50, 1);
INSERT INTO attempt_question VALUES (51, 13, 3);
INSERT INTO attempt_option VALUES (51, 10, 51, 1);
INSERT INTO attempt_question VALUES (52, 13, 4);
INSERT INTO attempt_option VALUES (52, 11, 52, 1);
INSERT INTO attempt VALUES (14, '2025-07-10', 14, 6.5);
INSERT INTO attempt_question VALUES (53, 14, 1);
INSERT INTO attempt_option VALUES (53, 3, 53, 1);
INSERT INTO attempt_question VALUES (54, 14, 2);
INSERT INTO attempt_option VALUES (54, 8, 54, 1);
INSERT INTO attempt_question VALUES (55, 14, 3);
INSERT INTO attempt_option VALUES (55, 10, 55, 1);
INSERT INTO attempt_question VALUES (56, 14, 4);
INSERT INTO attempt_option VALUES (56, 11, 56, 1);
INSERT INTO attempt VALUES (15, '2025-07-10', 15, 2.5);
INSERT INTO attempt_question VALUES (57, 15, 1);
INSERT INTO attempt_option VALUES (57, 3, 57, 1);
INSERT INTO attempt_question VALUES (58, 15, 2);
INSERT INTO attempt_option VALUES (58, 8, 58, 1);
INSERT INTO attempt_question VALUES (59, 15, 3);
INSERT INTO attempt_option VALUES (59, 10, 59, 1);
INSERT INTO attempt_question VALUES (60, 15, 4);
INSERT INTO attempt_option VALUES (60, 11, 60, 1);
INSERT INTO attempt VALUES (16, '2025-07-10', 16, 3.5);
INSERT INTO attempt_question VALUES (61, 16, 1);
INSERT INTO attempt_option VALUES (61, 3, 61, 1);
INSERT INTO attempt_question VALUES (62, 16, 2);
INSERT INTO attempt_option VALUES (62, 8, 62, 1);
INSERT INTO attempt_question VALUES (63, 16, 3);
INSERT INTO attempt_option VALUES (63, 10, 63, 1);
INSERT INTO attempt_question VALUES (64, 16, 4);
INSERT INTO attempt_option VALUES (64, 11, 64, 1);
INSERT INTO attempt VALUES (17, '2025-07-10', 17, 4.5);
INSERT INTO attempt_question VALUES (65, 17, 1);
INSERT INTO attempt_option VALUES (65, 3, 65, 1);
INSERT INTO attempt_question VALUES (66, 17, 2);
INSERT INTO attempt_option VALUES (66, 8, 66, 1);
INSERT INTO attempt_question VALUES (67, 17, 3);
INSERT INTO attempt_option VALUES (67, 10, 67, 1);
INSERT INTO attempt_question VALUES (68, 17, 4);
INSERT INTO attempt_option VALUES (68, 11, 68, 1);
INSERT INTO attempt VALUES (18, '2025-07-10', 18, 5.5);
INSERT INTO attempt_question VALUES (69, 18, 1);
INSERT INTO attempt_option VALUES (69, 3, 69, 1);
INSERT INTO attempt_question VALUES (70, 18, 2);
INSERT INTO attempt_option VALUES (70, 8, 70, 1);
INSERT INTO attempt_question VALUES (71, 18, 3);
INSERT INTO attempt_option VALUES (71, 10, 71, 1);
INSERT INTO attempt_question VALUES (72, 18, 4);
INSERT INTO attempt_option VALUES (72, 11, 72, 1);
INSERT INTO attempt VALUES (19, '2025-07-10', 19, 6.5);
INSERT INTO attempt_question VALUES (73, 19, 1);
INSERT INTO attempt_option VALUES (73, 3, 73, 1);
INSERT INTO attempt_question VALUES (74, 19, 2);
INSERT INTO attempt_option VALUES (74, 8, 74, 1);
INSERT INTO attempt_question VALUES (75, 19, 3);
INSERT INTO attempt_option VALUES (75, 10, 75, 1);
INSERT INTO attempt_question VALUES (76, 19, 4);
INSERT INTO attempt_option VALUES (76, 11, 76, 1);
INSERT INTO attempt VALUES (20, '2025-07-10', 20, 2.5);
INSERT INTO attempt_question VALUES (77, 20, 1);
INSERT INTO attempt_option VALUES (77, 3, 77, 1);
INSERT INTO attempt_question VALUES (78, 20, 2);
INSERT INTO attempt_option VALUES (78, 8, 78, 1);
INSERT INTO attempt_question VALUES (79, 20, 3);
INSERT INTO attempt_option VALUES (79, 10, 79, 1);
INSERT INTO attempt_question VALUES (80, 20, 4);
INSERT INTO attempt_option VALUES (80, 11, 80, 1);
INSERT INTO attempt VALUES (21, '2025-07-10', 21, 3.5);
INSERT INTO attempt_question VALUES (81, 21, 1);
INSERT INTO attempt_option VALUES (81, 3, 81, 1);
INSERT INTO attempt_question VALUES (82, 21, 2);
INSERT INTO attempt_option VALUES (82, 8, 82, 1);
INSERT INTO attempt_question VALUES (83, 21, 3);
INSERT INTO attempt_option VALUES (83, 10, 83, 1);
INSERT INTO attempt_question VALUES (84, 21, 4);
INSERT INTO attempt_option VALUES (84, 11, 84, 1);
INSERT INTO attempt VALUES (22, '2025-07-10', 22, 4.5);
INSERT INTO attempt_question VALUES (85, 22, 1);
INSERT INTO attempt_option VALUES (85, 3, 85, 1);
INSERT INTO attempt_question VALUES (86, 22, 2);
INSERT INTO attempt_option VALUES (86, 8, 86, 1);
INSERT INTO attempt_question VALUES (87, 22, 3);
INSERT INTO attempt_option VALUES (87, 10, 87, 1);
INSERT INTO attempt_question VALUES (88, 22, 4);
INSERT INTO attempt_option VALUES (88, 11, 88, 1);
INSERT INTO attempt VALUES (23, '2025-07-10', 23, 5.5);
INSERT INTO attempt_question VALUES (89, 23, 1);
INSERT INTO attempt_option VALUES (89, 3, 89, 1);
INSERT INTO attempt_question VALUES (90, 23, 2);
INSERT INTO attempt_option VALUES (90, 8, 90, 1);
INSERT INTO attempt_question VALUES (91, 23, 3);
INSERT INTO attempt_option VALUES (91, 10, 91, 1);
INSERT INTO attempt_question VALUES (92, 23, 4);
INSERT INTO attempt_option VALUES (92, 11, 92, 1);
INSERT INTO attempt VALUES (24, '2025-07-10', 24, 6.5);
INSERT INTO attempt_question VALUES (93, 24, 1);
INSERT INTO attempt_option VALUES (93, 3, 93, 1);
INSERT INTO attempt_question VALUES (94, 24, 2);
INSERT INTO attempt_option VALUES (94, 8, 94, 1);
INSERT INTO attempt_question VALUES (95, 24, 3);
INSERT INTO attempt_option VALUES (95, 10, 95, 1);
INSERT INTO attempt_question VALUES (96, 24, 4);
INSERT INTO attempt_option VALUES (96, 11, 96, 1);
INSERT INTO attempt VALUES (25, '2025-07-10', 25, 2.5);
INSERT INTO attempt_question VALUES (97, 25, 1);
INSERT INTO attempt_option VALUES (97, 3, 97, 1);
INSERT INTO attempt_question VALUES (98, 25, 2);
INSERT INTO attempt_option VALUES (98, 8, 98, 1);
INSERT INTO attempt_question VALUES (99, 25, 3);
INSERT INTO attempt_option VALUES (99, 10, 99, 1);
INSERT INTO attempt_question VALUES (100, 25, 4);
INSERT INTO attempt_option VALUES (100, 11, 100, 1);
INSERT INTO attempt VALUES (26, '2025-07-10', 26, 3.5);
INSERT INTO attempt_question VALUES (101, 26, 1);
INSERT INTO attempt_option VALUES (101, 3, 101, 1);
INSERT INTO attempt_question VALUES (102, 26, 2);
INSERT INTO attempt_option VALUES (102, 8, 102, 1);
INSERT INTO attempt_question VALUES (103, 26, 3);
INSERT INTO attempt_option VALUES (103, 10, 103, 1);
INSERT INTO attempt_question VALUES (104, 26, 4);
INSERT INTO attempt_option VALUES (104, 11, 104, 1);
INSERT INTO attempt VALUES (27, '2025-07-10', 27, 4.5);
INSERT INTO attempt_question VALUES (105, 27, 1);
INSERT INTO attempt_option VALUES (105, 3, 105, 1);
INSERT INTO attempt_question VALUES (106, 27, 2);
INSERT INTO attempt_option VALUES (106, 8, 106, 1);
INSERT INTO attempt_question VALUES (107, 27, 3);
INSERT INTO attempt_option VALUES (107, 10, 107, 1);
INSERT INTO attempt_question VALUES (108, 27, 4);
INSERT INTO attempt_option VALUES (108, 11, 108, 1);
INSERT INTO attempt VALUES (28, '2025-07-10', 28, 5.5);
INSERT INTO attempt_question VALUES (109, 28, 1);
INSERT INTO attempt_option VALUES (109, 3, 109, 1);
INSERT INTO attempt_question VALUES (110, 28, 2);
INSERT INTO attempt_option VALUES (110, 8, 110, 1);
INSERT INTO attempt_question VALUES (111, 28, 3);
INSERT INTO attempt_option VALUES (111, 10, 111, 1);
INSERT INTO attempt_question VALUES (112, 28, 4);
INSERT INTO attempt_option VALUES (112, 11, 112, 1);
INSERT INTO attempt VALUES (29, '2025-07-10', 29, 6.5);
INSERT INTO attempt_question VALUES (113, 29, 1);
INSERT INTO attempt_option VALUES (113, 3, 113, 1);
INSERT INTO attempt_question VALUES (114, 29, 2);
INSERT INTO attempt_option VALUES (114, 8, 114, 1);
INSERT INTO attempt_question VALUES (115, 29, 3);
INSERT INTO attempt_option VALUES (115, 10, 115, 1);
INSERT INTO attempt_question VALUES (116, 29, 4);
INSERT INTO attempt_option VALUES (116, 11, 116, 1);
INSERT INTO attempt VALUES (30, '2025-07-10', 30, 2.5);
INSERT INTO attempt_question VALUES (117, 30, 1);
INSERT INTO attempt_option VALUES (117, 3, 117, 1);
INSERT INTO attempt_question VALUES (118, 30, 2);
INSERT INTO attempt_option VALUES (118, 8, 118, 1);
INSERT INTO attempt_question VALUES (119, 30, 3);
INSERT INTO attempt_option VALUES (119, 10, 119, 1);
INSERT INTO attempt_question VALUES (120, 30, 4);
INSERT INTO attempt_option VALUES (120, 11, 120, 1);
INSERT INTO attempt VALUES (31, '2025-07-10', 31, 3.5);
INSERT INTO attempt_question VALUES (121, 31, 1);
INSERT INTO attempt_option VALUES (121, 3, 121, 1);
INSERT INTO attempt_question VALUES (122, 31, 2);
INSERT INTO attempt_option VALUES (122, 8, 122, 1);
INSERT INTO attempt_question VALUES (123, 31, 3);
INSERT INTO attempt_option VALUES (123, 10, 123, 1);
INSERT INTO attempt_question VALUES (124, 31, 4);
INSERT INTO attempt_option VALUES (124, 11, 124, 1);
INSERT INTO attempt VALUES (32, '2025-07-10', 32, 4.5);
INSERT INTO attempt_question VALUES (125, 32, 1);
INSERT INTO attempt_option VALUES (125, 3, 125, 1);
INSERT INTO attempt_question VALUES (126, 32, 2);
INSERT INTO attempt_option VALUES (126, 8, 126, 1);
INSERT INTO attempt_question VALUES (127, 32, 3);
INSERT INTO attempt_option VALUES (127, 10, 127, 1);
INSERT INTO attempt_question VALUES (128, 32, 4);
INSERT INTO attempt_option VALUES (128, 11, 128, 1);
INSERT INTO attempt VALUES (33, '2025-07-10', 33, 5.5);
INSERT INTO attempt_question VALUES (129, 33, 1);
INSERT INTO attempt_option VALUES (129, 3, 129, 1);
INSERT INTO attempt_question VALUES (130, 33, 2);
INSERT INTO attempt_option VALUES (130, 8, 130, 1);
INSERT INTO attempt_question VALUES (131, 33, 3);
INSERT INTO attempt_option VALUES (131, 10, 131, 1);
INSERT INTO attempt_question VALUES (132, 33, 4);
INSERT INTO attempt_option VALUES (132, 11, 132, 1);
INSERT INTO attempt VALUES (34, '2025-07-10', 34, 6.5);
INSERT INTO attempt_question VALUES (133, 34, 1);
INSERT INTO attempt_option VALUES (133, 3, 133, 1);
INSERT INTO attempt_question VALUES (134, 34, 2);
INSERT INTO attempt_option VALUES (134, 8, 134, 1);
INSERT INTO attempt_question VALUES (135, 34, 3);
INSERT INTO attempt_option VALUES (135, 10, 135, 1);
INSERT INTO attempt_question VALUES (136, 34, 4);
INSERT INTO attempt_option VALUES (136, 11, 136, 1);
INSERT INTO attempt VALUES (35, '2025-07-10', 35, 2.5);
INSERT INTO attempt_question VALUES (137, 35, 1);
INSERT INTO attempt_option VALUES (137, 3, 137, 1);
INSERT INTO attempt_question VALUES (138, 35, 2);
INSERT INTO attempt_option VALUES (138, 8, 138, 1);
INSERT INTO attempt_question VALUES (139, 35, 3);
INSERT INTO attempt_option VALUES (139, 10, 139, 1);
INSERT INTO attempt_question VALUES (140, 35, 4);
INSERT INTO attempt_option VALUES (140, 11, 140, 1);
INSERT INTO attempt VALUES (36, '2025-07-10', 36, 3.5);
INSERT INTO attempt_question VALUES (141, 36, 1);
INSERT INTO attempt_option VALUES (141, 3, 141, 1);
INSERT INTO attempt_question VALUES (142, 36, 2);
INSERT INTO attempt_option VALUES (142, 8, 142, 1);
INSERT INTO attempt_question VALUES (143, 36, 3);
INSERT INTO attempt_option VALUES (143, 10, 143, 1);
INSERT INTO attempt_question VALUES (144, 36, 4);
INSERT INTO attempt_option VALUES (144, 11, 144, 1);
INSERT INTO attempt VALUES (37, '2025-07-10', 37, 4.5);
INSERT INTO attempt_question VALUES (145, 37, 1);
INSERT INTO attempt_option VALUES (145, 3, 145, 1);
INSERT INTO attempt_question VALUES (146, 37, 2);
INSERT INTO attempt_option VALUES (146, 8, 146, 1);
INSERT INTO attempt_question VALUES (147, 37, 3);
INSERT INTO attempt_option VALUES (147, 10, 147, 1);
INSERT INTO attempt_question VALUES (148, 37, 4);
INSERT INTO attempt_option VALUES (148, 11, 148, 1);
INSERT INTO attempt VALUES (38, '2025-07-10', 38, 5.5);
INSERT INTO attempt_question VALUES (149, 38, 1);
INSERT INTO attempt_option VALUES (149, 3, 149, 1);
INSERT INTO attempt_question VALUES (150, 38, 2);
INSERT INTO attempt_option VALUES (150, 8, 150, 1);
INSERT INTO attempt_question VALUES (151, 38, 3);
INSERT INTO attempt_option VALUES (151, 10, 151, 1);
INSERT INTO attempt_question VALUES (152, 38, 4);
INSERT INTO attempt_option VALUES (152, 11, 152, 1);
INSERT INTO attempt VALUES (39, '2025-07-10', 39, 6.5);
INSERT INTO attempt_question VALUES (153, 39, 1);
INSERT INTO attempt_option VALUES (153, 3, 153, 1);
INSERT INTO attempt_question VALUES (154, 39, 2);
INSERT INTO attempt_option VALUES (154, 8, 154, 1);
INSERT INTO attempt_question VALUES (155, 39, 3);
INSERT INTO attempt_option VALUES (155, 10, 155, 1);
INSERT INTO attempt_question VALUES (156, 39, 4);
INSERT INTO attempt_option VALUES (156, 11, 156, 1);
INSERT INTO attempt VALUES (40, '2025-07-10', 40, 2.5);
INSERT INTO attempt_question VALUES (157, 40, 1);
INSERT INTO attempt_option VALUES (157, 3, 157, 1);
INSERT INTO attempt_question VALUES (158, 40, 2);
INSERT INTO attempt_option VALUES (158, 8, 158, 1);
INSERT INTO attempt_question VALUES (159, 40, 3);
INSERT INTO attempt_option VALUES (159, 10, 159, 1);
INSERT INTO attempt_question VALUES (160, 40, 4);
INSERT INTO attempt_option VALUES (160, 11, 160, 1);
INSERT INTO attempt VALUES (41, '2025-07-10', 41, 3.5);
INSERT INTO attempt_question VALUES (161, 41, 1);
INSERT INTO attempt_option VALUES (161, 3, 161, 1);
INSERT INTO attempt_question VALUES (162, 41, 2);
INSERT INTO attempt_option VALUES (162, 8, 162, 1);
INSERT INTO attempt_question VALUES (163, 41, 3);
INSERT INTO attempt_option VALUES (163, 10, 163, 1);
INSERT INTO attempt_question VALUES (164, 41, 4);
INSERT INTO attempt_option VALUES (164, 11, 164, 1);
INSERT INTO attempt VALUES (42, '2025-07-10', 42, 4.5);
INSERT INTO attempt_question VALUES (165, 42, 1);
INSERT INTO attempt_option VALUES (165, 3, 165, 1);
INSERT INTO attempt_question VALUES (166, 42, 2);
INSERT INTO attempt_option VALUES (166, 8, 166, 1);
INSERT INTO attempt_question VALUES (167, 42, 3);
INSERT INTO attempt_option VALUES (167, 10, 167, 1);
INSERT INTO attempt_question VALUES (168, 42, 4);
INSERT INTO attempt_option VALUES (168, 11, 168, 1);
INSERT INTO attempt VALUES (43, '2025-07-10', 43, 5.5);
INSERT INTO attempt_question VALUES (169, 43, 1);
INSERT INTO attempt_option VALUES (169, 3, 169, 1);
INSERT INTO attempt_question VALUES (170, 43, 2);
INSERT INTO attempt_option VALUES (170, 8, 170, 1);
INSERT INTO attempt_question VALUES (171, 43, 3);
INSERT INTO attempt_option VALUES (171, 10, 171, 1);
INSERT INTO attempt_question VALUES (172, 43, 4);
INSERT INTO attempt_option VALUES (172, 11, 172, 1);
INSERT INTO attempt VALUES (44, '2025-07-10', 44, 6.5);
INSERT INTO attempt_question VALUES (173, 44, 1);
INSERT INTO attempt_option VALUES (173, 3, 173, 1);
INSERT INTO attempt_question VALUES (174, 44, 2);
INSERT INTO attempt_option VALUES (174, 8, 174, 1);
INSERT INTO attempt_question VALUES (175, 44, 3);
INSERT INTO attempt_option VALUES (175, 10, 175, 1);
INSERT INTO attempt_question VALUES (176, 44, 4);
INSERT INTO attempt_option VALUES (176, 11, 176, 1);
INSERT INTO attempt VALUES (45, '2025-07-10', 45, 2.5);
INSERT INTO attempt_question VALUES (177, 45, 1);
INSERT INTO attempt_option VALUES (177, 3, 177, 1);
INSERT INTO attempt_question VALUES (178, 45, 2);
INSERT INTO attempt_option VALUES (178, 8, 178, 1);
INSERT INTO attempt_question VALUES (179, 45, 3);
INSERT INTO attempt_option VALUES (179, 10, 179, 1);
INSERT INTO attempt_question VALUES (180, 45, 4);
INSERT INTO attempt_option VALUES (180, 11, 180, 1);
INSERT INTO attempt VALUES (46, '2025-07-10', 46, 3.5);
INSERT INTO attempt_question VALUES (181, 46, 1);
INSERT INTO attempt_option VALUES (181, 3, 181, 1);
INSERT INTO attempt_question VALUES (182, 46, 2);
INSERT INTO attempt_option VALUES (182, 8, 182, 1);
INSERT INTO attempt_question VALUES (183, 46, 3);
INSERT INTO attempt_option VALUES (183, 10, 183, 1);
INSERT INTO attempt_question VALUES (184, 46, 4);
INSERT INTO attempt_option VALUES (184, 11, 184, 1);
INSERT INTO attempt VALUES (47, '2025-07-10', 47, 4.5);
INSERT INTO attempt_question VALUES (185, 47, 1);
INSERT INTO attempt_option VALUES (185, 3, 185, 1);
INSERT INTO attempt_question VALUES (186, 47, 2);
INSERT INTO attempt_option VALUES (186, 8, 186, 1);
INSERT INTO attempt_question VALUES (187, 47, 3);
INSERT INTO attempt_option VALUES (187, 10, 187, 1);
INSERT INTO attempt_question VALUES (188, 47, 4);
INSERT INTO attempt_option VALUES (188, 11, 188, 1);
INSERT INTO attempt VALUES (48, '2025-07-10', 48, 5.5);
INSERT INTO attempt_question VALUES (189, 48, 1);
INSERT INTO attempt_option VALUES (189, 3, 189, 1);
INSERT INTO attempt_question VALUES (190, 48, 2);
INSERT INTO attempt_option VALUES (190, 8, 190, 1);
INSERT INTO attempt_question VALUES (191, 48, 3);
INSERT INTO attempt_option VALUES (191, 10, 191, 1);
INSERT INTO attempt_question VALUES (192, 48, 4);
INSERT INTO attempt_option VALUES (192, 11, 192, 1);
INSERT INTO attempt VALUES (49, '2025-07-10', 49, 6.5);
INSERT INTO attempt_question VALUES (193, 49, 1);
INSERT INTO attempt_option VALUES (193, 3, 193, 1);
INSERT INTO attempt_question VALUES (194, 49, 2);
INSERT INTO attempt_option VALUES (194, 8, 194, 1);
INSERT INTO attempt_question VALUES (195, 49, 3);
INSERT INTO attempt_option VALUES (195, 10, 195, 1);
INSERT INTO attempt_question VALUES (196, 49, 4);
INSERT INTO attempt_option VALUES (196, 11, 196, 1);
INSERT INTO attempt VALUES (50, '2025-07-10', 50, 2.5);
INSERT INTO attempt_question VALUES (197, 50, 1);
INSERT INTO attempt_option VALUES (197, 3, 197, 1);
INSERT INTO attempt_question VALUES (198, 50, 2);
INSERT INTO attempt_option VALUES (198, 8, 198, 1);
INSERT INTO attempt_question VALUES (199, 50, 3);
INSERT INTO attempt_option VALUES (199, 10, 199, 1);
INSERT INTO attempt_question VALUES (200, 50, 4);
INSERT INTO attempt_option VALUES (200, 11, 200, 1);
INSERT INTO attempt VALUES (51, '2025-07-10', 51, 3.5);
INSERT INTO attempt_question VALUES (201, 51, 1);
INSERT INTO attempt_option VALUES (201, 3, 201, 1);
INSERT INTO attempt_question VALUES (202, 51, 2);
INSERT INTO attempt_option VALUES (202, 8, 202, 1);
INSERT INTO attempt_question VALUES (203, 51, 3);
INSERT INTO attempt_option VALUES (203, 10, 203, 1);
INSERT INTO attempt_question VALUES (204, 51, 4);
INSERT INTO attempt_option VALUES (204, 11, 204, 1);
INSERT INTO attempt VALUES (52, '2025-07-10', 52, 4.5);
INSERT INTO attempt_question VALUES (205, 52, 1);
INSERT INTO attempt_option VALUES (205, 3, 205, 1);
INSERT INTO attempt_question VALUES (206, 52, 2);
INSERT INTO attempt_option VALUES (206, 8, 206, 1);
INSERT INTO attempt_question VALUES (207, 52, 3);
INSERT INTO attempt_option VALUES (207, 10, 207, 1);
INSERT INTO attempt_question VALUES (208, 52, 4);
INSERT INTO attempt_option VALUES (208, 11, 208, 1);
INSERT INTO attempt VALUES (53, '2025-07-10', 53, 5.5);
INSERT INTO attempt_question VALUES (209, 53, 1);
INSERT INTO attempt_option VALUES (209, 3, 209, 1);
INSERT INTO attempt_question VALUES (210, 53, 2);
INSERT INTO attempt_option VALUES (210, 8, 210, 1);
INSERT INTO attempt_question VALUES (211, 53, 3);
INSERT INTO attempt_option VALUES (211, 10, 211, 1);
INSERT INTO attempt_question VALUES (212, 53, 4);
INSERT INTO attempt_option VALUES (212, 11, 212, 1);
INSERT INTO attempt VALUES (54, '2025-07-10', 54, 6.5);
INSERT INTO attempt_question VALUES (213, 54, 1);
INSERT INTO attempt_option VALUES (213, 3, 213, 1);
INSERT INTO attempt_question VALUES (214, 54, 2);
INSERT INTO attempt_option VALUES (214, 8, 214, 1);
INSERT INTO attempt_question VALUES (215, 54, 3);
INSERT INTO attempt_option VALUES (215, 10, 215, 1);
INSERT INTO attempt_question VALUES (216, 54, 4);
INSERT INTO attempt_option VALUES (216, 11, 216, 1);
INSERT INTO attempt VALUES (55, '2025-07-10', 55, 2.5);
INSERT INTO attempt_question VALUES (217, 55, 1);
INSERT INTO attempt_option VALUES (217, 3, 217, 1);
INSERT INTO attempt_question VALUES (218, 55, 2);
INSERT INTO attempt_option VALUES (218, 8, 218, 1);
INSERT INTO attempt_question VALUES (219, 55, 3);
INSERT INTO attempt_option VALUES (219, 10, 219, 1);
INSERT INTO attempt_question VALUES (220, 55, 4);
INSERT INTO attempt_option VALUES (220, 11, 220, 1);
INSERT INTO attempt VALUES (56, '2025-07-10', 56, 3.5);
INSERT INTO attempt_question VALUES (221, 56, 1);
INSERT INTO attempt_option VALUES (221, 3, 221, 1);
INSERT INTO attempt_question VALUES (222, 56, 2);
INSERT INTO attempt_option VALUES (222, 8, 222, 1);
INSERT INTO attempt_question VALUES (223, 56, 3);
INSERT INTO attempt_option VALUES (223, 10, 223, 1);
INSERT INTO attempt_question VALUES (224, 56, 4);
INSERT INTO attempt_option VALUES (224, 11, 224, 1);
INSERT INTO attempt VALUES (57, '2025-07-10', 57, 4.5);
INSERT INTO attempt_question VALUES (225, 57, 1);
INSERT INTO attempt_option VALUES (225, 3, 225, 1);
INSERT INTO attempt_question VALUES (226, 57, 2);
INSERT INTO attempt_option VALUES (226, 8, 226, 1);
INSERT INTO attempt_question VALUES (227, 57, 3);
INSERT INTO attempt_option VALUES (227, 10, 227, 1);
INSERT INTO attempt_question VALUES (228, 57, 4);
INSERT INTO attempt_option VALUES (228, 11, 228, 1);
INSERT INTO attempt VALUES (58, '2025-07-10', 58, 5.5);
INSERT INTO attempt_question VALUES (229, 58, 1);
INSERT INTO attempt_option VALUES (229, 3, 229, 1);
INSERT INTO attempt_question VALUES (230, 58, 2);
INSERT INTO attempt_option VALUES (230, 8, 230, 1);
INSERT INTO attempt_question VALUES (231, 58, 3);
INSERT INTO attempt_option VALUES (231, 10, 231, 1);
INSERT INTO attempt_question VALUES (232, 58, 4);
INSERT INTO attempt_option VALUES (232, 11, 232, 1);
INSERT INTO attempt VALUES (59, '2025-07-10', 59, 6.5);
INSERT INTO attempt_question VALUES (233, 59, 1);
INSERT INTO attempt_option VALUES (233, 3, 233, 1);
INSERT INTO attempt_question VALUES (234, 59, 2);
INSERT INTO attempt_option VALUES (234, 8, 234, 1);
INSERT INTO attempt_question VALUES (235, 59, 3);
INSERT INTO attempt_option VALUES (235, 10, 235, 1);
INSERT INTO attempt_question VALUES (236, 59, 4);
INSERT INTO attempt_option VALUES (236, 11, 236, 1);
INSERT INTO attempt VALUES (60, '2025-07-10', 60, 2.5);
INSERT INTO attempt_question VALUES (237, 60, 1);
INSERT INTO attempt_option VALUES (237, 3, 237, 1);
INSERT INTO attempt_question VALUES (238, 60, 2);
INSERT INTO attempt_option VALUES (238, 8, 238, 1);
INSERT INTO attempt_question VALUES (239, 60, 3);
INSERT INTO attempt_option VALUES (239, 10, 239, 1);
INSERT INTO attempt_question VALUES (240, 60, 4);
INSERT INTO attempt_option VALUES (240, 11, 240, 1);

