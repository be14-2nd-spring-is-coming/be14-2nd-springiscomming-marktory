DROP TABLE IF EXISTS member;

CREATE TABLE member (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      nickname VARCHAR(255) NOT NULL,
                      birthday VARCHAR(255) NOT NULL,
                      image VARCHAR(255),
                      status VARCHAR(255) NOT NULL DEFAULT 'is_active',
                      black_date VARCHAR(255),
                      assigned_date VARCHAR(255) NOT NULL,
                      delete_date VARCHAR(255),
                      report_count INT DEFAULT 0,
                      is_terms BOOLEAN NOT NULL,
                      UNIQUE(email),
                      UNIQUE(nickname),
                      CHECK ( status in ('is_active', 'is_delete', 'is_black') )
) ENGINE = INNODB;
