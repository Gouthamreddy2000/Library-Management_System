
use library_db;
CREATE TABLE borrowed_books (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  book_id INT NOT NULL,
  borrowed_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  due_date DATETIME NULL,
  returned_date DATETIME NULL,
  status ENUM('BORROWED','RETURNED','OVERDUE') NOT NULL DEFAULT 'BORROWED',

  CONSTRAINT fk_bb_user FOREIGN KEY (user_id) REFERENCES registrations(user_id),
  CONSTRAINT fk_bb_book FOREIGN KEY (book_id) REFERENCES books(book_id)
) ENGINE=InnoDB;

