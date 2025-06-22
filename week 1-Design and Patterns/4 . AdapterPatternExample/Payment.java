interface PaymentProcessor{
    void processPayment(double amount);
}

class UPIPayment{
    private String upiId;
    public UPIPayment(String upiId){
        this.upiId = upiId;
    }
    public void payViaUPI(double amount){
        System.out.println("Paid Rs." + amount);
    }
}

class DebitCardPayment{
    private String cardNumber;
    public DebitCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void debitCard(double amount){
        System.out.println("Paid Rs." + amount);
    }
}

class CreditCardPayment{
    private String cardNumber;
    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void creditCard(double amount){
        System.out.println("Paid Rs." + amount);
    }
}

class UPIAdapter implements PaymentProcessor{
    private UPIPayment upi;
    public UPIAdapter(String upiId){
        this.upi = new UPIPayment(upiId);
    }

    public void processPayment(double amount){
        upi.payViaUPI(amount);
    }
}

class DebitCardAdapter implements PaymentProcessor{
    private DebitCardPayment debit;
    public DebitCardAdapter(String cardNumber){
        this.debit = new DebitCardPayment(cardNumber);
    }

    public void processPayment(double amount){
        debit.debitCard(amount);
    }
}

class CreditCardAdapter implements PaymentProcessor{
    private CreditCardPayment credit;
    public CreditCardAdapter(String cardNumber){
        this.credit = new CreditCardPayment(cardNumber);
    }

    public void processPayment(double amount){
        credit.creditCard(amount);
    }
}

public class Payment{
    public static void main(String[] args){
        PaymentProcessor upi = new UPIAdapter("user@upi");
        upi.processPayment(750.0);

        PaymentProcessor debit = new DebitCardAdapter("1234-5678-9012-3456");
        debit.processPayment(1500.0);

        PaymentProcessor credit = new CreditCardAdapter("9876-5432-1098-7654");
        credit.processPayment(3000.0);
    }
}