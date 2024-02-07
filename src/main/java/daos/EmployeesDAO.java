package daos;

import entity.EmployeesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeesDAO {

    public EmployeesEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeesEntity.class, id);
    }

    public void save(EmployeesEntity EmployeesEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(EmployeesEntity);
        tx1.commit();
        session.close();
    }

    public void update(EmployeesEntity EmployeesEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
            session.update(EmployeesEntity);
        tx1.commit();
        session.close();
    }

    public void delete(EmployeesEntity EmployeesEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(EmployeesEntity);
        tx1.commit();
        session.close();
    }

    public EmployeesEntity findEmployeeById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeesEntity.class, id);
    }

    public List<EmployeesEntity> findAllEmployees() {
        List<EmployeesEntity> employees = (List<EmployeesEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeesEntity").list();
        return employees;
    }
}

