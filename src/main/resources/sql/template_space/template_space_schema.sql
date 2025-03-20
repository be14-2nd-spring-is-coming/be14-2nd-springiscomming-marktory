DROP TABLE IF EXISTS template_space;

CREATE TABLE template_space(
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               member_id INT NOT NULL,
                               CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;
