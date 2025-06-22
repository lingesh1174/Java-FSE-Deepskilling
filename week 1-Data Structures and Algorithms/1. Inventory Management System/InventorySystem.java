import java.util.HashMap;

class Product{
    int productId , quantity;
    String productName;
    double price;
    public Product(int productId, String productName, int quantity, double price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String toString(){
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: Rs." + price;
    }
}

class InventoryManager{
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product){
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product.productName);
    }

    public void updateProduct(int productId, String name, int quantity, double price){
        if (inventory.containsKey(productId)){
            Product product = inventory.get(productId);
            product.productName = name;
            product.quantity = quantity;
            product.price = price;
            System.out.println("Product updated: " + name);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void deleteProduct(int productId){
        if (inventory.containsKey(productId)){
            Product removed = inventory.remove(productId);
            System.out.println("Product deleted: " + removed.productName);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void displayInventory(){
        System.out.println("\nCurrent Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Product p1 = new Product(101, "Mouse", 50, 300.00);
        Product p2 = new Product(102, "Keyboard", 30, 450.00);
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.displayInventory();
        manager.updateProduct(101, "Wireless Mouse", 40, 575.00);
        manager.displayInventory();
        manager.deleteProduct(102);
        manager.displayInventory();
    }
}