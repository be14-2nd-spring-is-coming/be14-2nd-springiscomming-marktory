DROP TABLE IF EXISTS report;

CREATE TABLE report (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        content VARCHAR(255) NOT NULL,
                        status BOOLEAN NOT NULL DEFAULT FALSE,
                        date VARCHAR(255) NOT NULL,
                        type VARCHAR(255) NOT NULL,
                        member_id BIGINT NOT NULL,
                        comment_id BIGINT,
                        post_id BIGINT,
                        template_id BIGINT,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                        CHECK ( type in ('comment','post','template') ),
                        CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id),
                        CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                        CONSTRAINT FOREIGN KEY (template_id) REFERENCES member_template(id)
) ENGINE = INNODB;
