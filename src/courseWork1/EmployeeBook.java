package courseWork1;

public class EmployeeBook {
    private final  Employee[] employees = new Employee[10];

    public void printEmployeesInfo() { // печатает инфу по всем сотрудникам
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
        System.out.println();
    }
    public int monthlySalaryCosts () {// все расходы на зп в месяц
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) { // если в массиве заполнены не все сотрудники
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeMinSalary() { // поиск сотрудника с мин зп
        if (counterEmployee() == 0) {
            throw new RuntimeException("У вас нет сотрудников.");
        }
        int min = Integer.MAX_VALUE;
        int counter = -1; // счетчик для поиска номера элемента в массиве
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }
    public Employee getEmployeeMaxSalary() { // поиск макс зп
        if (counterEmployee() == 0) {
            throw new RuntimeException("У вас нет сотрудников.");
        }
        int max = Integer.MIN_VALUE;
        int counter = -1;
        for (int i = 0 ;i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }

    public double getMidleEmployeeSalary() { // средние затраты в месяц на зарплату
        double sum = monthlySalaryCosts()*1.; // все затраты
        return sum / counterEmployee();
    }

    public void printAllFullnames() { //просто выводит имена сотрудников
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullname());
            }
        }
    }

    public void indexingSalary(double percentageIncrease) { // индексирует за в процентах
        double percent = percentageIncrease / 100; // переводим %
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary((int) (employee.getSalary() + employee.getSalary()*percent));
                //не будем высчитывать их копейки, переживут
            }
        }
    }

    // ниже методы принимающие номер отдела :

    public Employee getDepartamentMinSalary(int department) { // поиск сотрудника с мин зп в отделе
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }
        int min = Integer.MAX_VALUE;
        int counter = -1; // счетчик для поиска номера элемента в массиве.
        int i = 0;
        for ( ;i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }
    public Employee getDepartamentMaxSalary(int department) { // поиск сотрудника с макс зп в отделе
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) {
            throw new RuntimeException("В отделе никто не работает");
        }

        int max = Integer.MIN_VALUE;
        int counter = -1; // счетчик для поиска номера элемента в массиве.

        for ( int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }
    public int departmentSalary(int department) { // затраты зп на отдел
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

    public int counterDepartmentEmployee(int department) { //счетчик сотрудников в отделе (доп метод для удобства)
        int counter = 0; // считаем колво сотрудников отдела
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            }
        }
        return counter;
    }
    public int counterEmployee() { //счетчик сотрудников  массиве (доп метод для удобства)
        int counter = 0; // считаем колво сотрудников отдела
        for (Employee employee : employees) {
            if (employee != null) {
                counter++;
            }
        }
        return counter;
    }


    public double midleDepartmentSalary (int department) { // средняя зп по отделу

        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        int counterDepartmentEmployee = counterDepartmentEmployee(department);
        if (counterDepartmentEmployee == 0) { // избежать ошибки деления на 0
            throw new RuntimeException("В отделе никто не работает");
        }
        return (departmentSalary(department)*1.) / counterDepartmentEmployee;
    }
    public void indexingDepartmentSalary(int department, double percentageIncrease) { // индексирует зп отделу в %
        double percent = percentageIncrease / 100; // переводим %
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        if (counterDepartmentEmployee(department) == 0) { // избежать ошибки деления на 0
            throw new RuntimeException("В отделе никто не работает");
        }

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() + employee.getSalary()*percent));
                //не будем высчитывать их копейки, переживут
            }
        }
    }

    public void infoDepartment(int department) { // печатает отделы и их сотрудников
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

    public void createEmployee(String fullname, int department, int salary) { // создание сотрудника в базу
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                flag = true;
                employees[i] = new Employee(fullname, department, salary);
                break; // видела, что используют return в подобных, но не понимаю почему, будет брейк
            }
        }
        if (!flag) {
            System.out.println("Создание объекта не возможно, пустых ячеек нет");
        }
    }

    public void deliteEmployee(int id) { //удаление по id из массива сотрудников
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                flag = true;
                employees[i] = null;
                break;
            }
        }
        if (!flag) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }
    public void deliteEmployee(String fullname) { //удаление по имени из массива сотрудников(переопределение удаления по id)
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullname().equals(fullname)) {
                flag = true;
                employees[i] = null;
                break;
            }
        }
        if (!flag) {
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
        if (!flag) {
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
        if (!flag) {
            System.out.println("Такого сотрудника не удалось найти");
        }
    }
    public void printDepartmentsInfo() { // печатает всех сотрудников по отделу
         for (int j = 1; j <= 5; j++) {
             System.out.println("Отдел № " + j);
             for (int i = 0; employees[i] != null; i++) {
                 if (employees[i] != null && employees[i].getDepartment() == j) {
                     System.out.println(employees[i].getFullname());
                 }
             }
             System.out.println();
         }
    }

}