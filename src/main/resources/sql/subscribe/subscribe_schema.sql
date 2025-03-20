DROP TABLE IF EXISTS subscribe;

CREATE TABLE subscribe (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           is_notification CHAR NOT NULL,
                           subscriber_id INT,
                           subscribed_id INT,
                           CHECK ( is_notification in ('Y', 'N') ),
                           CONSTRAINT FOREIGN KEY (subscriber_id) REFERENCES member(id),
                           CONSTRAINT FOREIGN KEY (subscribed_id) REFERENCES member(id),
                           UNIQUE(subscriber_id, subscribed_id)
) ENGINE = INNODB;