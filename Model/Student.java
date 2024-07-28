package Model;

public class Student {
    private int id;
    private String studentId;
    private String className;

    public Student(int id, String studentId, String className) {
        this.id = id;
        this.studentId = studentId;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }
}
