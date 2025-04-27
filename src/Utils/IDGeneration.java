package Utils;

public class IDGeneration {
    private static int nextStudentID = 1000;
    private static int nextTeacherID = 2000;
    private static int nextCourseID = 3000;

    public static int generateStudentID() {
        nextStudentID++;
        return nextStudentID;
    }

    public static int generateTeacherID() {
        nextTeacherID++;
        return nextTeacherID;
    }

    public static int generateCourseID() {
        nextCourseID++;
        return nextCourseID;
    }
}
