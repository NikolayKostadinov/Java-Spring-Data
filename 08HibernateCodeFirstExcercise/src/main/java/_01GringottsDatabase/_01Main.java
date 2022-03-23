package _01GringottsDatabase;

import javax.persistence.*;

public class _01Main {
    public static void main(String[] args) {

        EntityManager entityManager =
                Persistence.createEntityManagerFactory("gringottsDb")
                .createEntityManager();
        entityManager.close();
    }
}
