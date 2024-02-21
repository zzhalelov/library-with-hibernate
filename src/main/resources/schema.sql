CREATE TABLE books
(
    id     SERIAL PRIMARY KEY,
    title  VARCHAR,
    author VARCHAR,
    genre  VARCHAR
);
CREATE TABLE readers
(
    id   INT PRIMARY KEY,
    name VARCHAR
);