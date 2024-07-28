package View;

import java.util.Scanner;

public class VirtualClassroomView {
    private Scanner scanner;

    public VirtualClassroomView() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        System.out.println("Enter command: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
