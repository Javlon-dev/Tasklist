package com.company.service;

import com.company.dto.TaskListDTO;
import com.company.repository.TaskRepository;

public class TaskService {

    private TaskRepository taskRepository = new TaskRepository();

    public String showTaskList() {
        String result = taskRepository.selectTaskList();
        if (!result.isEmpty()) {
            return result;
        }
        return "You haven't tasks, please try again!";
    }

    public boolean createTask(TaskListDTO dto) {
        return taskRepository.createTask(dto) > 0;
    }

    public boolean checkById(int id) {
        return taskRepository.checkById(id);
    }

    public boolean updateTask(TaskListDTO dto, int id) {
        return taskRepository.updateTask(dto,id) > 0;
    }

    public boolean deleteTask(int id) {
        return taskRepository.deleteTask(id) > 0;
    }

    public boolean doneTask(int id) {
        return taskRepository.doneTask(id) > 0;
    }
}
