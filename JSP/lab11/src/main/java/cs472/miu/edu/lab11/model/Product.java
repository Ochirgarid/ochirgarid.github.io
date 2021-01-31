package cs472.miu.edu.lab11.model;

import java.util.Objects;

public class Product {
    private int product_id;
    private String product_name;
    private int price;

    public Product(int id, String name, int price){
        this.product_id=id;
        this.product_name=name;
        this.price=price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && product_id==product.product_id && product_name.equals(product.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_name, price);
    }
}
