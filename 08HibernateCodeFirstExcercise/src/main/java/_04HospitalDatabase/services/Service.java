package _04HospitalDatabase.services;

import _04HospitalDatabase.exceptions.ValidationException;

import java.io.IOException;
import java.util.List;

public interface Service<T, TModel> {
    T create() throws ValidationException, IOException;

    List<TModel> getAll();
}
