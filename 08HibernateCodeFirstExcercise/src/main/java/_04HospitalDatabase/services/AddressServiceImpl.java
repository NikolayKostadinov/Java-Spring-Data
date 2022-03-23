package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Address;
import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.AddressModel;
import _04HospitalDatabase.models.TownModel;
import _04HospitalDatabase.repository.AddressRepositoryImpl;
import _04HospitalDatabase.repository.Repository;
import _04HospitalDatabase.repository.TownRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static _04HospitalDatabase.common.Utilities.*;

public class AddressServiceImpl implements Service<Address, AddressModel>{
    private Repository<Address, AddressModel, Integer> repository;
    private Repository<Town, TownModel, Integer> townRepository;

    public AddressServiceImpl(Repository<Address, AddressModel, Integer> repository,
                              Repository<Town, TownModel, Integer> townRepository) {
        this.repository = repository;
        this.townRepository = townRepository;
    }

    @Override
    public Address create() throws ValidationException, IOException {
        printMessage(this.townRepository.all()
                .stream()
                .map(TownModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        int townId = readIntFromConsole("Enter town Id: ");
        String text = readStringFromConsole("Enter address text: ");
        return this.repository.persist(new AddressModel(text, townId));
    }

    @Override
    public List<AddressModel> getAll() {
        return this.repository.all();
    }
}
