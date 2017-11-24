import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private String secondName;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String work;
    private String department;
    private int roomNum;
    private String phone;
    private String email;
    private String salary;
    private String hiredToWork;
    private String notes;

    public Employee() {
        Random r = new Random();

        nextid += nextid + r.nextInt(100);
    }

    private static int nextid;

    {
        id = nextid;
    }

//setters

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        Pattern p = Pattern.compile("((\\d\\d)\\/(\\d\\d)\\/(\\d\\d\\d\\d))");
        Matcher m = p.matcher(dateOfBirth);
        if (!m.matches()) {
            System.out.println("перевірте ввід на вміст не числових символів1");
            m.reset();
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoomNum(String roomNum) {
        Pattern p = Pattern.compile("[0-9]{3}");
        Matcher m = p.matcher(roomNum);
        if (!m.matches()) {
            System.out.println("перевірте ввід на вміст не числових символів");
            m.reset();
        } else {
            this.roomNum = Integer.valueOf(roomNum);
        }
    }

    public void setPhone(String phone) {
        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m = p.matcher(phone);
        if (!m.matches()) {
            System.out.println("номер повинен складатись з 4х цифер");
            m.reset();
        } else {
            this.phone = phone;
        }
    }

    public void setEmail(String email) {
        Pattern p = Pattern.compile("\\w+(\\.\\w+)*@(\\w+\\.)+\\w+");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            System.out.println("хибний e-mail");
            m.reset();
        } else {
            this.email = email;
        }
    }

    public void setSalary(String salary) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(salary);
        if (m.matches()) {
            System.out.println("Matches the entire text string");
            m.reset();
        }
        else {
        this.salary = salary;
        }
    }

    public void setHiredToWork(String hiredToWork) {
        Pattern p = Pattern.compile("((\\d\\d)\\/(\\d\\d)\\/(\\d\\d\\d\\d))");
        Matcher m = p.matcher(hiredToWork);
        if (!m.matches()) {
            System.out.println("перевірте ввід на вміст не числових символів");
            m.reset();
        } else {
            this.hiredToWork = hiredToWork;
        }
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

//getters
    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getWork() {
        return work;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String getHiredToWork() {
        return hiredToWork;
    }

    public String getNotes() {
        return notes;
    }

    public static int getNextid() {
        return nextid;
    }

    public String toString(){
        return id + "; " + secondName + "; " + firstName + "; " + surname + "; " + dateOfBirth + "; " + work + "; " + department +
                "; " + roomNum + "; " + phone + "; " + email + "; " + salary + "; " + hiredToWork + "; " + notes + "; ";
    }
}
