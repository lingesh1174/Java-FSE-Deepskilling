import java.util.Arrays;

class Product implements Comparable<Product>{
    int productId;
    String productName, category;
    public Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public int compareTo(Product other){
        return this.productName.compareToIgnoreCase(other.productName);
    }
    public String toString(){
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class SearchUtils {
    public static Product linearSearch(Product[] products, String targetName){
        for (Product product : products){
            if (product.productName.equalsIgnoreCase(targetName)){
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName){
        int low = 0;
        int high = products.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);
            if (comparison == 0)
                return products[mid];
            else if(comparison<0)
                low = mid+1;
            else 
                high = mid-1;
        }
        return null;
    }
}

public class EcommerceSearch {
    public static void main(String args[]) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Apparel"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Camera", "Electronics")
        };
        System.out.println("Linear Search:");
        Product result1 = SearchUtils.linearSearch(products, "Shoes");
        System.out.println(result1 != null ? result1 : "Product not found");
        Arrays.sort(products);
        System.out.println("\nBinary Search:");
        Product result2 = SearchUtils.binarySearch(products, "Shoes");
        System.out.println(result2 !=null ? result2 : "Product not found");
    }
}