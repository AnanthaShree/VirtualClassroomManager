import Controller.VirtualClassroomController;
import View.VirtualClassroomView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomView view = new VirtualClassroomView();
        VirtualClassroomController controller = new VirtualClassroomController(view);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter command (add_classroom, add_student, schedule_assignment, submit_assignment, exit):");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                exit = true;
            } else {
                controller.handleInput(command);
            }
        }
        scanner.close();
    }
}
