-- SOME USERS
INSERT INTO USER
  (NAME, PASSWORD, ANONYMOUS)
VALUES
  ('user1', 'user1', FALSE);

INSERT INTO USER
  (NAME, PASSWORD, ANONYMOUS)
VALUES
  ('user2', 'user2', FALSE);

-- SOME CHATROOMS
INSERT INTO CHATROOM
  (NAME, DESCRIPTION)
VALUES
  ('Flood', 'Anything about everything...');

INSERT INTO CHATROOM
(NAME, DESCRIPTION)
VALUES
  ('Music', 'Anything about music...');

INSERT INTO CHATROOM
  (NAME, DESCRIPTION)
VALUES
  ('Programming', 'Anything about programming...');

INSERT INTO CHATROOM
  (NAME, DESCRIPTION)
VALUES
  ('Cars', 'Anything about cars...');

-- SOME MESSAGES
INSERT INTO MESSAGE
  (CHATROOM_ID, USER_ID, DATE_SENT, SUBJECT, CONTENT)
VALUES
  (1, 1, CURRENT_TIMESTAMP, 'flood1', 'flood1');

INSERT INTO MESSAGE
  (CHATROOM_ID, USER_ID, DATE_SENT, SUBJECT, CONTENT)
VALUES
  (1, 2, CURRENT_TIMESTAMP, 'flood2', 'flood2');

INSERT INTO MESSAGE
  (CHATROOM_ID, USER_ID, DATE_SENT, SUBJECT, CONTENT)
VALUES
  (1, 1, CURRENT_TIMESTAMP, '=)', 'dvkdvf');