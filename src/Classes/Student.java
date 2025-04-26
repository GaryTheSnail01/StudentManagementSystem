package Classes;

import Utils.SystemUtils;

import java.util.ArrayList;

public class Student extends Person {
    private final int studentId;
    private int gradeLevel;
    private ArrayList<Course> enrolledCourses;

    public Student(String name, int age, String email, int studentId, int gradeLevel) {
        super(name, age, email);
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
        enrolledCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        int numOfCourses = enrolledCourses.size();
        if (numOfCourses >= 5) {
            System.out.println("Student is already enrolled in 5 courses.");
        } else {
            enrolledCourses.add(course);
            System.out.println("Course added successfully!");
        }
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = SystemUtils.readIntInRange("Enter grade level: ", 1, 12);
    }

}
