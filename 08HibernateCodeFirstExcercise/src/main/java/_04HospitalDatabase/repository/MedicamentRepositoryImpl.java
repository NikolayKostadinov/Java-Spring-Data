package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Medicament;
import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.MedicamentModel;
import _04HospitalDatabase.models.TownModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

public class MedicamentRepositoryImpl extends BaseRepository implements Repository<Medicament, MedicamentModel, Integer> {

    public MedicamentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Medicament findById(Integer id) {
        return this.getEm().find(Medicament.class, id);
    }

    @Override
    public List<MedicamentModel> all() {
        return this.getEm()
                .createQuery("SELECT NEW _04HospitalDatabase.models.MedicamentModel(m.id, m.name) " +
                        "FROM Medicament m", MedicamentModel.class).getResultList();
    }

    @Override
    public Medicament persist(MedicamentModel medicament) throws ValidationException {
        if (medicament.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "town"));
        } else if (medicament.getName().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "name", "town"));
        }

        Medicament dbTown = new Medicament(medicament.getId() == 0 ? null : medicament.getId(), medicament.getName());
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbTown);
        this.getEm().getTransaction().commit();
        return dbTown;
    }
}
