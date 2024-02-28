CREATE TABLE books
(
    id     SERIAL PRIMARY KEY,
    title  VARCHAR,
    author VARCHAR,
    genre  VARCHAR
);
ALTER TABLE books
    RENAME id To id_book;
CREATE TABLE readers
(
    id   INT PRIMARY KEY,
    name VARCHAR
);
ALTER TABLE readers
    RENAME id TO id_reader;
CREATE TABLE books_on_hand
(
    id          SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books (id_book),
    reader_id   INT REFERENCES readers (id_reader),
    issued_date DATE,
    return_date DATE
);
CREATE TABLE book_statuses
(
    id     SERIAL PRIMARY KEY,
    status VARCHAR
);
CREATE TABLE books_in_library
(
    id        SERIAL PRIMARY KEY,
    book_id   INT REFERENCES books (id_book),
    status_id INT REFERENCES book_statuses (id)
);