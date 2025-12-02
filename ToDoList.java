import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        
        System.out.print("How many things do you have to get done? ");
        int numTasks = console.nextInt();

        console.nextLine(); 
        
        List<String> todoList = new ArrayList<>();
        int originalTaskCount = numTasks; 

        System.out.println("Type each thing you have to do then press enter");
        
        for (int k = 0; k < numTasks; k++) {
            String task = console.nextLine(); 
            todoList.add(task); 
        }

        while (!todoList.isEmpty()) {
            clearScreen(); 
            
            System.out.println("********** To Do List **********\n");
            
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
            
            System.out.println("\nEnter which number you completed: ");
            int completedTaskIndex = -1; 
            
            try {
                completedTaskIndex = console.nextInt();
                console.nextLine(); 
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.");
                console.nextLine();
                continue;
            }

            if (completedTaskIndex > 0 && completedTaskIndex <= todoList.size()) {
                todoList.remove(completedTaskIndex - 1); 
            } else {
                System.out.println("\nThat number is not on your list \nPlease try again");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    
        clearScreen();
        System.out.println("\nCongratulations! You have completed all your tasks!");
        
        console.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
