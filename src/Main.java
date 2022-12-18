import courseWork1.Employee;

public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {

        employees[0] = new Employee("Алыбин Максим Евгеньевич", 1, 75003);
        employees[1] = new Employee("Короткопалый Евгений Васильевич", 4, 45076);
        employees[2] = new Employee("Криворукий Василий Амухмабедович", 2, 5010);
        employees[3] = new Employee("Гитлер Адольф Алоисович", 3, 45600);


        printEmployeesInfo();
        System.out.println("Затраты на заработную плату за месяц : " + monthlySalaryCosts());
        System.out.println("Минимальная зарплата у сотрудника : " + getEmployeeMinSalary());
        System.out.println("Максимальная зарплата у сотрудника : " + getEmployeeMaxSalary());
        System.out.println("Средние затраты на зарплату в месяц : " + getMidleEmployeeSalary() + "\n");
        System.out.println("Ф.И.О Сотрудников : \n");
        printAllFullnames();
    }
    private static void printEmployeesInfo() { // печатает инфу по всем сотрудникам
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
        System.out.println();
    }
    private static int monthlySalaryCosts () { // все расходы на зп в месяц
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) { // если в массиве заполнены не все сотрудники
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static Employee getEmployeeMinSalary() { // поиск сотрудника с мин зп
        int min = Integer.MAX_VALUE;
        int counter = 0; // счетчик для поиска номера элемента в массиве
        int i = 0;
        for ( ;i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < min) {
                    min = employees[i].getSalary();
                    counter = i;
                }
            }
        }
        return employees[counter];
    }
    private static Employee getEmployeeMaxSalary() {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        int i = 0;
        for ( ;i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > max) {
                    max = employees[i].getSalary();
                    counter = i;
                }
            }
        }
        return employees[counter];
    }

    private static double getMidleEmployeeSalary() { // средние затраты в месяц на зарплату
        int sum = monthlySalaryCosts(); // все затраты
        int counter = 0; // счетчик сколько элементов в массиве заполнено
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        }
        double midleSalary = (sum*1.) / counter; // преобразовали сум в дабл и поделили на кол-во заполненных сотрудников
        return midleSalary;
    }
    private static void printAllFullnames() { //просто выводит имена сотрудников
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullname());
            }
        }
    }

}