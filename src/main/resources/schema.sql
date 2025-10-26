CREATE TABLE IF NOT EXISTS Login (
    id varchar(255) NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL UNIQUE,
    password_hash int NOT NULL
);

CREATE TABLE IF NOT EXISTS Member (
    id varchar(255) NOT NULL REFERENCES Login(id),
    name varchar(255) NOT NULL,
    height double NOT NULL,
    weight double NOT NULL,
    sex varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS POST (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    AUTHOR_ID varchar(255) NOT NULL REFERENCES Login(username),
    CONTENT varchar(1000) NOT NULL,
    LIKES int NOT NULL,
    DISLIKES int NOT NULL,
    COMMENTS int NOT NULL
);

CREATE TABLE IF NOT EXISTS COMMENT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    POST_ID BIGINT NOT NULL REFERENCES Post(ID),
    CONTENT varchar(1000) NOT NULL,
    LIKES int NOT NULL,
    DISLIKES int NOT NULL
);

INSERT INTO Login (id, username, password_hash) VALUES ('kyletruong2000@gmail.com', 'KT-243', -1941214078);
INSERT INTO Member(id, name, height, weight, sex) VALUES ('kyletruong2000@gmail.com', 'Kyle Truong', 5.9, 145.5, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('itzcoatlsun@gmail.com','itzcoatl262', 1549419726);
INSERT INTO Member(id, name, height, weight, sex) VALUES ('itzcoatlsun@gmail.com','Izzy Tellez', 6.0, 185, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('brandonhcontreras@gmail.com', 'niv0id2004', -2038099704);
INSERT INTO Member(id, name, height, weight, sex) VALUES('brandonhcontreras@gmail.com', 'Brandon Contreras', 5.8, 165.0, 'male');

INSERT INTO Login(id, username, password_hash) VALUES ('vchavez8500@gmail.com', 'vmchavez00', 1843501453);
INSERT INTO Member(id, name, height, weight, sex) VALUES ('vchavez8500@gmail.com', 'Valerie Chavez', 5.1, 110, 'female');

INSERT INTO Login(id, username, password_hash) VALUES ('maliyaleann@gmail.com', 'mc2003', -1757133414);
INSERT INTO Member(id, name, height, weight, sex) VALUES('maliyaleann@gmail.com', 'Maliya Cockrell', 5.3, 113, 'female');

INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES, DISLIKES, COMMENTS) VALUES('mc2003', 'I hate minorities', '0', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES, DISLIKES, COMMENTS) VALUES('vmchavez00','repeal the 19th', '0', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES, DISLIKES, COMMENTS) VALUES('mc2003', 'They need to go back', '0','0','0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES, DISLIKES, COMMENTS) VALUES('vmchavez00', 'women deserve less', '0', '0', '0');
INSERT INTO POST(AUTHOR_ID, CONTENT, LIKES, DISLIKES, COMMENTS) VALUES('mc2003', 'go back to the kitchen', '0', '0', '0');