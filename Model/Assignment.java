package Model;

public class Assignment {
    private int id;
    private String className;
    private String details;

    public Assignment(int id, String className, String details) {
        this.id = id;
        this.className = className;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getDetails() {
        return details;
    }
}
