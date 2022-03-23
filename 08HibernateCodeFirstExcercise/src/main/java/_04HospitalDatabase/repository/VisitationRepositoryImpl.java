package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Visitation;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.VisitationModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

public class VisitationRepositoryImpl extends BaseRepository implements Repository<Visitation, VisitationModel, Integer> {
    public VisitationRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Visitation findById(Integer id) {
        return this.getEm().find(Visitation.class, id);
    }

    @Override
    public List<VisitationModel> all() {
        return this.getEm().createQuery(
                "SELECT NEW _04HospitalDatabase.models" +
                        ".VisitationModel(v.id, v.date, v.comments, v.patient, v.diagnose)" +
                        "FROM Visitation v " +
                        "ORDER BY v.id", VisitationModel.class).getResultList();
    }

    @Override
    public Visitation persist(VisitationModel visitation) throws ValidationException {
        validate(visitation);
        Visitation dbVisitation = new Visitation(visitation.getId(),
                visitation.getDate(), visitation.getComments(), visitation.getPatient(), visitation.getDiagnose());
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbVisitation);
        this.getEm().getTransaction().commit();
        return dbVisitation;
    }

    private void validate(VisitationModel visitation) throws ValidationException {
        if (visitation.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "visitation"));
        } else if (visitation.getDate() == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "date", "visitation"));
        } else if (visitation.getPatient() == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "patients", "visitation"));
        } else if (visitation.getDiagnose() == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "diagnose", "visitation"));
        }
    }
}
