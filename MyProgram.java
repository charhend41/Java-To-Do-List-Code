import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {

        // Use only one Scanner object for the entire program
        Scanner console = new Scanner(System.in);
        
        System.out.print("How many things do you have to get done? ");
        int numTasks = console.nextInt(); // Read the integer input

        // This line is needed to fix a common Scanner bug.
        // nextInt() reads only the number, leaving the newline character (\n)
        // in the input buffer. This call clears the buffer.
        console.nextLine(); 
        
        // Use an ArrayList to store the tasks dynamically
        List<String> todoList = new ArrayList<>();
        int originalTaskCount = numTasks; // Store the initial number of tasks

        System.out.println("Type each thing you have to do then press enter");

        // The 'for' loop uses the 'numTasks' variable to control its execution.
        for (int k = 0; k < numTasks; k++) {
            String task = console.nextLine(); // Read the full line of text
            todoList.add(task); // Add the task to the list
        }

        // Loop until all tasks are completed
        while (!todoList.isEmpty()) {
            // This method uses ANSI escape codes to clear the screen and move the cursor to the top
            clearScreen(); 

            // Print the header
            System.out.println("********** To Do List **********\n");
            
            // Print the numbered list of remaining tasks
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
            
            System.out.println("\nEnter which number you completed: ");
            int completedTaskIndex = -1; // Initialize with an invalid value
            
            try {
                completedTaskIndex = console.nextInt();
                console.nextLine(); // Consume the rest of the line
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.");
                console.nextLine(); // Consume the invalid input
                continue; // Skip the rest of the loop and start over
            }

            // Ensure the user's input is valid
            if (completedTaskIndex > 0 && completedTaskIndex <= todoList.size()) {
                // Remove the completed task from the list using the user-provided index
                todoList.remove(completedTaskIndex - 1); 
            } else {
                System.out.println("\nThat number is not on your list \nPlease try again");
                // Wait for the user to see the message before continuing
                try {
                    Thread.sleep(2000); // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Clear the screen one last time before showing the final message
        clearScreen();
        System.out.println("\nCongratulations! You have completed all your tasks!");
        
        // Always close the Scanner when you are done with it
        console.close();
    }

    /**
     * Clears the console screen using ANSI escape codes.
     * Note: This method may not work on all console environments (e.g., standard Eclipse console).
     * It generally works on most modern terminal emulators (like those on macOS, Linux, and modern Windows terminals).
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}