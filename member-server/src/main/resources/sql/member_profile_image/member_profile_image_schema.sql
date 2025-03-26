DROP TABLE IF EXISTS member_profile_image;

CREATE TABLE member_profile_image (
    member_id INT PRIMARY KEY,
    URL VARCHAR(255),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;