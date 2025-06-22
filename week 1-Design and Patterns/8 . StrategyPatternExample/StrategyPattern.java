interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name){
        this.cardNumber = cardNumber;
        this.name = name;
    }
    public void pay(double amount){
        System.out.println("Paid Rs." + amount + " using Credit Card [" + cardNumber + "] by " + name);
    }
}

class PayPalPayment implements PaymentStrategy{
    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }
    public void pay(double amount){
        System.out.println("Paid Rs." + amount + " using PayPal account: " + email);
    }
}

class PaymentContext{
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void makePayment(double amount){
        if (strategy==null){
            System.out.println("No payment method selected.");
        } else {
            strategy.pay(amount);
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args){
        PaymentContext pay = new PaymentContext();
        pay.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Hari"));
        pay.makePayment(15000.0);
        pay.setPaymentStrategy(new PayPalPayment("abcd1234@gmail.com"));
        pay.makePayment(980.0);
    }
}