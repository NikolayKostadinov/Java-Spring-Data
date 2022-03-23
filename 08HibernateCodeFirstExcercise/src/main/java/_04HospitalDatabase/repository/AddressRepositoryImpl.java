package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Address;
import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.AddressModel;

import javax.persistence.EntityManager;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

public class AddressRepositoryImpl extends BaseRepository implements Repository<Address, AddressModel, Integer> {
    public AddressRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Address findById(Integer id) {
        return this.getEm().find(Address.class, id);
    }

    @Override
    public List<AddressModel> all() {
        return this.getEm()
                .createQuery("SELECT NEW _04HospitalDatabase.models.AddressModel(a.id, a.text) " +
                        "FROM Address a ", AddressModel.class).getResultList();
    }

    @Override
    public Address persist(AddressModel address) throws ValidationException {
        Town town = this.getEm().find(Town.class, address.getTownId());
        validate(address, town);
        Address dbAddress = new Address(address.getId(), address.getText(), town);
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbAddress);
        this.getEm().getTransaction().commit();
        return dbAddress;
    }

    private void validate(AddressModel address, Town town) throws ValidationException {
        if (address.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "address"));
        } else if (address.getText().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "text", "address"));
        } else if (town == null){
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "town_id", "address"));
        }
    }
}
