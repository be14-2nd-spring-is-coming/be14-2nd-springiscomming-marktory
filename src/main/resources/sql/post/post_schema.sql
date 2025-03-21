DROP TABLE IF EXISTS post;

CREATE TABLE post (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content LONGTEXT NOT NULL,
    written_date VARCHAR(255) NOT NULL,
    delete_date VARCHAR(255),
    visibility VARCHAR(255) NOT NULL DEFAULT 'public',
    member_id INT,
    category_id INT,
    CHECK ( visibility IN ('public', 'private', 'subonly')),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
    CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL
) ENGINE = INNODB;