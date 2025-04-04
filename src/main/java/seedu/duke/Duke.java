package seedu.duke;

import java.util.Scanner;

import seedu.duke.data.User;
import seedu.duke.data.UserData;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static CommandParser commandParser = new CommandParser();
    public static User currentUser = new User();
    public static UserData userData = new UserData("data/user.txt");

    public static void main(String[] args) {
        System.out.println("Welcome to Grand Rhombus, your personal CEG Assistant");

        currentUser = userData.loadUserData();
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter command: ");

            if (!in.hasNextLine()) {  // Prevent NoSuchElementException
                break;
            }

            String userInput = in.nextLine().trim();
            isRunning = commandParser.parseCommand(userInput); // If parseCommand returns true, exit loop

        }

        userData.saveUserData(currentUser);
        in.close(); // Close scanner when the program exits
        System.out.println("Goodbye, thank you for using Grand Rhombus"); // Handle exit command

    }
}
