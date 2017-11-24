import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class EmployeeTest {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public void dialog() {
        EmployeeHelper h = new EmployeeHelper();
        int variant = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Виберіть дію яку ви хочете виконати:\n" +
                "1: додати нового працівника\n" +
                "2: переглянути дані працівника\n" +
                "3: редагувати існуючого працівника\n" +
                "4: видалити існуючого працівника\n" +
                "5: згенерувати звіт");
        variant = s.nextInt();
        switch (variant) {
            case 1:
                h.fill();
                employees.add(h.getEmployee());
                dialog();
                break;
            case 2:
                Employee eTemp = h.searchEmployee(employees);
                if (eTemp != null) {
                    System.out.println(eTemp.toString());
                }
                dialog();
                break;
            case 3:
                Employee eTemp2 = h.searchEmployee(employees);
                if (eTemp2 != null) {
                    try {
                        FileWriter fstream1 = new FileWriter("/home/mustache/Documents/Employee-master/src/main/java/employees");
                        BufferedWriter out1 = new BufferedWriter(fstream1);
                        out1.write("");
                        out1.close();
                    } catch (Exception e)
                    {System.err.println("Error in file cleaning: " + e.getMessage());}
                    h.edit(eTemp2);
                    for (Employee e: employees) {
                        try(FileWriter writer = new FileWriter("/home/mustache/Documents/Employee-master/src/main/java/employees", true)) {
                            writer.write(e.toString() + "\n");
                        } catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                }

                dialog();
                break;
            case 4:
                Employee eTemp3 = h.searchEmployee(employees);
                if (eTemp3!= null) {
                    try {
                        FileWriter fstream1 = new FileWriter("/home/mustache/Documents/Employee-master/src/main/java/employees");
                        BufferedWriter out1 = new BufferedWriter(fstream1);
                        out1.write("");
                        out1.close();
                    } catch (Exception e) {
                        System.err.println("Error in file cleaning: " + e.getMessage());
                    }
                    employees.remove(eTemp3);
                    for (Employee e : employees) {
                        try (FileWriter writer = new FileWriter("/home/mustache/Documents/Employee-master/src/main/java/employees", true)) {
                            writer.write(e.toString() + "\n");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                dialog();
                break;
            case 5:
                try(FileWriter writer = new FileWriter("/home/mustache/Documents/Employee-master/src/main/report.txt")) {

                    for (Employee employee : employees) {
                        writer.write("------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

                        writer.write("| " + String.format("%-4s" ,employee.getId()) + " | " + String.format("%-11s", employee.getSecondName()) + " | " + String.format("%-10s" ,employee.getFirstName()) + " | "
                                + String.format("%-10s" ,employee.getSurname()) + " | " + String.format("%-10s" ,employee.getDateOfBirth()) + " | " + String.format("%-10s" ,employee.getWork()) + " | "
                                + String.format("%-10s" ,employee.getDepartment()) + " | " + String.format("%-3s" ,employee.getRoomNum()) + " | " + String.format("%-4s" ,employee.getPhone()) + " | "
                                + String.format("%-12s" ,employee.getEmail()) + " | " + String.format("%-5s" ,employee.getSalary()) + " | " + String.format("%-10s" ,employee.getHiredToWork()) + " | "
                                + String.format("%-15s" ,employee.getNotes()) + " |" + "\n");
                    }
                }  catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                break;
        }
    }

    public static void main(String[] args) {
        EmployeeTest t = new EmployeeTest();
        EmployeeHelper h = new EmployeeHelper();
        t.employees.addAll(h.FillFromFile());
        t.dialog();

    }
}