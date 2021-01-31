package cs472.miu.edu.lab11.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<Product> products;

    public Card(){
        this.products=new ArrayList<Product>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts(){
        return this.products;
    }

    @Override
    public String toString() {
        return "Card{" +
                "products=" + products.size() +
                '}';
    }
}
