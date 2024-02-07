package models;

import javax.swing.*;
import java.util.Map;

public class MonthComboBoxModel {
        static Map<Integer,String> monthMap;
        public MonthComboBoxModel(Map<Integer,String> monthMap) {
            this.monthMap=monthMap;
        }
        public JComboBox returnCombobox(JComboBox jComboBox){
            for (int i = 0; i < monthMap.size(); i++) {
                jComboBox.addItem(monthMap.get(i));
            }
            return jComboBox;
        }
    }
