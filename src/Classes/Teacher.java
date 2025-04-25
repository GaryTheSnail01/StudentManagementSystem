package Classes;

import java.util.ArrayList;

public class Teacher extends Person {
    private final int teacherId;
    private String subject;
    private ArrayList<Course> taughtCourses;

    public Teacher(String name, int age, String email, int teacherId, String subject) {
        super(name, age, email);
        this.teacherId = teacherId;
        this.subject = subject;
        taughtCourses = new ArrayList<>();
    }

    public int getTeacherId() { return teacherId; }

    public String getSubject() { return subject; }

    public ArrayList<Course> getTaughtCourses() { return taughtCourses; }

    public void addCourse(Course course) {
        int numOfCourses = taughtCourses.size();
        if (numOfCourses >= 3) {
            System.out.println("Teacher is already assigned 3 courses.");
        } else {
            taughtCourses.add(course);
            System.out.println("Course assigned successfully!");
        }
    }
}
