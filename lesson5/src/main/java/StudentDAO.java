import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentDAO {
    private EntityManagerFactory entityManagerFactory;
    //  private EntityManager em;

    public List<Student> getAll() {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        final List<Student> students = em.createQuery("from Student", Student.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return students;
    }

    public void save(final Student student) {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public Student getById(final long id) {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        final Student student = em.find(Student.class, id);
        em.getTransaction().commit();
        em.close();
        return student;
    }

    public void update(final Student student) {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
//        final Student updatedStudent = getById(student.getId());
//        updatedStudent.setName(student.getName());
//        updatedStudent.setMark(student.getMark());
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(final Student student) {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            final Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Student.class);
            entityManagerFactory = configuration.buildSessionFactory();
        }
        return this.entityManagerFactory;


    }
}
