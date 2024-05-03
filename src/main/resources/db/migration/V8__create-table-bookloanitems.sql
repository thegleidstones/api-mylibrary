CREATE TABLE book_loan_items (
    id VARCHAR(255)  NOT NULL PRIMARY KEY,
    book_loan_id VARCHAR(255) NOT NULL,
    book_copy_id VARCHAR(255) NOT NULL,
    is_active BIT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT book_loan_items_book_loan_id_fkey FOREIGN KEY (book_loan_id) REFERENCES book_loans(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT book_loan_items_book_copy_id_fkey FOREIGN KEY (book_copy_id) REFERENCES book_copies(id) ON DELETE RESTRICT ON UPDATE CASCADE
);