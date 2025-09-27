CREATE TABLE IF NOT EXISTS Login (
    id varchar(255) NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL,
    password_hash int NOT NULL
);

CREATE TABLE IF NOT EXISTS Member (
    id varchar(255) NOT NULL REFERENCES Login(id),
    name varchar(255) NOT NULL
);

