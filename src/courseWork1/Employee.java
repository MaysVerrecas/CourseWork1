package courseWork1;

import java.util.Objects;

public class Employee {
    private String fullname;
    private int department;
    private int salary; // мы с бухгалтерией решили не работать с копейками и округлять любые изменения до целого.
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
        return this.fullname;
    }
    public int getDepartment(){
        return this.department;
    }
    public int getSalary(){
        return this.salary;
    }

    public int getId() {
        return this.id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullname, employee.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname);
    }
}
