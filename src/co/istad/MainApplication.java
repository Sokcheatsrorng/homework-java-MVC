package co.istad;


import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.MenuView;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static co.istad.util.Singleton.getProductServiceImpl;
import static co.istad.util.Singleton.menuController;

public class MainApplication {
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productcontroller;
    private final ProductServiceImpl productServiceImpl;
    public MainApplication(){
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productcontroller = Singleton.productController();
        productServiceImpl = Singleton.getProductServiceImpl();
    }
    private void run() {
        menuController.index();
        Product product = new Product();
        ProductController productController = new ProductController();

            try {
                while(true){
                    System.out.print("Enter options : ");
                    int option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1 -> productController.index();
                        case 2 -> productController.create();
                        case 3 -> productController.delete();
                        case 4 -> productController.update();
                        default -> throw new IllegalStateException();
                    }
                }
            } catch(IllegalStateException e){
                System.err.println(e);
            }
        }
    public static void main(String[] args) {
       new MainApplication().run();

    }
}
