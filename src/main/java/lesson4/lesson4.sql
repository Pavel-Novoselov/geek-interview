DROP SCHEMA if EXISTS cinema;
CREATE SCHEMA cinema;

DROP TABLE if EXISTS cinema.films;
CREATE TABLE cinema.films (
    id               INT NOT NULL AUTO_INCREMENT,
    title            VARCHAR(256),
    duration         INT,
    PRIMARY KEY (id)
);

DROP TABLE if EXISTS cinema.seances;
CREATE TABLE cinema.seances (
    id               INT NOT NULL AUTO_INCREMENT,
    start_time       DATETIME,
    film_id          INT,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES films (id)
);

DROP TABLE if EXISTS cinema.tickets;
CREATE TABLE cinema.tickets (
    id               INT NOT NULL AUTO_INCREMENT,
    seance_id        INT,
    price            DECIMAL,
    PRIMARY KEY (id),
    FOREIGN KEY (seance_id) REFERENCES seances (id)
);

INSERT into cinema.films VALUES (1, "Kino-1", 60), (2, "Kino-2", 90), (3, "Kino-3", 120);
INSERT into cinema.seances VALUES (1, "2021-05-25 10:00:00" 1),
(2, "2021-05-25 13:00:00" 2),
(3, "2021-05-25 16:00:00" 3),
(4, "2021-05-25 17:30:00" 1);
INSERT into cinema.tickets VALUES (1, 1, 100.00), (2, 2, 150.00), (3, 3, 120.00), (4, 4, 200.00);

-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2»,
-- «время начала», «длительность»

SELECT I1.title, I1.start_time, I1.end_time,
    I2.title, I2.start_time, I2.end_time
FROM (SELECT
          A.film_id,
          A.start_time,
          A.id as seance_id,
          B.duration,
          B.title,
          date_add(A.start_time, INTERVAL B.duration MINUTE) as end_time
      FROM cinema.seances A
               INNER JOIN cinema.films B
      ON A.film_id = B.id) as I1
         INNER JOIN (SELECT
                         A.film_id,
                         A.start_time,
                         A.id as seance_id,
                         B.duration,
                         B.title,
                         date_add(A.start_time, INTERVAL B.duration MINUTE) as end_time
                     FROM cinema.seances A
                              INNER JOIN cinema.films B
                     ON A.film_id = B.id) as I2
             ON I1.start_time < I2.end_time AND I1.end_time > I2.start_time
    AND I1.seance_id != I2.seance_id AND I1.seance_id > I2.seance_id;
--
-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT I1.title, I1.start_time, I1.duration, I2.start_time, I2.break
FROM (SELECT
          A.film_id,
          A.start_time,
          A.id as seance_id,
          B.duration,
          B.title,
          date_add(A.start_time, INTERVAL B.duration MINUTE) as end_time,
          date_sub(end_time, INTERVAL A.start_time) as break
      FROM cinema.seances A
               INNER JOIN cinema.films B
      ON A.film_id = B.id) as I1
         INNER JOIN (SELECT
                         A.film_id,
                         A.start_time,
                         A.id as seance_id,
                         B.duration,
                         B.title,
                         date_add(A.start_time, INTERVAL B.duration MINUTE) as end_time,
                         date_sub(end_time, INTERVAL A.start_time) as break
                     FROM cinema.seances A
                              INNER JOIN cinema.films B
                     ON A.film_id = B.id) as I2
ON (I1.break > 30 OR I2.break > 30) AND I1.seance_id != I2.seance_id AND I1.seance_id > I2.seance_id;



