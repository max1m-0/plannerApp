package entity;

import jakarta.persistence.*;
import utils.StringToFormatDateUtil;

@Entity
@Table(name = "tasks", schema = "workers")
public class TasksEntity {

    @Basic
    @Column(name = "completed", nullable = true)
    private Byte completed;
    @Basic
    @Column(name = "task", nullable = true, length = 30)
    private String task;
    @Basic
    @Column(name = "start_date", nullable = true)
    private String startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private String endDate;
    @Basic
    @Column(name = "completed_date", nullable = true)
    private String completedDate;
    @Basic
    @Column(name = "id_empl", nullable = true)
    private int idEmpl;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_task", nullable = false)
    private int idTask;

    public boolean getCompleted() {
        return  (completed != 0);
    }

    public String getTask() {
        return task;
    }

    public String getStartDate(){
        return StringToFormatDateUtil.format(startDate);
    }


    public String getEndDate() {
        return StringToFormatDateUtil.format(endDate);
    }


    public String getCompletedDate() {
        return StringToFormatDateUtil.format(completedDate);
    }


    public Integer getIdEmpl() {
        return idEmpl;
    }


    public int getIdTask() {
        return idTask;
    }

}
