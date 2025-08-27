package com.example.productmanagements.repository;

import com.example.productmanagements.enity.Category;
import com.example.productmanagements.enity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private final String SELECT_ALL = "SELECT p.id, p.name, p.price, p.description, p.manufacturer, \n" +
            "                                        c.id as category_id, c.name as category_name  \n" +
            "                                        FROM product p\n" +
            "                                        JOIN category c ON p.category_id = c.id;";
    private final String INSERT_INTO = "INSERT INTO product(name, price, description, manufacturer, category_id) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ?, description = ?, manufacturer = ?, category_id = ? WHERE id = ?";
    private final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
    private final String FIND_BY_ID = "SELECT p.id, p.name, p.price, p.description, p.manufacturer, " +
            "c.id as category_id, c.name as category_name " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id " +
            "WHERE p.id = ?";
    private final String FIND_BY_NAME = "SELECT p.id, p.name, p.price, p.description, p.manufacturer, " +
            "c.id as category_id, c.name as category_name " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id " +
            "WHERE p.name LIKE ?";

    private static final String SELECT_PRODUCTS_PAGING =
            "SELECT p.id, p.name, p.price, p.description,p.manufacturer,c.id AS category_id, c.name AS category_name \n" +
                    "                    FROM product p JOIN category c ON p.category_id = c.id \n" +
                    "                    LIMIT ? OFFSET ?;";
    private static final String COUNT_PRODUCTS =
            "SELECT COUNT * FROM product";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
            try(Connection connection = BaseRepository.getConnectDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Category category = new Category(
                            resultSet.getInt("category_id"),
                            resultSet.getString("category_name")
                    );
                    Product product = new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("price"),
                            resultSet.getString("description"),
                            resultSet.getString("manufacturer"),
                            category
                    );
                    productList.add(product);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return productList;
    }

    @Override
    public boolean addProduct(Product product) {
        try(Connection connection = BaseRepository.getConnectDB()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacturer());
            preparedStatement.setInt(5, product.getCategory().getId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = BaseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("category_name")
                );
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("manufacturer"),
                        category
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

        @Override
        public boolean update(Product product) {
        boolean rowUpdated = false;

        try (Connection connection = BaseRepository.getConnectDB()){
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacturer());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.setInt(5, product.getCategory().getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteById(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> productList = new ArrayList<>();
        try(Connection connection = BaseRepository.getConnectDB()){
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + keyword + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Category category = new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("category_name")
                );
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("manufacturer")
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<Product> getProductsByPage(int page, int pageSize) {
        List<Product> products = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCTS_PAGING)) {

            ps.setInt(1, pageSize);
            ps.setInt(2, offset);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );

                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("manufacturer"),
                        category
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int getTotalProducts() {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(COUNT_PRODUCTS)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
