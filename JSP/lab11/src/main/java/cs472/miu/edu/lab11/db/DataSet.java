package cs472.miu.edu.lab11.db;


import cs472.miu.edu.lab11.model.Product;
import cs472.miu.edu.lab11.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private static List<User> users;
    private static List<Product> products;

    static {
        User user1=new User("admin", "admin");
        User user2=new User("guest", "guest");
        users= new ArrayList<User>();
        users.add(user1);
        users.add(user2);


        Product product1=new Product(1, "Car", 1200);
        Product product2=new Product(2, "Shirt", 15);
        Product product3=new Product(3, "T-Shirt", 15);
        Product product4=new Product(4, "Belt", 15);
        Product product5=new Product(5, "Boots", 130);
        Product product6=new Product(6, "Hat", 18);
        Product product7=new Product(7, "Winter boots", 205);


        products=new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);

    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProduct(int id){
        return products.stream().filter(product-> product.getProduct_id()==id).findFirst().get();
    }


    public static boolean checkUser(String p_username, String p_password){
        //System.out.println(p_username+"   "+p_password);
        return users.stream().anyMatch(user-> user.getUsername().compareTo(p_username)==0 && user.getPassword().compareTo(p_password)==0);
    }
}


