package com.company.components;

import com.company.controller.TaskController;
import com.company.repository.TaskRepository;
import com.company.service.TaskService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public interface ComponentController {
    Scanner scanner = new Scanner(System.in);

    String TASK_TABLE = "task_table";

    static int getAction() {
        return scanner.nextInt();
    }

    static String getLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
