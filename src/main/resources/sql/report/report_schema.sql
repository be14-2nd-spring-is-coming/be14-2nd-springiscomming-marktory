DROP TABLE IF EXISTS report;

CREATE TABLE report (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        content VARCHAR(255) NOT NULL,
                        status BOOLEAN NOT NULL DEFAULT FALSE,
                        date VARCHAR(255) NOT NULL,
                        member_id INT NOT NULL,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;