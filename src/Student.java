import java.util.ArrayList;

public class Student extends Person {
    private int studentId;
    private int gradeLevel;
    private ArrayList<Course> enrolledCourses;

    public Student(String name, int age, String email) {
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

    public String addCourse(Course course) {
        int numOfCourses = enrolledCourses.size();
        if (numOfCourses >= 5) {
            return "Student is already enrolled in 5 courses.";
        } else {
            enrolledCourses.add(course);
            return "Course added successfully.";
        }
    }
}
