package Classes;

import Utils.SystemUtils;

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

    public void setCourseName() {
        this.courseName = SystemUtils.readNonEmptyString("Enter the course's name: ");
    }

    public int getCourseId() {
        return courseId;
    }

}
