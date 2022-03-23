package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.TownModel;
import _04HospitalDatabase.repository.TownRepositoryImpl;

import java.io.IOException;
import java.util.List;

import static _04HospitalDatabase.common.Utilities.readStringFromConsole;

public class TownServiceImpl implements Service<Town, TownModel> {
    private final TownRepositoryImpl repository;

    public TownServiceImpl(TownRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Town create() throws ValidationException, IOException {
        String name = readStringFromConsole("Enter town name: ");
        return this.repository.persist(new TownModel(name));
    }

    @Override
    public List<TownModel> getAll() {
        return this.repository.all();
    }
}
