import java.util.*;

// Student class

class Student { private int id; private String name; private boolean isPresent;

public Student(int id, String name) {
    this.id = id;
    this.name = name;
    this.isPresent = false;
}

public int getId() { return id; }
public String getName() { return name; }
public boolean isPresent() { return isPresent; }
public void setPresent(boolean present) { isPresent = present; }
}

// Controller class

class StudentController { @SuppressWarnings("rawtypes")
private List students;

@SuppressWarnings("unchecked")
public StudentController() {
    students = new ArrayList<>();
    // Add some sample students
    students.add(new Student(1, "Ayush"));
    students.add(new Student(2, "Aryan"));
    students.add(new Student(3, "Aditya"));
}

@SuppressWarnings("unchecked")
public List<Student> getAllStudents() {
    return students;
}

public void markAttendance(int studentId, boolean isPresent) {
    for (Student student : students) {
        if (student.getId() == studentId) {
            student.setPresent(isPresent);
            break;
        }
    }
}
} // View class

class AttendanceView { private StudentController controller; private Scanner scanner;

public AttendanceView(StudentController controller) {
    this.controller = controller;
    scanner = new Scanner(System.in);
}

public void displayStudents() {
    System.out.println("Student List:");
    for (Student student : controller.getAllStudents()) {
        System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Present: " + (student.isPresent() ? "Yes" : "No"));
    }
}

public void takeAttendance() {
    System.out.println("Mark Attendance:");
    for (Student student : controller.getAllStudents()) {
        System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        System.out.print("Is Present (true/false): ");
        boolean isPresent = scanner.nextBoolean();
        controller.markAttendance(student.getId(), isPresent);
    }
}
}

//Main class

public class Attendance { public static void main(String[] args) { StudentController controller = new StudentController(); AttendanceView view = new AttendanceView(controller);

    view.displayStudents();
    view.takeAttendance();
    view.displayStudents();
}
}


 