# ---------------------------------------------------- 테이블 삭제 ------------------------------------
DROP TABLE IF EXISTS report_type;
DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post_hashtag;
DROP TABLE IF EXISTS hashtag;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS member_template;
DROP TABLE IF EXISTS public_template;
DROP TABLE IF EXISTS template_space;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS member_roles;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS notice;
DROP TABLE IF EXISTS member_profile_image;
DROP TABLE IF EXISTS subscribe;
DROP TABLE IF EXISTS member;

# ---------------------------------------------------- 테이블 생성 ------------------------------------

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

CREATE TABLE member_profile_image (
                                    member_id INT PRIMARY KEY,
                                    id INT NOT NULL AUTO_INCREMENT,
                                    URL VARCHAR(255),
                                    UNIQUE(id),
                                    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE notice (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        date VARCHAR(255) NOT NULL,
                        content VARCHAR(255) NOT NULL,
                        member_id INT,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE authority (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name varchar(255) NOT NULL
) ENGINE = INNODB;

CREATE TABLE member_roles(
                           member_id INT PRIMARY KEY,
                           authority_id INT,
                           CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                           CONSTRAINT FOREIGN KEY (authority_id) REFERENCES authority(id)
) ENGINE = INNODB;

CREATE TABLE category (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          member_id INT,
                          CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE template_repository(
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    title VARCHAR(255) NOT NULL,
                                    member_id INT NOT NULL,
                                    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE template (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          title VARCHAR(255) NOT NULL,
                          content LONGTEXT NOT NULL,
                          written_date VARCHAR(255) NOT NULL,
                          delete_date VARCHAR(255),
                          usage_count INT NOT NULL DEFAULT 0,
                          writer_id INT NOT NULL
) ENGINE = INNODB;

CREATE TABLE member_template(
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              title VARCHAR(255) NOT NULL,
                              content LONGTEXT NOT NULL,
                              visibility VARCHAR(255) NOT NULL DEFAULT 'public',
                              written_date VARCHAR(255) NOT NULL,
                              delete_date VARCHAR(255),
                              usage_count INT NOT NULL DEFAULT 0,
                              is_copy CHAR NOT NULL DEFAULT 'N',
                              repository_id INT,
                              CONSTRAINT FOREIGN KEY (repository_id) REFERENCES template_repository(id),
                              CHECK ( visibility IN ('public','private','subonly') ),
                              CHECK ( is_copy IN ('Y','N'))
) ENGINE = INNODB;

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
                      CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE = INNODB;

CREATE TABLE hashtag (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
) ENGINE = INNODB;

CREATE TABLE post_hashtag (
                              post_id INT NOT NULL,
                              hashtag_id INT NOT NULL,
                              CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                              CONSTRAINT FOREIGN KEY (hashtag_id) REFERENCES hashtag(id)
) ENGINE = INNODB;

CREATE TABLE report (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        content VARCHAR(255) NOT NULL,
                        status BOOLEAN NOT NULL DEFAULT FALSE,
                        date VARCHAR(255) NOT NULL,
                        member_id INT NOT NULL,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE comment
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    content      VARCHAR(255) NOT NULL,
    written_date VARCHAR(255) NOT NULL,
    modify_date  VARCHAR(255),
    is_deleted   BOOLEAN NOT NULL DEFAULT false,
    type         INT NOT NULL DEFAULT 1,
    above_id     INT,
    member_id      INT,
    post_id      INT,
    CHECK ( type IN (1, 2) ),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member (id)
) ENGINE = INNODB;

CREATE TABLE likes (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       type VARCHAR(255) NOT NULL,
                       post_id INT,
                       comment_id INT,
                       CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                       CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id)
) ENGINE = INNODB;

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
