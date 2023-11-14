package co.istad.util;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.model.Product;
import co.istad.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Singleton {
//    1. Create static reference type
    private static Scanner scanner;
    private static MenuController menuController;
    private static ProductController productcontroller;
    private static ProductServiceImpl productServiceImpl;
//    2. Create get instance of scanner
    public static Scanner scanner () {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    public static MenuController menuController() {
        if (menuController == null){
            menuController = new MenuController();
        }
        return menuController;
    }
    public static ProductServiceImpl getProductServiceImpl() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public static ProductController productController() {
        if (productcontroller == null) {
            productcontroller = new ProductController();
        }
        return productcontroller;
    }

}
