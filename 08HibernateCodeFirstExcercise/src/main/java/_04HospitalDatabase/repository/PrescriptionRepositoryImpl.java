package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Patient;
import _04HospitalDatabase.entities.Prescription;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.MedicamentModel;
import _04HospitalDatabase.models.PatientModel;
import _04HospitalDatabase.models.PrescriptionModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

public class PrescriptionRepositoryImpl extends BaseRepository implements Repository<Prescription, PrescriptionModel, Integer> {
    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Prescription findById(Integer id) {
        return this.getEm().find(Prescription.class, id);
    }

    @Override
    public List<PrescriptionModel> all() {
        return this.getEm()
                .createQuery("SELECT NEW _04HospitalDatabase.models.PrescriptionModel(p.id, p.rows, p.diagnose) " +
                        "FROM Prescription p", PrescriptionModel.class).getResultList();
    }

    @Override
    public Prescription persist(PrescriptionModel entity) throws ValidationException {
        validate(entity);
        Prescription dbPrescription = new Prescription(entity.getRows(),entity.getDiagnose());
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbPrescription);
        this.getEm().getTransaction().commit();
        return null;
    }

    private void validate(PrescriptionModel prescription) throws ValidationException {
        if (prescription.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "prescription"));
        } else if (prescription.getDiagnose() == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "diagnose", "prescription"));
        }
    }
}
