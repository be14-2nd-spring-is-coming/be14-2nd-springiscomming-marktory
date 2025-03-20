DROP TABLE IF EXISTS likes;

CREATE TABLE likes (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       type VARCHAR(255) NOT NULL,
                       post_id INT,
                       comment_id INT,
                       CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                       CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id)
) ENGINE = INNODB;