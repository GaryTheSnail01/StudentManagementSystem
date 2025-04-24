package Classes;

public class Course {
    private String courseName;
    private final int courseId;

    public Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseId() {
        return courseId;
    }

//    public String setCourseName(String courseName) {
//
//        }
//    }
}
