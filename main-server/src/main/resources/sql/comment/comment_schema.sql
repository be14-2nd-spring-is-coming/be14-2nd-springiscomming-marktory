DROP TABLE IF EXISTS comment;

CREATE TABLE comment
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    content      VARCHAR(255) NOT NULL,
    written_date VARCHAR(255) NOT NULL,
    modify_date  VARCHAR(255),
    is_deleted   BOOLEAN NOT NULL DEFAULT false,
    type         INT NOT NULL DEFAULT 1,
    above_id     INT,
    member_id    INT,
    post_id      INT,
    CHECK ( type IN (1, 2) ),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member (id)
) ENGINE = INNODB;