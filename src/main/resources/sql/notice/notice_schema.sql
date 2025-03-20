DROP TABLE IF EXISTS notice;

CREATE TABLE notice (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        date VARCHAR(255) NOT NULL,
                        content VARCHAR(255) NOT NULL,
                        member_id INT,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;