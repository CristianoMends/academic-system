CREATE TABLE if not exists users (
  user_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   surname VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   course_name VARCHAR(255),
   start_date date,
   registration_date date,
   last_access_date date,
   permissions VARCHAR(255),
   course_id BIGINT,
   CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_COURSE FOREIGN KEY (course_id) REFERENCES course (course_id);