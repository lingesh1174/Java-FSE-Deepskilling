public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        manager.addEmployee(new Employee(101, "Ajith", "Engineer", 60000));
        manager.addEmployee(new Employee(102, "Vjay", "Manager", 80000));
        manager.addEmployee(new Employee(103, "Surya", "Clerk", 40000));

        System.out.println("All Employees:");
        manager.traverseEmployees();
        System.out.println("\nSearching for employee with ID 102:");
        manager.searchEmployee(102);
        System.out.println("\nDeleting employee with ID 101:");
        manager.deleteEmployee(101);
        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}

class Employee {
    int employeeId;
    String name, position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int count;
    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }
    public void addEmployee(Employee emp) {
        if (count >= employees.length) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return;
        }
        employees[count++] = emp;
        System.out.println("Employee added: " + emp.name);
    }
    public void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                employees[i].displayInfo();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].displayInfo();
        }
    }
    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count-1; j++) {
                    employees[j] = employees[j+1];
                }
                employees[--count] = null;
                System.out.println("Employee with ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
}