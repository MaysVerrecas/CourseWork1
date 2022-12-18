import courseWork1.Employee;

import static java.lang.Double.NaN;
import static java.lang.Double.sum;

public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {

        employees[0] = new Employee("Алыбин Максим Евгеньевич", 1, 75003);
        employees[1] = new Employee("Короткопалый Евгений Васильевич", 4, 45076);
        employees[2] = new Employee("Криворукий Василий Амухмабедович", 1, 5010);
        employees[3] = new Employee("Гитлер Адольф Алоисович", 3, 45600);
        employees[4] = new Employee("Покерко Лев Львович", 3 , 45640);
        employees[5] = new Employee("Покер Фейс Альбертович", 5 , 54320);
        employees[6] = new Employee("Глушко Владимир Сергеевич", 1 , 115600);

//   БАЗА
        printEmployeesInfo();
//        System.out.println("Затраты на заработную плату за месяц : " + monthlySalaryCosts());
//        System.out.println("Минимальная зарплата у сотрудника : " + getEmployeeMinSalary());
//        System.out.println("Максимальная зарплата у сотрудника : " + getEmployeeMaxSalary());
//        System.out.println("Средние затраты на зарплату в месяц : " + getMidleEmployeeSalary() + "\n");
//        System.out.println("Ф.И.О Сотрудников : \n");
//        printAllFullnames();

        // Повышенная сложность
//        indexingSalary(12.4);
//        System.out.println("Сотрудник с минимальной зарлатой в отделе : " + getDepartamentMinSalary(1));
//         System.out.println("Сотрудник с максимальной зарплатой в отделе : " + getDepartamentMaxSalary(2));
//        System.out.println("Затраты на зарплату отдела : " + departmentSalary(1));
//        System.out.println("Средняя зарплата по отделу : " + midleDepartmentSalary(1));
//        indexingDepartmentSalary(3, 30);
//        infoDepartment(1);
//        lessSalary(50000);
        moreSalary(45600);

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
        int counter = -1; // счетчик для поиска номера элемента в массиве
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
    private static Employee getEmployeeMaxSalary() { // поиск макс зп
        int max = Integer.MIN_VALUE;
        int counter = -1;
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
        } // преобразовали сум в дабл и поделили на кол-во заполненных сотрудников
        return (sum*1.) / counter;
    }
    private static void printAllFullnames() { //просто выводит имена сотрудников
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullname());
            }
        }
    }

    private static void indexingSalary(double percentageIncrease) {
        double percent = percentageIncrease / 100; // переводим %
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary((int) (employee.getSalary() + employee.getSalary()*percent));
                //не будем высчитывать их копейки, переживут, но переделать не составит труда
            }
        }
    }

    // ниже методы принимающие номер отдела :

    private static Employee getDepartamentMinSalary(int department) { // поиск сотрудника с мин зп
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }

        int min = Integer.MAX_VALUE;
        int counter = -1; // счетчик для поиска номера элемента в массиве.
        int i = 0;
        for ( ;i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < min) {
                        min = employees[i].getSalary();
                        counter = i;
                }
            }
        }
        if (counter > 0) {
            throw new RuntimeException("В отделе никто не работает");
        }
        return employees[counter];
    }
    private static Employee getDepartamentMaxSalary(int department) { // поиск сотрудника с макс зп
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }

        int max = Integer.MIN_VALUE;
        int counter = -1; // счетчик для поиска номера элемента в массиве.
        int i = 0;

        for ( ;i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() > max) {
                    max = employees[i].getSalary();
                    counter = i;
                }
            }
        }

        return employees[counter];
    }
    private static int departmentSalary(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;

    }

    private static int counterDepartmentEmployee(int department) { //счетчик сотрудников в отделе
        int counter = 0; // считаем колво сотрудников отдела
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            }
        }
        return counter;
    }

    private static double midleDepartmentSalary (int department) { // средняя зп по отделу

        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }
        return (departmentSalary(department)*1.) / counterDepartmentEmployee(department);
    }
    private static void indexingDepartmentSalary(int department, double percentageIncrease) { // отдел и %
        double percent = percentageIncrease / 100; // переводим %
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() + employee.getSalary()*percent));
                //не будем высчитывать их копейки, переживут
            }
        }
    }

    private static void infoDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }
        System.out.println("Информация о отделе № " + department);

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.print(" id = " + employee.getId() + ",");
                System.out.print(" Ф.И.О : " + employee.getFullname() + ",");
                System.out.println(" Заработная плата : " + employee.getSalary());
            }
        }
    }

    // Получить в качестве параметра число и найти:
    private static void lessSalary(int salary) {
        // выводит сотрудников чья зп меньше чем в параметре
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.print(" id = " + employee.getId() + ",");
                System.out.print(" Ф.И.О : " + employee.getFullname() + ",");
                System.out.println(" Заработная плата : " + employee.getSalary());
            }
        }
    }

    private static void moreSalary(int salary) {
        // выводит сотрудников чья зп больше или равно параметра
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.print(" id = " + employee.getId() + ",");
                System.out.print(" Ф.И.О : " + employee.getFullname() + ",");
                System.out.println(" Заработная плата : " + employee.getSalary());
            }
        }
    }
}