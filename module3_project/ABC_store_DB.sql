CREATE DATABASE ABC_Store;
USE ABC_Store;

CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO category (category_name)
VALUES ('Rau'), ('Củ'), ('Quả'), ('Hoa');

CREATE TABLE product (
    product_id VARCHAR(20) PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    unit VARCHAR(20) NOT NULL,
    price INT NOT NULL CHECK (price >= 1000),
    category_id INT NOT NULL,
    harvest_date DATE,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

INSERT INTO product (product_id, product_name, unit, price, category_id, harvest_date) VALUES
('MHH-RAU1', 'Rau Muống', 'bo', 5000, 1, '2025-08-20'),
('MHH-RAU2', 'Cải Ngọt', 'kg', 12000, 1, '2025-08-22'),
('MHH-CU01', 'Cà Rốt', 'kg', 15000, 2, '2025-08-18'),
('MHH-CU02', 'Khoai Tây', 'kg', 18000, 2, '2025-08-17'),
('MHH-QUA1', 'Táo Mỹ', 'kg', 60000, 3, '2025-08-15'),
('MHH-QUA2', 'Cam Sành', 'kg', 35000, 3, '2025-08-19'),
('MHH-HOA1', 'Hoa Hồng', 'bo', 40000, 4, '2025-08-21'),
('MHH-HOA2', 'Hoa Ly', 'bo', 80000, 4, '2025-08-23');

select * from product;

