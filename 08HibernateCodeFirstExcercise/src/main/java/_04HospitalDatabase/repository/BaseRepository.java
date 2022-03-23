package _04HospitalDatabase.repository;

import javax.persistence.EntityManager;

public abstract class BaseRepository {
    private final EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }
}
