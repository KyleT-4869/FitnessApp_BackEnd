CREATE TABLE IF NOT EXISTS Login (
    id varchar(255) NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL,
    password_hash int NOT NULL
);

CREATE TABLE IF NOT EXISTS Member (
    id varchar(255) NOT NULL REFERENCES Login(id),
    name varchar(255) NOT NULL,
    height double NOT NULL,
    weight double NOT NULL,
    sex varchar(255) NOT NULL
);

INSERT INTO Login (id, username, password_hash) VALUES ('kyletruong2000@gmail.com', 'KT-243', -1941214078);
INSERT INTO Member(id, name, height, weight, sex) VALUES ('kyletruong2000@gmail.com', 'Kyle Truong', 5.9, 145.5, 'male');
