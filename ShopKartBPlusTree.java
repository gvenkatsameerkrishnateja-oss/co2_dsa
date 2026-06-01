import java.util.*;

class Product {
    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class ShopKartBPlusTree {
    TreeMap<Integer, Product> catalog = new TreeMap<>();

    void insert(Product p) {
        catalog.put(p.id, p);
    }

    void delete(int id) {
        catalog.remove(id);
    }

    Product search(int id) {
        return catalog.get(id);
    }

    void rangeQuery(int start, int end) {
        SortedMap<Integer, Product> range =
                catalog.subMap(start, true, end, true);

        for (Product p : range.values()) {
            System.out.println("ID: " + p.id + " Name: " + p.name);
        }
    }

    public static void main(String[] args) {
        ShopKartBPlusTree shop = new ShopKartBPlusTree();

        shop.insert(new Product(1001, "Laptop"));
        shop.insert(new Product(1002, "Mobile"));
        shop.insert(new Product(1003, "Headphones"));
        shop.insert(new Product(1004, "Keyboard"));

        System.out.println("Search Product:");
        Product p = shop.search(1002);

        if (p != null)
            System.out.println(p.id + " " + p.name);

        System.out.println("\nRange Query (1002-1004):");
        shop.rangeQuery(1002, 1004);
    }
}