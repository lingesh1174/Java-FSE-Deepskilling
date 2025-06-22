class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public String toString(){
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice;
    }
}

class Sorter{
    public static void bubbleSort(Order[] orders){
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low<high) {
            int pivotIndex = partition(orders,low, high);
            quickSort(orders, low, pivotIndex-1);
            quickSort(orders, pivotIndex+1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low-1;

        for (int j = low; j<high; j++) {
            if (orders[j].totalPrice<pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;
        return i+1;
    }
}

public class SortCustomerOrders{
    public static void main(String[] args){
        Order[] orders = {
            new Order(1, "Arun", 650.25),
            new Order(2, "Surya", 170.50),
            new Order(3, "Sri", 307.00),
            new Order(4, "Harini", 705.25)
        };
        System.out.println("Bubble Sort :");
        Order[] bubbleSorted = orders.clone();
        Sorter.bubbleSort(bubbleSorted);
        for (Order o : bubbleSorted) {
            System.out.println(o);
        }
        System.out.println("\nQuick Sort :");
        Order[] quickSorted = orders.clone();
        Sorter.quickSort(quickSorted, 0, quickSorted.length - 1);
        for (Order o : quickSorted) {
            System.out.println(o);
        }
    }
}