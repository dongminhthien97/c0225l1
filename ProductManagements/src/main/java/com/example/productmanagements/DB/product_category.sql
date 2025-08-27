CREATE DATABASE product_category;
USE product_category;


CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2),
    description TEXT,
    manufacturer VARCHAR(255),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO category (name) VALUES 
('Điện thoại'),
('Laptop'),
('Máy tính bảng'),
('Phụ kiện');

INSERT INTO product (name, price, description, manufacturer, category_id) VALUES
('iPhone 15 Pro Max', 32990000, 'Điện thoại cao cấp của Apple', 'Apple', 1),
('Samsung Galaxy S23 Ultra', 28990000, 'Flagship của Samsung', 'Samsung', 1),
('MacBook Pro M2', 45990000, 'Laptop mạnh mẽ dùng chip M2', 'Apple', 2),
('Dell XPS 13', 35990000, 'Laptop siêu mỏng nhẹ', 'Dell', 2),
('iPad Pro 12.9', 29990000, 'Máy tính bảng cao cấp', 'Apple', 3),
('Logitech MX Master 3', 2490000, 'Chuột không dây cao cấp', 'Logitech', 4),
('AirPods Pro 2', 6490000, 'Tai nghe không dây chống ồn', 'Apple', 4);
                             
