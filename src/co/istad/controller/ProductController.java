package co.istad.controller;

import co.istad.dao.ProductDao;
import co.istad.database.ProductDatabase;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.util.Singleton;
import co.istad.view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;
    private final Scanner scanner;
    private final ProductDatabase productDatabase;
    private Long idIncrease;

    public ProductController() {
        productService = Singleton.getProductServiceImpl();
        scanner = new Scanner(System.in);
        productDatabase = new ProductDatabase();
        idIncrease = productDatabase.autoId();
    }

    public void index() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

    public Long create() {
        System.out.println("Enter id = " + idIncrease);
        System.out.print("Enter name = ");
        String name = scanner.nextLine();
        System.out.print("Enter qty = ");
        Integer qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price = ");
        Double price = Double.parseDouble(scanner.nextLine());
        Product productAdd = new Product(idIncrease, name, qty, price, LocalDate.now());
        productService.insert(productAdd);
        idIncrease++;
        return idIncrease;
    }

    public void delete() {
        System.out.print("Enter DeletedId = ");
        Long deletedId = Long.parseLong(scanner.nextLine());
        productService.deleteById(deletedId);
    }

    public void update() {
        System.out.print("Enter UpdatedId = ");
        Long updatedId = Long.parseLong(scanner.nextLine());
        try {
            Product product = productService.selectById(updatedId);
            if (product != null) {
                System.out.print("Enter name = ");
                String name = scanner.nextLine();
                System.out.print("Enter qty = ");
                Integer qty = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price = ");
                Double price = Double.parseDouble(scanner.nextLine());
                Product productUpdate = new Product(updatedId, name, qty, price, LocalDate.now());
                productService.updateById(productUpdate);
            } else {
                throw new ProductIdNotFoundException("Product ID not found: " + updatedId);
            }
        } catch (ProductIdNotFoundException e) {
            System.out.println(e);
        }
    }
}