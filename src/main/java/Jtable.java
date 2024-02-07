import daos.SampleServiceDAO;
import entity.EmployeesEntity;
import entity.TasksEntity;
import models.EmployeeComboBoxModel;
import models.MonthComboBoxModel;
import models.MonthTableModel;
import models.TaskTableModel;
import utils.ColorUtil;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class Jtable extends JDialog {
    private JPanel contentPane;
    private JRadioButton collapseButton;
    private JRadioButton closeButton;
    private JRadioButton hideButton;
    private JComboBox fullNameComboBox;
    private JButton mainCloseButton;
    private JTabbedPane taskPanel;
    private JTable tasksTable;
    private JTable plansTable;
    private JComboBox monthComboBox;
    private JPanel tasksPanel;
    private JPanel plansPanel;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Jtable(SampleServiceDAO sampleServiceDAO, int columnCount, List<EmployeesEntity> employeesEntityList, Map<Integer,String> monthMap, int monthTableColumnCount){
        setContentPane(contentPane);

        setModal(true);

        mainCloseButton.addActionListener(e -> onClose());

        collapseButton.addActionListener(e -> onClose());

        closeButton.addActionListener(e -> onCollapse());

        hideButton.addActionListener(e -> onHide());

        contentPane.registerKeyboardAction(e -> onClose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        EmployeeComboBoxModel employeeComboBoxModel = new EmployeeComboBoxModel(employeesEntityList);
        fullNameComboBox.setModel(employeeComboBoxModel.returnCombobox(fullNameComboBox).getModel());
        fullNameComboBox.addActionListener(e -> switchEmployee(employeesEntityList,monthMap,sampleServiceDAO.findAllTasksForEmployee(fullNameComboBox.getSelectedIndex()+1),monthTableColumnCount,columnCount));
        fullNameComboBox.setSelectedItem(employeesEntityList.getFirst().getFullName());

        MonthComboBoxModel monthComboBoxModel = new MonthComboBoxModel(monthMap);
        monthComboBox.setModel(monthComboBoxModel.returnCombobox(monthComboBox).getModel());
        monthComboBox.addActionListener(e -> switchMonth(monthMap,sampleServiceDAO.findAllTasksForEmployee(fullNameComboBox.getSelectedIndex()+1),monthTableColumnCount,employeesEntityList, (String) fullNameComboBox.getSelectedItem()));
        monthComboBox.setSelectedItem(monthMap.get(0));
    }

    private void switchEmployee(List<EmployeesEntity> employeesEntityList,Map<Integer,String> monthMap,List<TasksEntity> tasksList,int monthTableColumnCount,int columnCount){
        for (int i = 0; i < fullNameComboBox.getItemCount(); i++) {
                if (fullNameComboBox.getSelectedItem().equals(employeesEntityList.get(i).getFullName())){
                switchMonth(monthMap,tasksList,monthTableColumnCount,employeesEntityList, (String) fullNameComboBox.getSelectedItem());
                TaskTableModel taskTableModel = new TaskTableModel(tasksList,columnCount,employeesEntityList, (String) fullNameComboBox.getSelectedItem());
                tasksTable.setModel(taskTableModel);
            }
            }
    }

    private void switchMonth(Map<Integer,String> monthMap,List<TasksEntity> tasksList,int monthTableColumnCount,List<EmployeesEntity> employeesEntityList,String selectedEmployee){
        ColorUtil colorUtil = new ColorUtil();
        for (int i = 0; i < monthComboBox.getItemCount(); i++) {
            if (monthComboBox.getSelectedItem() == monthMap.get(i))
            {
                MonthTableModel monthTableModel = new MonthTableModel(tasksList,monthTableColumnCount,monthMap,monthMap.get(i),employeesEntityList,selectedEmployee);
                plansTable.setModel(monthTableModel);
                for (int j = 0; j < monthTableModel.getColumnCount(); j++) {
                    for (int k = 0; k < monthTableModel.getRowCount(); k++) {
                        if (String.valueOf(monthTableModel.getValueAt(k, j)).equals("true"))
                        {
                            colorUtil.changeTable(plansTable,j);
                        }
                    }
                }

            }
        }

    }
    private void onClose() {
        dispose();
    }

    private void onCollapse() {
        dispose();
    }

    private void onHide() {
        dispose();
    }
}
