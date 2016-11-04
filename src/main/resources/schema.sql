CREATE SEQUENCE books_id_sequence INCREMENT BY 50;
CREATE TABLE books (
  id INTEGER NOT NULL DEFAULT nextval('books_id_sequence'::regclass),
  title VARCHAR(255) NOT NULL,
  create_at timestamp NOT NULL DEFAULT NOW(),
  CONSTRAINT books_id_pk PRIMARY KEY (id)
);

-- Resetting:
-- DELETE FROM books; ALTER SEQUENCE books_id_sequence RESTART WITH 1;