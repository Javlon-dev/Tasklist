package com.company;

import com.company.components.ComponentController;
import com.company.controller.TaskController;

public class Main {

    private static TaskController taskController = new TaskController();

    public static void main(String[] args) {
        try {
            taskController = new TaskController();
            int action;
            while (true) {
                taskController.showMenu();
                System.out.print("Enter your action -> ");
                action = ComponentController.getAction();
                switch (action) {
                    case 1 -> {
                        System.out.println("\n----TASK LIST----");
                        taskController.showTaskList();
                    }
                    case 2 -> {
                        System.out.println("\n----CREATE TASK----");
                        taskController.createTask();
                    }
                    case 3 -> {
                        System.out.println("\n----UPDATE TASK----");
                        taskController.updateTask();
                    }
                    case 4 -> {
                        System.out.println("\n----DELETE TASK----");
                        taskController.deleteTask();
                    }
                    case 5 -> {
                        System.out.println("\n----DONE TASK----");
                        taskController.doneTask();
                    }
                    case 0 -> {
                        System.out.println("Goodbye!!!");
                        return;
                    }
                    default -> System.out.println("\nError [-_-] try again!\n");
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
