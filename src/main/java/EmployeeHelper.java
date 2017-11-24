import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHelper {
    Employee e = new Employee();

    public void fill() {
        Scanner s = new Scanner(System.in);
        System.out.println("будь ласка, введіть дані про працівника");
        System.out.print("Прізвище: ");
        e.setSecondName(s.nextLine());
        System.out.print("Ім'я: ");
        e.setFirstName(s.nextLine());
        System.out.print("По-батькові: ");
        e.setSurname(s.nextLine());
        System.out.print("Дата народження\n");
        System.out.println("Введіть дату в форматі dd/mm/yyyy");
        e.setDateOfBirth(s.nextLine());
        System.out.print("Посада: ");
        e.setWork(s.nextLine());
        System.out.print("Відділ: ");
        e.setDepartment(s.nextLine());
        System.out.print("Кімната: ");
        System.out.println("Введьть 3-значне число");
        e.setRoomNum(s.nextLine());
        System.out.print("Службовий телефон: ");
        System.out.println("Введіть 4-значне число");
        e.setPhone(s.nextLine());
        System.out.print("e-mail: ");
        e.setEmail(s.nextLine());
        System.out.print("Місячний оклад: ");
        System.out.println("в доларах ($n)");
        e.setSalary(s.nextLine());
        System.out.print("Прийнято на роботу: ");
        System.out.println("Введіть дату в форматі dd/mm/yyyy");
        e.setHiredToWork(s.nextLine());
        System.out.println("Додайте примітку");
        e.setNotes(s.nextLine());
        try(FileWriter writer = new FileWriter("/home/mustache/Documents/Employee-master/src/main/java/employees", true)) {
            writer.write(e.toString() + "\n");

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList<Employee> FillFromFile() {
        String[] strings;
        String info;
        ArrayList<Employee> employees= new ArrayList<>();
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("/home/mustache/Documents/Employee-master/src/main/java/employees"))) {
            while ((info = br.readLine()) != null) {
                strings = info.split("; ");
                Employee tEmployee = new Employee();
                for (i = 0; i < strings.length; i++) {
                    strings[i] = strings[i].trim();
                    strings[i] = strings[i].replace(";", "");
                }
                tEmployee.setId(strings[0]);
                tEmployee.setSecondName(strings[1]);
                tEmployee.setFirstName(strings[2]);
                tEmployee.setSurname(strings[3]);
                tEmployee.setDateOfBirth(strings[4]);
                tEmployee.setWork(strings[5]);
                tEmployee.setDepartment(strings[6]);
                tEmployee.setRoomNum(strings[7]);
                tEmployee.setPhone(strings[8]);
                tEmployee.setEmail(strings[9]);
                tEmployee.setSalary(strings[10]);
                tEmployee.setHiredToWork(strings[11]);
                tEmployee.setNotes(strings[12]);
                employees.add(tEmployee);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("При читанні файла: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("При читанні файла: " + e.getMessage());
        }
        return employees;
    }
    public void edit(Employee employee) {
        Scanner s = new Scanner(System.in);
        System.out.println("Що ви хочете змінити?\n" +
                "1: прізвище\n" +
                "2: ім'я\n" +
                "3: по-батькові\n" +
                "4: дата народження\n" +
                "5: посада\n" +
                "6: відділ\n" +
                "7: кімната\n" +
                "8: службовий телефон\n" +
                "9: email\n" +
                "10: місячний оклад\n" +
                "11: дата прийняття на роботу\n" +
                "12: нотатки\n" +
                "13: закінчити");
        int chVariant;
        chVariant = s.nextInt();
        switch (chVariant) {
            case 1: employee.setSecondName(s.next());
                edit(employee);
                break;
            case 2: employee.setFirstName(s.next());
                edit(employee);
                break;
            case 3: employee.setSurname(s.next());
                edit(employee);
                break;
            case 4:
                employee.setDateOfBirth(s.next());
                edit(employee);
                break;
            case 5: employee.setWork(s.next());
                edit(employee);
                break;
            case 6: employee.setDepartment(s.next());
                edit(employee);
                break;
            case 7: employee.setRoomNum(s.next());
                edit(employee);
                break;
            case 8: employee.setPhone(s.next());
                edit(employee);
                break;
            case 9: employee.setEmail(s.next());
                edit(employee);
                break;
            case 10: employee.setSalary(s.next());
                edit(employee);
                break;
            case 11:
                employee.setHiredToWork(s.next());
                edit(employee);
                break;
            case 12: employee.setNotes(s.next());
                edit(employee);
                break;
            case 13 : break;
        }
    }


    public Employee searchEmployee(ArrayList<Employee> employees) {
        Scanner s = new Scanner(System.in);
        Employee se = new Employee();
        System.out.println("Введіть дані працівника якого треба знайти");
       System.out.print("Прізвище: ");
         se.setSecondName(s.nextLine());
       System.out.print("Ім'я: ");
        se.setFirstName(s.nextLine());
        System.out.print("по-батькові: ");
        se.setSurname(s.nextLine());
        System.out.print("Посада: ");
        se.setWork(s.nextLine());
        System.out.print("Відділ: ");
        se.setDepartment(s.nextLine());
        System.out.println("Шукаю...");
        int i = 0;
        for (Employee employee : employees) {
            if (se.getSecondName().equalsIgnoreCase(employee.getSecondName()) && se.getFirstName().equalsIgnoreCase(employee.getFirstName()) &
                    se.getSurname().equalsIgnoreCase(employee.getSurname()) && se.getWork().equalsIgnoreCase(employee.getWork()) && se.getDepartment().equalsIgnoreCase(employee.getDepartment())) {
                System.out.println("Знайшов!");

                return employee;
            }
            i++;
        }
        return null;
    }


    public Employee getEmployee() {
        e.toString();
        return this.e;
    }
}


