package model.domain;
import java.util.List;
import java.util.ArrayList;

public class ProductCRUD {
    private List<Product> products = new ArrayList<>();

    public void create(Product p){
        products.add(p);
    }
    public List<Product> readAll(){
        return products;
    }
    public Product readById(int id){
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void update(int id, String newName, double newPrice){
        Product p = readById(id);
        if(p != null){
            p.setName(newName);
            p.setPrice(newPrice);
        }
    }
    public void delete(int id){
        Product p = readById(id);
        if(p != null){
            products.remove(p);
        }
    }
}
