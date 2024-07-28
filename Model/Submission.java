package Model;

public class Submission {
    private int id;
    private String studentId;
    private String className;
    private String assignmentDetails;

    public Submission(int id, String studentId, String className, String assignmentDetails) {
        this.id = id;
        this.studentId = studentId;
        this.className = className;
        this.assignmentDetails = assignmentDetails;
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

    public String getAssignmentDetails() {
        return assignmentDetails;
    }
}
