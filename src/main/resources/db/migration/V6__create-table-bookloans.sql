CREATE TABLE book_loans (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    loan_date TIMESTAMP NOT NULL,
    book_reader_id VARCHAR(255) NOT NULL,
    book_copy_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT book_loans_book_reader_id_fkey FOREIGN KEY (book_reader_id) REFERENCES book_readers(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT book_loans_book_copy_id_fkey FOREIGN KEY (book_copy_id) REFERENCES book_copies(id) ON DELETE RESTRICT ON UPDATE CASCADE
);