import Classes.Course;
import Classes.Student;
import Classes.Teacher;
import Utils.SystemUtils;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int response = -1;

        // Course and student added for testing/debugging
        Course course1 = new Course("History", 1);
        Student student1 = new Student("Test", 1, "gary@mail.com", 2, 1);
        SystemUtils.addCourse(course1);
        SystemUtils.addStudent(student1);

        while (response != 0) {
            showMenu();

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
                    handleAssignCourse();
                    break;
                case 5:
                    handleSearchStudent();
                    break;
                case 6:
                    displayStudentsAndTeachers();
                    break;
                case 7:
                    displayCourses();
                    break;
                case 8:
                    // Update Student Info
                    break;
                case 9:
                    // Delete Student
                    break;
                case 0:
                    System.out.println("Closing program... Goodbye!");
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

    public static void handleAssignCourse() {
        System.out.println("Assigning a course...");
        Student student;
        Teacher teacher;
        Course course;

        while (true) {
            int personID = SystemUtils.readPositiveInt("Enter the student/teacher ID: ");
            student = SystemUtils.searchStudentID(personID);
            teacher = SystemUtils.searchTeacherID(personID);
            if (student != null || teacher != null) {
                break; // If a student or teacher is found, we break the while loop
            }
            System.out.println("Invalid ID. Please try again.");
        }

        while (true) {
            int courseID = SystemUtils.readPositiveInt("Enter the course ID: ");
            course = SystemUtils.searchCourseID(courseID);
            if (course != null) {
                break;
            }
            System.out.println("Invalid course ID. Please try again.");
        }

        if (student != null) {
            try {
                student.addCourse(course);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            try {
                teacher.addCourse(course);
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        }
    }

    public static void handleSearchStudent() {
        System.out.println("Searching for a student...");
        Student searchedStudent;

        while (true) {
            int ID = SystemUtils.readPositiveInt("Enter student ID: ");

            searchedStudent = SystemUtils.searchStudentID(ID);
            if (searchedStudent != null) {
                break;
            }
        }
        SystemUtils.printStudentInfo(searchedStudent);
    }

    public static void displayStudentsAndTeachers() {
        System.out.println("Students:");
        SystemUtils.printStudents();

        System.out.println("\nTeachers:");
        SystemUtils.printTeachers();
    }

    public static void displayCourses() {
        System.out.println("Courses:");
        SystemUtils.printCourses();
    }

    public static void updateStudentInfo() {
        System.out.println("Updating student info...");
        Student student;

        while (true) {
            int ID = SystemUtils.readPositiveInt("Enter student ID: ");
            student = SystemUtils.searchStudentID(ID);

            if (student != null) {
                break;
            }
            System.out.println("Student not found. Please try again.");
        }

        System.out.println("Options:");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Email");
        System.out.println();

    }

}
