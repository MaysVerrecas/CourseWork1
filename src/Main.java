import courseWork1.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.createEmployee("Покерко Лев Львович", 3 , 45640);
        employeeBook.createEmployee("Алыбин Максим Евгеньевич", 1, 75003);
        employeeBook.createEmployee("Короткопалый Евгений Васильевич", 4, 45076);
        employeeBook.createEmployee("Криворукий Василий Амухмабедович", 1, 5010);
        employeeBook.createEmployee("Гитлер Адольф Алоисович", 3, 45600);
        employeeBook.createEmployee("Покер Фейс Альбертович", 5 , 54320);
        employeeBook.createEmployee("Глушко Владимир Сергеевич", 1 , 115600);
    }
}