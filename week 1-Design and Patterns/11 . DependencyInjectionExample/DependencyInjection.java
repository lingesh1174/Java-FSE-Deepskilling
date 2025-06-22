interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerById(String id) {
        return "Customer{id='" + id + "', name='Ajay'}";
    }
}

class CustomerService{
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void displayCustomer(String id){
        String customer = repository.findCustomerById(id);
        System.out.println("Customer Found: " + customer);
    }
}

public class DependencyInjection {
    public static void main(String[] args){
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.displayCustomer("C786");
    }
}