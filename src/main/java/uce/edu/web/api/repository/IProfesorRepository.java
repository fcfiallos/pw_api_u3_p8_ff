package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Profesor;

public interface IProfesorRepository {
    public Profesor seleccionarPorId(Integer id);
}
