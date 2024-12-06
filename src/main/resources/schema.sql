CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    date DATE NOT NULL,
    category VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);