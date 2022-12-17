import courseWork1.Employee;

public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {

        employees[0] = new Employee("ТЕСТ1", 1, 45000);
        employees[1] = new Employee("ТЕСТ2", 2, 45000);
        employees[2] = new Employee("ТЕСТ3", 2, 75000);
        employees[3] = new Employee("ТЕСТ4", 2, 45600);
        printEmployeesInfo();
    }
    private static void printEmployeesInfo() {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.toString());
            System.out.println();
        }
    }



}