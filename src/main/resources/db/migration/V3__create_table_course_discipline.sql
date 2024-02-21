CREATE TABLE courses_disciplines (
  course_id BIGINT NOT NULL,
   discipline_id BIGINT NOT NULL,
   CONSTRAINT pk_courses_disciplines PRIMARY KEY (course_id, discipline_id),
   CONSTRAINT fk_coudis_on_course FOREIGN KEY (course_id) REFERENCES course (course_id),
   CONSTRAINT fk_coudis_on_disciplines FOREIGN KEY (discipline_id) REFERENCES disciplines (discipline_id)
);