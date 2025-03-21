DROP TABLE IF EXISTS member_profile_image;

CREATE TABLE member_profile_image (
    member_id INT PRIMARY KEY,
    id INT NOT NULL AUTO_INCREMENT,
    URL VARCHAR(255),
    UNIQUE(id),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;