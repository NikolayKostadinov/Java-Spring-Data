package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.TownModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

    public class TownRepositoryImpl extends BaseRepository implements Repository<Town, TownModel, Integer> {
    public TownRepositoryImpl(EntityManager em) {
        super(em);
    }

        @Override
        public Town findById(Integer id) {
            return this.getEm().find(Town.class, id);
        }

        @Override
    public List<TownModel> all() {
        return this.getEm()
                .createQuery("SELECT NEW _04HospitalDatabase.models.TownModel(t.id, t.name) " +
                        "FROM Town t", TownModel.class).getResultList();
    }

    @Override
    public Town persist(TownModel town) throws ValidationException {
        if (town.getId()< 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "town"));
        } else if (town.getName().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "name", "town"));
        }

        Town dbTown = new Town(town.getId() == 0 ? null: town.getId(), town.getName());
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbTown);
        this.getEm().getTransaction().commit();
        return dbTown;
    }

}
