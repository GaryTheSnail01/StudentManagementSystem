import java.util.ArrayList;

public class StudentManagementSystem {
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Teacher> TeacherList = new ArrayList<>();
    public static ArrayList<Course> CourseList = new ArrayList<>();

    public static void main(String[] args) {
        String response = "";

        while (!response.equals("exit")) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Assign Courses");
            System.out.println("5. Search Student");
            System.out.println("6. View Students & Teachers");
            System.out.println("7. Show Courses");
            System.out.println("8. Update Student Info");
            System.out.println("9. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                response = new java.util.Scanner(System.in).nextLine();
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            switch (response) {
                case "1":
                    // Add Student
                    break;
                case "2":
                    // Add Teacher
                    break;
                case "3":
                    // Add Course
                    break;
                case "4":
                    // Assign Courses
                    break;
                case "5":
                    // Search Student
                    break;
                case "6":
                    // View Students & Teachers
                    break;
                case "7":
                    // Show Courses
                    break;
                case "8":
                    // Update Student Info
                    break;
                case "9":
                    // Delete Student
                    break;
                case "0":
                    // Exit
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
