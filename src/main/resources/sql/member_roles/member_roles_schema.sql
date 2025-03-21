DROP TABLE IF EXISTS member_roles;

CREATE TABLE member_roles(
    member_id INT PRIMARY KEY,
    authority_id INT,
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
    CONSTRAINT FOREIGN KEY (authority_id) REFERENCES authority(id)
) ENGINE = INNODB;