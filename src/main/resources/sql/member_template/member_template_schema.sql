CREATE TABLE member_template(
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                title VARCHAR(255) NOT NULL,
                                content VARCHAR(255) NOT NULL,
                                visibility VARCHAR(255) NOT NULL,
                                written_date VARCHAR(255) NOT NULL,
                                delete_date VARCHAR(255),
                                usage_count INT NOT NULL DEFAULT 0,
                                is_copy CHAR NOT NULL DEFAULT 'N',
                                repository_id INT,
                                CONSTRAINT FOREIGN KEY (repository_id) REFERENCES template_space(id),
                                CHECK ( visibility IN ('public','private','subonly') ),
                                CHECK ( is_copy IN ('Y','N'))
) ENGINE = INNODB;