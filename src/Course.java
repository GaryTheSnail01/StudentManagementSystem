public class Course {
    private String courseName;
    private int courseId;

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

    public String setCourseName(String courseName) {
        int length = courseName.length();
        if (length == 0) {
            return "Course name cannot be empty.";
        } else {
            this.courseName = courseName;
            return "Course name set successfully.";
        }
    }
}
