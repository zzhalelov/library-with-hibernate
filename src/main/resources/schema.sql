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
CREATE TABLE books_on_hand
(
    id          SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books (id),
    reader_id   INT REFERENCES readers (id),
    issued_date DATE,
    return_date DATE
);
CREATE TABLE book_statuses
(
    id     SERIAL PRIMARY KEY,
    status VARCHAR
);
CREATE TABLE book_in_library
(
    id        SERIAL PRIMARY KEY,
    book_id   INT REFERENCES books (id),
    status_id INT REFERENCES book_statuses (id)
);