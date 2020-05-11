-- CREATE DATABASE pymes_db;

CREATE TABLE flashcards (
    id              SERIAL PRIMARY KEY,
    front           VARCHAR(100) NOT NULL,
    back            VARCHAR(100) NOT NULL,
    okn             DECIMAL NOT NULL,
    nokn            DECIMAL NOT NULL,
    enable          BOOLEAN  NOT NULL,
    updated_at      TIMESTAMP,
    created_at      TIMESTAMP
);

-- CREATE TABLE categories (
--    id             SERIAL PRIMARY KEY,
--    name           VARCHAR(100) NOT NULL
--);

--INSERT INTO categories (name) values ('Abarrots');
--INSERT INTO categories (name) values ('Farmaceutico');
--INSERT INTO categories (name) values ('Otros');
