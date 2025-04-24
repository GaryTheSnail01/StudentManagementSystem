import Classes.Student;
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
                    // Add Classes.Teacher
                    break;
                case 3:
                    // Add Course
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
        System.out.println("\nClasses.Student Management System");
        System.out.println("1. Add Classes.Student");
        System.out.println("2. Add Classes.Teacher");
        System.out.println("3. Add Course");
        System.out.println("4. Assign Courses");
        System.out.println("5. Search Classes.Student");
        System.out.println("6. View Students & Teachers");
        System.out.println("7. Show Courses");
        System.out.println("8. Update Classes.Student Info");
        System.out.println("9. Delete Classes.Student");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddStudent() {
        System.out.println("\nAdding a new student...");

        String name = SystemUtils.readNonEmptyString("Enter student name: ");
        int age = SystemUtils.readPositiveInt("Enter student age: ");
        String email = SystemUtils.readEmailString("Enter student email: ");
        int studentId = SystemUtils.readPositiveInt("Enter student ID: "); // Change to IDGeneration
        int gradeLevel = SystemUtils.readIntInRange("Enter student grade level (1-12): ", 1, 12);

        try {
            Student student = new Student(name, age, email, studentId, gradeLevel);
            SystemUtils.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
