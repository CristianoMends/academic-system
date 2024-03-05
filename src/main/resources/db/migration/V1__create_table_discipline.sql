CREATE TABLE if not exists disciplines (
  discipline_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   time VARCHAR(255),
   day VARCHAR(255),
   place VARCHAR(255),
   status VARCHAR(255),
   grade FLOAT,
   CONSTRAINT pk_disciplines PRIMARY KEY (discipline_id)
);