package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Address;
import _04HospitalDatabase.entities.Diagnose;
import _04HospitalDatabase.entities.Visitation;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.DiagnoseModel;
import _04HospitalDatabase.models.MedicamentModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.*;

public class DiagnoseRepositoryImpl extends BaseRepository implements Repository<Diagnose, DiagnoseModel, Integer>{
    public DiagnoseRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Diagnose findById(Integer id) {
        return this.getEm().find(Diagnose.class, id);
    }

    @Override
    public List<DiagnoseModel> all() {
        return this.getEm()
                .createQuery("SELECT NEW _04HospitalDatabase.models.DiagnoseModel(d.id, d.name, d.comments, d.visitation.id) " +
                        "FROM Diagnose d", DiagnoseModel.class).getResultList();
    }

    @Override
    public Diagnose persist(DiagnoseModel diagnose) throws ValidationException {
        Visitation visitation =  this.getEm().find(Visitation.class, diagnose);
        validate(diagnose, visitation);
        return null;
    }

    private void validate(DiagnoseModel diagnose, Visitation visitation) throws ValidationException {
        if (diagnose.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "diagnose"));
        } else if (diagnose.getName() == null || diagnose.getName().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "name", "diagnose"));
        } else if (visitation == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "visitation", "diagnose"));
        }
    }


}
