CREATE TABLE if not exists users_disciplines (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   user_id BIGINT,
   discipline_id BIGINT,
   CONSTRAINT pk_usersdisciplines PRIMARY KEY (id)
);

ALTER TABLE if exists users_disciplines ADD CONSTRAINT FK_USERSDISCIPLINES_ON_DISCIPLINE FOREIGN KEY (discipline_id) REFERENCES disciplines (discipline_id);

ALTER TABLE if exists users_disciplines ADD CONSTRAINT FK_USERSDISCIPLINES_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);