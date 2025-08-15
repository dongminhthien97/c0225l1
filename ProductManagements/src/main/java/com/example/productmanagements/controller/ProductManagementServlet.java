package com.example.productmanagements.controller;

import com.example.productmanagements.enity.Product;
import com.example.productmanagements.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductManagementServlet", value = "/products")
public class ProductManagementServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
                case "remove":
                deleteProduct(req,resp);
                break;
            default:
                ShowList(req, resp);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        String idStr = req.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            boolean removed = productService.removeById(id);

            if (removed) {
                try {
                    resp.sendRedirect(req.getContextPath() + "/products?action=list&mess=Deleted+successfully");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    resp.sendRedirect(req.getContextPath() + "/products?action=list&mess=Product+not+found");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/products?action=list&mess=Invalid+ID");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            try {
                resp.sendRedirect(req.getContextPath() + "/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        int id = Integer.parseInt(idStr);
        Product existingProduct = productService.findById(id);
        req.setAttribute("product", existingProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void ShowList(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = productService.findAll();
        req.setAttribute("productList", productList);
        try {
            req.getRequestDispatcher("/view/product/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/view/product/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(req,resp);
                break;
            case "edit":
                update(req,resp);
                break;

                default:
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        Product product = new Product(id, name, price, description, manufacturer);
        boolean isAddSuccess = productService.addProduct(product);
        String mess = "";
        if (isAddSuccess){
            mess = "Added successfully";
        }else {
            mess = "Fail to add new product";
        }
        try {
            resp.sendRedirect("/products?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");

        Product product = new Product(id, name, price, description, manufacturer);
        productService.update(product);
        try {
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
