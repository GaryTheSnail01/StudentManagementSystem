package Utils;
import Classes.Course;
import Classes.Student;
import Classes.Teacher;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SystemUtils {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    // Add methods for adding teachers, courses, and assigning courses
    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void addTeacher(Teacher teacher) { teachers.add(teacher); }

    public static void addCourse(Course course) { courses.add(course); }



    // Reusable methods for reading user input
    public static String readNonEmptyString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) { // If the input is not empty, return it
                return input;
            }

            System.out.println("Input cannot be empty. Please try again."); // Prompt the user to try again if the input is empty
        }
    }

    public static int readPositiveInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine()); // Convert the string into an int

                if (input >= 0) {
                    return input;
                }
                System.out.println("Input cannot be negative. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static int readIntInRange(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());

                if (input >= min && input <= max) return input;
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    //readEmail
    public static String readEmailString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty. Please enter a valid email address.");
                    continue;
                }

                // Regular expression (Regex) to match with valid email formats
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                // Compile Regex
                Pattern p = Pattern.compile(emailRegex);

                // Check to see if user's input matches with the valid pattern
                if (p.matcher(input).matches()) {
                    return input;
                }
                System.out.println("Please enter a valid email address.");
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid email address.");
            }
        }
    }

}
