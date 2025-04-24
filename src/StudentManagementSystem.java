import Classes.Course;
import Classes.Student;
import Classes.Teacher;
import Utils.SystemUtils;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int response;

            try {
                response = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next(); // Clear the input buffer
                continue; // Prompt the user again
            }

            switch (response) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handleAddTeacher();
                    break;
                case 3:
                    handleAddCourse();
                    break;
                case 4:
                    // Assign Courses
                    break;
                case 5:
                    // Search Classes.Student
                    break;
                case 6:
                    // View Students & Teachers
                    break;
                case 7:
                    // Show Courses
                    break;
                case 8:
                    // Update Classes.Student Info
                    break;
                case 9:
                    // Delete Classes.Student
                    break;
                case 0:
                    // Exit
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add a Student");
        System.out.println("2. Add a Teacher");
        System.out.println("3. Add a Course");
        System.out.println("4. Assign Courses");
        System.out.println("5. Search Student by ID");
        System.out.println("6. View Students & Teachers");
        System.out.println("7. View Courses");
        System.out.println("8. Update Student Info");
        System.out.println("9. Delete a Student");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddStudent() {
        System.out.println("\nAdding a new student...");

        String name = SystemUtils.readNonEmptyString("Enter student's name: ");
        int age = SystemUtils.readPositiveInt("Enter student's age: ");
        String email = SystemUtils.readEmailString("Enter student's email: ");
        int studentId = SystemUtils.readPositiveInt("Enter student ID: "); // Change to IDGeneration
        int gradeLevel = SystemUtils.readIntInRange("Enter student grade level (1-12): ", 1, 12);
        // Add addCourse

        try {
            Student student = new Student(name, age, email, studentId, gradeLevel);
            SystemUtils.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void handleAddTeacher() {
        System.out.println("\nAdding a new teacher...");

        String name = SystemUtils.readNonEmptyString("Enter teacher's name: ");
        int age = SystemUtils.readPositiveInt("Enter teacher's age: ");
        String email = SystemUtils.readEmailString("Enter teacher's email: ");
        int teacherID = SystemUtils.readPositiveInt("Enter teacher's ID: "); // Change to IDGeneration
        String subject = SystemUtils.readNonEmptyString("Enter teacher's taught subject: ");
        // Add addCourse

        try {
            Teacher teacher = new Teacher(name, age, email, teacherID, subject);
            SystemUtils.addTeacher(teacher);
            System.out.println("Teacher added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void handleAddCourse() {
        System.out.println("Creating a New Course...");

        String name = SystemUtils.readNonEmptyString("Enter the name of the course: ");
        int courseID = SystemUtils.readPositiveInt("Enter course ID: "); // Change to IDGeneration

        try {
            Course course = new Course(name, courseID);
            SystemUtils.addCourse(course);
            System.out.println("Course created successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e);
        }
    }

}
