package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees", schema = "workers")
public class EmployeesEntity {
    @Basic
    @Column(name = "full_name", nullable = true, length = 30)
    private String fullName;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_empl", nullable = false)
    private int idEmpl;

    public String getFullName() {
        return fullName;
    }

    public int getIdEmpl() {
        return idEmpl;
    }
}
