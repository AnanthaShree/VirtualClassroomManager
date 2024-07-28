package Controller;

import View.VirtualClassroomView;
import Model.Classroom;
import Model.Student;
import Model.Assignment;
import Model.Submission;
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import View.VirtualClassroomView;
import Model.DatabaseConnection;

public class VirtualClassroomController {
    private static final Logger logger = Logger.getLogger(VirtualClassroomController.class.getName());
    private VirtualClassroomView view;

    public VirtualClassroomController(VirtualClassroomView view) {
        this.view = view;
    }

    public void handleInput(String command) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (command.startsWith("add_classroom")) {
                addClassroom(connection, command);
            } else if (command.startsWith("add_student")) {
                addStudent(connection, command);
            } else if (command.startsWith("schedule_assignment")) {
                scheduleAssignment(connection, command);
            } else if (command.startsWith("submit_assignment")) {
                submitAssignment(connection, command);
            } else {
                view.displayMessage("Unknown command.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error: ", e);
        }
    }

    private void addClassroom(Connection connection, String command) throws SQLException {
        String[] parts = command.split(" ", 2);
        String className = parts[1];

        String query = "INSERT INTO classrooms (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, className);
            statement.executeUpdate();
            view.displayMessage("Classroom " + className + " has been created.");
        }
    }

    private void addStudent(Connection connection, String command) throws SQLException {
        String[] parts = command.split(" ", 3);
        String studentId = parts[1];
        String className = parts[2];

        String query = "INSERT INTO students (student_id, class_name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentId);
            statement.setString(2, className);
            statement.executeUpdate();
            view.displayMessage("Student " + studentId + " has been enrolled in " + className + ".");
        }
    }

    private void scheduleAssignment(Connection connection, String command) throws SQLException {
        String[] parts = command.split(" ", 3);
        String className = parts[1];
        String assignmentDetails = parts[2];

        String query = "INSERT INTO assignments (class_name, details) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, className);
            statement.setString(2, assignmentDetails);
            statement.executeUpdate();
            view.displayMessage("Assignment for " + className + " has been scheduled.");
        }
    }

    private void submitAssignment(Connection connection, String command) throws SQLException {
        String[] parts = command.split(" ", 4);
        String studentId = parts[1];
        String className = parts[2];
        String assignmentDetails = parts[3];

        String query = "INSERT INTO submissions (student_id, class_name, assignment_details) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentId);
            statement.setString(2, className);
            statement.setString(3, assignmentDetails);
            statement.executeUpdate();
            view.displayMessage("Assignment submitted by Student " + studentId + " in " + className + ".");
        }
    }
}
