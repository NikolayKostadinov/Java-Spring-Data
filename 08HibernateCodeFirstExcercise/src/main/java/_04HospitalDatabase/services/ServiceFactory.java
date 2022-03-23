package _04HospitalDatabase.services;

import _04HospitalDatabase.repository.*;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private final EntityManager em;
    private final VisitationServiceImpl visitationService;
    private final TownServiceImpl townService;
    private final AddressServiceImpl addressService;
    private final PatientServiceImpl patientService;
    private final MedicamentServiceImpl medicamentService;

    public ServiceFactory(EntityManager em) {
        this.em = em;
        TownRepositoryImpl townRepository = new TownRepositoryImpl(em);
        AddressRepositoryImpl addressRepository = new AddressRepositoryImpl(em);
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(em);
        MedicamentRepositoryImpl medicamentRepository = new MedicamentRepositoryImpl(em);
        VisitationRepositoryImpl visitationRepository = new VisitationRepositoryImpl(em);
        this.visitationService = new VisitationServiceImpl(visitationRepository, patientRepository, medicamentRepository);
        this.townService = new TownServiceImpl(townRepository);
        this.addressService = new AddressServiceImpl(addressRepository, townRepository);
        this.patientService = new PatientServiceImpl(patientRepository, addressRepository);
        this.medicamentService = new MedicamentServiceImpl(medicamentRepository);
    }

    public Service getService(int operation) {
        return switch (operation) {
            case 1, 6 -> this.visitationService;
            case 2, 7 -> this.townService;
            case 3, 8 -> this.addressService;
            case 4, 9 -> this.patientService;
            case 5, 10 -> this.medicamentService;

            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
