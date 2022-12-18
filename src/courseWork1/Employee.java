package courseWork1;

public class Employee {
    private String fullname;
    private int department;
    private int salary; // мы с бухгалтерией решили не работать с копейками
    private int id;
    private static int counterId;

    public Employee(String fullname, int department, int salary) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        this.id = ++counterId;
    }
    public String getFullname() {
        return fullname;
    }
    public int getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartament(int department) {
        this.department = department;
    }
    @Override
    public String toString () {
        String infoEmployees  = String.format("id Сотрудника :%d Сотрудник : %s, Отдел №%d, Зароботная плата: %d",id, fullname, department, salary);
        return infoEmployees;
    }

}
