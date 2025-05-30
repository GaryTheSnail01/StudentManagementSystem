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

    public static void deleteStudent(Student student) { students.remove(student); }

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

    public static Student searchStudentID(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    public static Teacher searchTeacherID(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public static Course searchCourseID(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    public static void printStudentInfo(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Age: " + student.getAge());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Grade Level: " + student.getGradeLevel());

        ArrayList<Course> courseList = student.getEnrolledCourses();
        System.out.println("Enrolled Courses: ");
        if (!courseList.isEmpty()) {
            for (Course course : courseList) {
                System.out.println(course.getCourseName());
            }
        } else {
            System.out.println("None...");
        }
    }

    public static void printStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", ID: " + student.getStudentId());
        }
    }

    public static void printTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getName() + ", ID: " + teacher.getTeacherId());
        }
    }

    public static void printCourses() {
        for (Course course : courses) {
            System.out.println("Name: " + course.getCourseName() + ", ID: " + course.getCourseId());
        }
    }

}
