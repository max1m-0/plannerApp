package models;

import entity.EmployeesEntity;
import entity.TasksEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Map;

public class MonthTableModel extends AbstractTableModel {
    private final int rowCount;
    private final int columnCount;
    private final List<TasksEntity> tasksEntityList;
    private final List<EmployeesEntity> employeesEntityList;
    private final Map<Integer,String> monthMap;
    private final String selectedMonth;
    private final String selectedEmployee;

    //    private final Integer[][] date;
    public MonthTableModel(List<TasksEntity> tasksEntityList, int columnCount, Map<Integer, String> monthMap,String selectedMonth,List<EmployeesEntity> employeesEntityList,String selectedEmployee) {
        this.rowCount = tasksEntityList.size();
        this.columnCount = columnCount;
        this.tasksEntityList = tasksEntityList;
        this.monthMap = monthMap;
        this.selectedMonth = selectedMonth;
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
            case 0 -> String.class;
            default -> String.class;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        for (int i = 0; i < monthMap.size(); i++) {
            if (selectedMonth.equals(monthMap.get(i)) )
            {
                if (column == 0) {
                    return tasksEntityList.get(row).getTask();
                } else {
                    if (
                            (column > Integer.parseInt(tasksEntityList.get(row).getStartDate().substring(0, 2))
                                    && (i+1 <= Integer.parseInt(tasksEntityList.get(row).getEndDate().substring(3, 5)))
                                    && (column < Integer.parseInt(tasksEntityList.get(row).getEndDate().substring(0, 2))
                                    || ( i+1 < Integer.parseInt(tasksEntityList.get(row).getEndDate().substring(3, 5))
                            ))))
                    {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}