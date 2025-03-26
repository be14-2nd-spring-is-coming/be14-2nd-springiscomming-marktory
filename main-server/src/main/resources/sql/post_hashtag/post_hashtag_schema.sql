DROP TABLE IF EXISTS post_hashtag;

CREATE TABLE post_hashtag (
    post_id INT NOT NULL,
    hashtag_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
    CONSTRAINT FOREIGN KEY (hashtag_id) REFERENCES hashtag(id)
) ENGINE = INNODB;