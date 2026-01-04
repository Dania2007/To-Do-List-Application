
package Main;

import java.util.ArrayList;
import java.util.Scanner;
import Exceptions.InvalidTaskException;

class Task {
    String name;
    boolean isCompleted;

    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
}

public class ToDoListApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println(" TO DO LIST APPLICATION");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task name: ");
        String name = sc.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.name +
                    " [" + (t.isCompleted ? "Completed" : "Pending") + "]");
        }
    }

    static void completeTask() {
        try {
            viewTasks();
            System.out.print("Enter task number to mark completed: ");
            int index = sc.nextInt() - 1;

            if (index < 0 || index >= tasks.size()) {
                throw new InvalidTaskException("Invalid task number selected!");
            }

            tasks.get(index).isCompleted = true;
            System.out.println("Task marked as completed!");

        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        }
    }


    static void deleteTask() {
        try {
            viewTasks();
            System.out.print("Enter task number to delete: ");
            int index = sc.nextInt() - 1;

            if (index < 0 || index >= tasks.size()) {
                throw new InvalidTaskException("Invalid task number selected!");
            }

            tasks.remove(index);
            System.out.println("Task deleted!");

        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    }

