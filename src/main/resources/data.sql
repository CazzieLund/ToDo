
INSERT INTO board (id, name) VALUES (1, 'Project Alpha');
INSERT INTO board (id, name) VALUES (2, 'Website Redesign');
INSERT INTO board (id, name) VALUES (3, 'Personal Tasks');

INSERT INTO board_column (id, name, board_id) VALUES (1, 'Todo', 1);
INSERT INTO board_column (id, name, board_id) VALUES (2, 'In Progress', 1);
INSERT INTO board_column (id, name, board_id) VALUES (3, 'Done', 1);

INSERT INTO board_column (id, name, board_id) VALUES (4, 'Todo', 2);
INSERT INTO board_column (id, name, board_id) VALUES (5, 'In Progress', 2);
INSERT INTO board_column (id, name, board_id) VALUES (6, 'Done', 2);

INSERT INTO board_column (id, name, board_id) VALUES (7, 'Todo', 3);
INSERT INTO board_column (id, name, board_id) VALUES (8, 'In Progress', 3);
INSERT INTO board_column (id, name, board_id) VALUES (9, 'Done', 3);

INSERT INTO task (id, name, description, column_id) VALUES
(1, 'Setup repo', 'Initialize git repository', 1),
(2, 'Create entities', 'Implement Board, Column, Task entities', 1),
(3, 'Implement API', 'Create controllers and services', 2),
(4, 'Write documentation', 'Add Swagger documentation', 3),

(5, 'Design homepage', 'Create Figma layout', 4),
(6, 'Implement navbar', 'Build responsive navbar', 5),
(7, 'Deploy site', 'Deploy to production', 6),

(8, 'Buy groceries', 'Milk, bread, eggs', 7),
(9, 'Clean apartment', 'Vacuum and dust', 8),
(10, 'Read book', 'Finish current novel', 9);