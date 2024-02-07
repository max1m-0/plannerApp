package models;

import entity.EmployeesEntity;
import entity.TasksEntity;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class TaskTableModel extends AbstractTableModel {
    private final int rowCount;
    private final int columnCount;
    private final List<TasksEntity> tasksEntityList;
    private final List<EmployeesEntity> employeesEntityList;
    private final String selectedEmployee;

    public TaskTableModel(List<TasksEntity> tasksEntityList, int columnCount, List<EmployeesEntity> employeesEntityList, String selectedEmployee) {
        this.rowCount = tasksEntityList.size();
        this.columnCount = columnCount;
        this.tasksEntityList = tasksEntityList;
        this.employeesEntityList = employeesEntityList;
        this.selectedEmployee = selectedEmployee;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return switch (column) {
            case 0 -> Boolean.class;
            case 1, 2, 3, 4 -> String.class;
            default -> Object.class;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        for (int i = 0; i < employeesEntityList.size(); i++) {
            if (selectedEmployee.equals(employeesEntityList.get(i).getFullName())) {
                return switch (column) {
                    case 0 -> tasksEntityList.get(row).getCompleted();
                    case 1 -> tasksEntityList.get(row).getTask();
                    case 2 -> tasksEntityList.get(row).getStartDate();
                    case 3 -> tasksEntityList.get(row).getEndDate();
                    case 4 -> tasksEntityList.get(row).getCompletedDate();
                    default -> true;
                };
            }
        }
        return false;
    }
}