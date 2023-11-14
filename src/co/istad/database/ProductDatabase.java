package co.istad.database;

import co.istad.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
    public ProductDatabase() {
        products = new ArrayList<>();
        products.add(new Product(1L,"Coca",100,2500.0, LocalDate.now()));
        products.add(new Product(2L,"Vego",100,2500.0, LocalDate.now()));
        products.add(new Product(3L,"Pepsi",100,4000.0, LocalDate.now()));
        products.add(new Product(4L,"Wurkz",100,2000.0, LocalDate.now()));
        products.add(new Product(5L,"Anchor",100,2000.0, LocalDate.now()));
    }
     public Long autoId(){
        Product lastAssign = products.get(products.size()-1);
        long lastId = lastAssign.getId();
        lastId++;
        return lastId;
     }
}


