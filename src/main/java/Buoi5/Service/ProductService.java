package Buoi5.Service;

import Buoi5.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static int nextId = 1;
    private List<Product> listProduct = new ArrayList<>();

    public ProductService() {}

    public void add(Product newProduct) {
        newProduct.setId(nextId++);
        listProduct.add(newProduct);
    }

    public List<Product> GetAll() {
        return listProduct;
    }

    public Product get(int id) {
        return listProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void edit(Product editProduct) {
        Product find = listProduct.stream().filter(p -> p.getId() == editProduct.getId()).findFirst().orElse(null);
        if (find != null) {
            find.setName(editProduct.getName());
            find.setImage(editProduct.getImage());
            find.setPrice(editProduct.getPrice());
        }
    }

    public void delete(int id) {
        listProduct.removeIf(p -> p.getId() == id);
    }
}
