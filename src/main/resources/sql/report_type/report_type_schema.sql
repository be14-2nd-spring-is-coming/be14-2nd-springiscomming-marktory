DROP TABLE IF EXISTS report_type;

CREATE TABLE report_type (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             report_id INT NOT NULL,
                             comment_id INT,
                             post_id INT,
                             template_id INT,
                             CONSTRAINT FOREIGN KEY (report_id) REFERENCES report(id),
                             CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id),
                             CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                             CONSTRAINT FOREIGN KEY (template_id) REFERENCES template(id)
) ENGINE = INNODB;