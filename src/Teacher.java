import java.util.ArrayList;

public class Teacher extends Person {
    private int teacherId;
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

    public String addCourse(Course course) {
        int numOfCourses = taughtCourses.size();
        if (numOfCourses >= 3) {
            return "Teacher is already teaching 3 courses.";
        } else {
            taughtCourses.add(course);
            return "Course added successfully.";
        }
    }
}
