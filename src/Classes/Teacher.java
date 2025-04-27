package Classes;

import Utils.SystemUtils;

import java.util.ArrayList;

public class Teacher extends Person {
    private final int teacherId;
    private String subject;
    private ArrayList<Course> taughtCourses;

    public Teacher(String name, int age, String email, int teacherId, String subject, ArrayList<Course> taughtCourses) {
        super(name, age, email);
        this.teacherId = teacherId;
        this.subject = subject;
        this.taughtCourses = taughtCourses;
    }

    public int getTeacherId() { return teacherId; }

    public String getSubject() { return subject; }

    public void setSubject() {
        this.subject = SystemUtils.readNonEmptyString("Enter subject: ");
    }

    public ArrayList<Course> getTaughtCourses() { return taughtCourses; }

    public void addCourse(Course course) {
        int numOfCourses = getTaughtCourses().size();
        if (numOfCourses >= 3) {
            System.out.println("Teacher is already assigned 3 courses.");
        } else if (this.getTaughtCourses().contains(course)) {
            System.out.println("Teacher is already assigned to this course.");
        } else {
            taughtCourses.add(course);
            System.out.println("Course assigned successfully!");
        }
    }
}
