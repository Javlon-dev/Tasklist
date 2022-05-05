package com.company.controller;

import com.company.components.ComponentController;
import com.company.dto.TaskListDTO;
import com.company.service.TaskService;

public class TaskController {

    private TaskService taskService = new TaskService();

    public void showTaskList() {
        System.out.println(taskService.showTaskList());
    }

    public void createTask() {
        TaskListDTO dto = new TaskListDTO();
        System.out.print("Enter Title -> ");
        dto.setTitle(ComponentController.getLine());
        System.out.print("Enter Content -> ");
        dto.setContent(ComponentController.getLine());
        boolean check = taskService.createTask(dto);
        if (check)
            System.out.println("Successfully added!");
        else
            System.out.println("Unsuccessfully, try again!");
    }

    public void updateTask() {
        System.out.print("Enter task id -> ");
        int id = ComponentController.getAction();

        boolean check = taskService.checkById(id);
        if (!check) {
            System.out.println("Wrong id!");
            return;
        }
        TaskListDTO dto = new TaskListDTO();
        System.out.print("Enter Title -> ");
        dto.setTitle(ComponentController.getLine());
        System.out.print("Enter Content -> ");
        dto.setContent(ComponentController.getLine());
        check = taskService.updateTask(dto, id);
        if (check)
            System.out.println("Successfully updated!");
        else
            System.out.println("Unsuccessfully, try again!");

    }

    public void deleteTask() {
        System.out.print("Enter task id -> ");
        int id = ComponentController.getAction();

        boolean check = taskService.checkById(id);
        if (!check) {
            System.out.println("Wrong id!");
            return;
        }
        check = taskService.deleteTask(id);
        if (check)
            System.out.println("Successfully deleted!");
        else
            System.out.println("Unsuccessfully, try again!");

    }

    public void doneTask() {
        System.out.print("Enter task id -> ");
        int id = ComponentController.getAction();

        boolean check = taskService.checkById(id);
        if (!check) {
            System.out.println("Wrong id!");
            return;
        }
        check = taskService.doneTask(id);
        if (check)
            System.out.println("Successfully updated!");
        else
            System.out.println("Unsuccessfully, try again!");

    }

    public void showMenu() {
        System.out.println("----MENU----");
        System.out.println("1.Task list");
        System.out.println("2.Create task");
        System.out.println("3.Update task");
        System.out.println("4.Delete task");
        System.out.println("5.Mark as done task");
        System.out.println("0.Quit");
    }
}
