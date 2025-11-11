CREATE TABLE IF NOT EXISTS Login (
    id varchar(255) NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL UNIQUE,
    password_hash int NOT NULL
);

CREATE TABLE IF NOT EXISTS Member (
    id varchar(255) NOT NULL REFERENCES Login(id),
    username varchar(255) NOT NULL REFERENCES Login(username),
    name varchar(255) NOT NULL,
    height double NOT NULL,
    weight double NOT NULL,
    sex varchar(255) NOT NULL,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS POST (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    AUTHOR_ID varchar(255) NOT NULL REFERENCES Login(username),
    CONTENT varchar(1000) NOT NULL,
    LIKES int NOT NULL,
    COMMENTS int NOT NULL
);

CREATE TABLE IF NOT EXISTS COMMENT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    POST_ID BIGINT NOT NULL REFERENCES Post(ID),
    AUTHOR_ID varchar(255) NOT NULL REFERENCES login(username),
    CONTENT varchar(1000) NOT NULL,
    LIKES int NOT NULL
);

INSERT INTO Login (id, username, password_hash) VALUES ('kyletruong2000@gmail.com', 'KT-243', -1941214078);
INSERT INTO Member(id, username, name, height, weight, sex) VALUES ('kyletruong2000@gmail.com','KT-243', 'Kyle Truong', 5.9, 145.5, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('itzcoatlsun@gmail.com','itzcoatl262', 1549419726);
INSERT INTO Member(id, username, name, height, weight, sex) VALUES ('itzcoatlsun@gmail.com','itzcoatl262','Izzy Tellez', 6.0, 185, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('brandonhcontreras@gmail.com', 'niv0id2004', -2038099704);
INSERT INTO Member(id, username, name, height, weight, sex) VALUES('brandonhcontreras@gmail.com','niv0id2004', 'Brandon Contreras', 5.8, 165.0, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('vchavez8500@gmail.com', 'vmchavez00', 1843501453);
INSERT INTO Member(id, username, name, height, weight, sex) VALUES ('vchavez8500@gmail.com','vmchavez00', 'Valerie Chavez', 5.1, 110, 'female');

INSERT INTO Login(id, username, password_hash) VALUES ('maliyaleann@gmail.com', 'mc2003', -1757133414);
INSERT INTO Member(id, username, name, height, weight, sex) VALUES('maliyaleann@gmail.com','mc2003', 'Maliya Cockrell', 5.3, 113, 'female');

INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES,  COMMENTS) VALUES('mc2003', 'Marvel Rivals is so fun', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES,  COMMENTS) VALUES('vmchavez00','Best Buy is the best place to work for', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES,  COMMENTS) VALUES('mc2003', 'Thank god I listened to Kyle and bought Yakuza 0, it is the best game ever', '0','0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES,  COMMENTS) VALUES('vmchavez00', 'I wish I didnt buy a mac', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES,  COMMENTS) VALUES('mc2003', 'AI can draw better than me', '0', '0');

INSERT INTO COMMENT(POST_ID, AUTHOR_ID, CONTENT, LIKES) VALUES('3','vmchavez00', 'Yeah Kyle always know best', '0');
INSERT INTO COMMENT(POST_ID, AUTHOR_ID, CONTENT, LIKES) VALUES('3', 'itzcoatl262', 'Glad you listened to him', '0');