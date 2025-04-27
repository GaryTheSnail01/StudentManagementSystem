import Classes.Course;
import Classes.Student;
import Classes.Teacher;
import Utils.IDGeneration;
import Utils.SystemUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int response = -1;

        // Course and student added for testing/debugging
        Course course1 = new Course("History", IDGeneration.generateCourseID());
        Student student1 = new Student("Test", 1, "gary@mail.com",
                IDGeneration.generateStudentID(), 1, new ArrayList<Course>());
        Teacher teacher1 = new Teacher("Beth", 100, "teach@school.net",
                IDGeneration.generateTeacherID(), "History", new ArrayList<Course>());
        SystemUtils.addCourse(course1);
        SystemUtils.addStudent(student1);
        SystemUtils.addTeacher(teacher1);

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
                    handleUpdateStudentInfo();
                    break;
                case 9:
                    handleDeleteStudent();
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
        int studentId = IDGeneration.generateStudentID();
        int gradeLevel = SystemUtils.readIntInRange("Enter student grade level (1-12): ", 1, 12);
        ArrayList<Course> enrolledCourses = new ArrayList<>();

        try {
            Student student = new Student(name, age, email, studentId, gradeLevel, enrolledCourses);
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
        int teacherID = IDGeneration.generateTeacherID();
        String subject = SystemUtils.readNonEmptyString("Enter teacher's taught subject: ");
        ArrayList<Course> taughtCourses = new ArrayList<>();

        try {
            Teacher teacher = new Teacher(name, age, email, teacherID, subject, taughtCourses);
            SystemUtils.addTeacher(teacher);
            System.out.println("Teacher added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void handleAddCourse() {
        System.out.println("Creating a New Course...");

        String name = SystemUtils.readNonEmptyString("Enter the name of the course: ");
        int courseID = IDGeneration.generateCourseID();

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

    public static void handleUpdateStudentInfo() {
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

        SystemUtils.printStudentInfo(student);

        System.out.println("\nOptions:");
        System.out.println("\n1. Name");
        System.out.println("2. Age");
        System.out.println("3. Email");
        System.out.println("4. Grade Level");
        int selection = SystemUtils.readIntInRange("Select an option: ", 1, 4);

        switch (selection) {
            case 1:
                student.setName();
                System.out.println("Name changed successfully!");
                break;
            case 2:
                student.setAge();
                System.out.println("Age changed successfully!");
                break;
            case 3:
                student.setEmail();
                System.out.println("Email changed successfully!");
            case 4:
                student.setGradeLevel();
                System.out.println("Grade level changed successfully!");
        }

    }

    public static void handleDeleteStudent() {
        System.out.println("Deleting a student...");
        System.out.println("Enter '0' to return to the main menu.");

        while (true) {
            int studentID = SystemUtils.readPositiveInt("Enter student ID: ");
            if (studentID == 0) {
                System.out.println("Returning to main menu...");
                return;
            }

            Student student = SystemUtils.searchStudentID(studentID);
            if (student == null) {
                System.out.println("Student not found. Please try again.");
                continue; // Ask again
            }

            System.out.println("You are about to delete " + student.getName() + " from the database...");
            int confirm = SystemUtils.readIntInRange("Enter '1' to confirm, or '0' to cancel: ", 0, 1);

            if (confirm == 0) {
                System.out.println("Student deletion canceled...");
                return;
            } else {
                SystemUtils.deleteStudent(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
    }

}
