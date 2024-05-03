CREATE TABLE book_copies (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    book_id VARCHAR(255) NOT NULL,
    publisher_id VARCHAR(255) NOT NULL,
    isbn_code VARCHAR(255) NOT NULL,
    edition VARCHAR(255),
    edition_date TIMESTAMP,
    acquisition_at TIMESTAMP,
    is_active BIT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT book_copies_book_id_fkey FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT book_copies_publisher_id_fkey FOREIGN KEY (publisher_id) REFERENCES publishers (id) ON DELETE RESTRICT ON UPDATE CASCADE
);