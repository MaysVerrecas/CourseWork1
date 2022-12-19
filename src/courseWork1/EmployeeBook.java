package courseWork1;

public class EmployeeBook {
    private  Employee[] employees = new Employee[10];

    public void printEmployeesInfo() { // печатает инфу по всем сотрудникам
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
        System.out.println();
    }
    public int monthlySalaryCosts () { // все расходы на зп в месяц
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) { // если в массиве заполнены не все сотрудники
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeMinSalary() { // поиск сотрудника с мин зп
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
    public Employee getEmployeeMaxSalary() { // поиск макс зп
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

    public double getMidleEmployeeSalary() { // средние затраты в месяц на зарплату
        int sum = monthlySalaryCosts(); // все затраты
        int counter = 0; // счетчик сколько элементов в массиве заполнено
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        } // преобразовали сум в дабл и поделили на кол-во заполненных сотрудников
        return (sum*1.) / counter;
    }
    public void printAllFullnames() { //просто выводит имена сотрудников
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullname());
            }
        }
    }

    public void indexingSalary(double percentageIncrease) {
        double percent = percentageIncrease / 100; // переводим %
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary((int) (employee.getSalary() + employee.getSalary()*percent));
                //не будем высчитывать их копейки, переживут, но переделать не составит труда
            }
        }
    }

    // ниже методы принимающие номер отдела :

    public Employee getDepartamentMinSalary(int department) { // поиск сотрудника с мин зп
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
    public Employee getDepartamentMaxSalary(int department) { // поиск сотрудника с макс зп
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
    public int departmentSalary(int department) {
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

    public int counterDepartmentEmployee(int department) { //счетчик сотрудников в отделе
        int counter = 0; // считаем колво сотрудников отдела
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            }
        }
        return counter;
    }

    public double midleDepartmentSalary (int department) { // средняя зп по отделу

        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }
        return (departmentSalary(department)*1.) / counterDepartmentEmployee(department);
    }
    public void indexingDepartmentSalary(int department, double percentageIncrease) { // отдел и %
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

    public void infoDepartment(int department) {
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
    public void lessSalary(int salary) {
        // выводит сотрудников чья зп меньше чем в параметре
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.print(" id = " + employee.getId() + ",");
                System.out.print(" Ф.И.О : " + employee.getFullname() + ",");
                System.out.println(" Заработная плата : " + employee.getSalary());
            }
        }
    }

    public void moreSalary(int salary) {
        // выводит сотрудников чья зп больше или равно параметра
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.print(" id = " + employee.getId() + ",");
                System.out.print(" Ф.И.О : " + employee.getFullname() + ",");
                System.out.println(" Заработная плата : " + employee.getSalary());
            }
        }
    }

    public void createEmployee(String fullname, int department, int salary) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                flag = true;
                employees[i] = new Employee(fullname, department, salary);
                break;
            }
        }
        if (flag == false) {
            System.out.println("Создание объекта не возможно, пустых ячеек нет");
        }
    }

    public void deliteEmployee(int id) { //удаление по id
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                flag = true;
                employees[i] = null;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }
    public void deliteEmployee(String fullname) { //удаление по имени
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullname().equals(fullname)) {
                flag = true;
                employees[i] = null;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }

    public void changeSalary(String fullname, int newSalary) { // меняет зп сотрудника
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullname().equals(fullname)) {
                flag = true;
                employees[i].setSalary(newSalary);
                break;
            }
        }
        if (flag == false) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }
    public void changeDepartment(String fullname, int newDepartment) { //меняет отдел
        if (newDepartment < 0 || newDepartment > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullname().equals(fullname)) {
                flag = true;
                employees[i].setDepartament(newDepartment);
                break;
            }
        }
        if (flag == false) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }
    public void printDepartmentsInfo() { // печатает всех сотрудников по отделу
         for (int j = 1; j <= 5; j++) {
             for (int i = 0; employees[i] != null; i++) {
                 if (employees[i] != null && employees[i].getDepartment() == j) {
                     System.out.println("Отдел № " + j + " "+ employees[i].getFullname());
                 }
             }
             System.out.println();
         }
    }

}
