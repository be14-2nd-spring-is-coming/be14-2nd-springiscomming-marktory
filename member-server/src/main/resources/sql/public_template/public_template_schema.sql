DROP TABLE IF EXISTS public_template;

CREATE TABLE public_template (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    written_date VARCHAR(255) NOT NULL,
    delete_date VARCHAR(255),
    usage_count INT NOT NULL DEFAULT 0,
    writer_id INT NOT NULL
) ENGINE = INNODB;