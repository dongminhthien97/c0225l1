package com.example.productmanagements.repository;

import com.example.productmanagements.enity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private final String SELECT_ALL = "select * from products;";
    private final String INSERT_INTO = "INSERT INTO products (name, price, description, manufacturer) VALUES (?,?,?,?);";
    private final String UPDATE_PRODUCT = "UPDATE products SET name = ?, price = ?, description = ?, manufacturer = ? WHERE id = ?";
    private final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";
    private final String FIND_BY_ID = "SELECT * FROM products WHERE id = ?";
    private final String FIND_BY_NAME = "SELECT * FROM products WHERE name LIKE ?";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
            try(Connection connection = BaseRepository.getConnectDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    String description = resultSet.getString("description");
                    String manufacturer = resultSet.getString("manufacturer");
                    Product product = new Product(id, name, price, description, manufacturer);
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
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("manufacturer")
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
}
