package daos;

import entity.EmployeesEntity;
import entity.TasksEntity;

import java.util.*;

public class SampleServiceDAO {

    private final TasksDAO taskDAO = new TasksDAO();
    private final EmployeesDAO employeesDAO = new EmployeesDAO();

    public SampleServiceDAO() {
    }

    public TasksEntity findTask(int id) {
        return taskDAO.findById(id);
    }

    public void saveTask(TasksEntity TasksEntity) {
        taskDAO.save(TasksEntity);
    }

    public void deleteTask(TasksEntity TasksEntity) {
        taskDAO.delete(TasksEntity);
    }

    public void updateTask(TasksEntity TasksEntity) {
        taskDAO.update(TasksEntity);
    }

    public List<TasksEntity> findAllTasks() {
        return taskDAO.findAllTasks();
    }

    public List<TasksEntity> findAllTasksForEmployee(int idEmpl) {
        List<TasksEntity> tasks = taskDAO.findAllTasks();
        List<TasksEntity> sortedTasks = new ArrayList<>();

            for (int j = 0; j < tasks.size(); j++) {
                if (tasks.get(j).getIdEmpl() == idEmpl)
                {
                    sortedTasks.add(tasks.get(j));
                }
        }
        return sortedTasks;
    }

    public int getTaskColumnCount(){
        return taskDAO.getColumnsCount();
    }

    public EmployeesEntity findEmployee(int id) {
        return employeesDAO.findById(id);
    }

    public void saveEmployee(EmployeesEntity employeesEntity) {
        employeesDAO.save(employeesEntity);
    }

    public void deleteEmployee(EmployeesEntity employeesEntity) {
        employeesDAO.delete(employeesEntity);
    }

    public void updateEmployee(EmployeesEntity employeesEntity) {
        employeesDAO.update(employeesEntity);
    }

    public List<EmployeesEntity> findAllEmployees() {
        return employeesDAO.findAllEmployees();
    }

}
