package models;

import entity.EmployeesEntity;
import javax.swing.*;
import java.util.List;

public class EmployeeComboBoxModel {
    static List<EmployeesEntity> employeesFullNameList;
    public EmployeeComboBoxModel(List<EmployeesEntity> employeesFullNameList) {
        this.employeesFullNameList=employeesFullNameList;
    }
    public JComboBox returnCombobox(JComboBox jComboBox){
        for (int i = 0; i < employeesFullNameList.size(); i++) {
            jComboBox.addItem(employeesFullNameList.get(i).getFullName());
        }
        return jComboBox;
    }

}
