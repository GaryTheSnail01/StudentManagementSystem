import java.util.ArrayList;

public class Teacher extends Person {
    private int teacherId;
    private String subject;
    private ArrayList<Course> taughtCourses;

    public Teacher(String name, int age, String email) {
        super(name, age, email);
        this.teacherId = teacherId;
        this.subject = subject;
        taughtCourses = new ArrayList<>();
    }
}
