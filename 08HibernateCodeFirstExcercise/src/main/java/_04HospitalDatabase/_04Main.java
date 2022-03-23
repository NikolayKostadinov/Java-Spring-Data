package _04HospitalDatabase;

import net.bytebuddy.build.Plugin;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Please apply .\seed\seed_db.sql to ensure test data!!!
 */
 public class _04Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("hospitalDb")
                        .createEntityManager();
        Runnable app = new AppEngine(dbManager);
        app.run();
        dbManager.close();

    }
}
