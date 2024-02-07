package daos;

import entity.TasksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class TasksDAO {

    public TasksEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TasksEntity.class, id);
    }

    public void save(TasksEntity TasksEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(TasksEntity);
        tx1.commit();
        session.close();
    }

    public void update(TasksEntity TasksEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
            session.update(TasksEntity);
        tx1.commit();
        session.close();
    }

    public void delete(TasksEntity TasksEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(TasksEntity);
        tx1.commit();
        session.close();
    }

    public List<TasksEntity> findAllTasks() {
        List<TasksEntity> employees = (List<TasksEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TasksEntity").list();
        return employees;
    }

    public int getColumnsCount() {
        int a = 5;
        return a;

    }
}

