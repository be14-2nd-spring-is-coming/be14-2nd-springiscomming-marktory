DROP TABLE IF EXISTS likes;

CREATE TABLE likes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL,
    post_id INT,
    comment_id INT,
    member_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
    CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
    UNIQUE (member_id, post_id, type),
    UNIQUE (member_id, comment_id, type)
) ENGINE = INNODB;