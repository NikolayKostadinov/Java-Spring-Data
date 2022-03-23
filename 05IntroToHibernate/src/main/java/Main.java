import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("school");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        Student student = new Student("emo");
//        entityManager.persist(student);
        Teacher teacher = new Teacher("Pesho", LocalDate.now());
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
