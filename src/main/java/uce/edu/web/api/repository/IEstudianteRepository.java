package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public Estudiante seleccionarPorId(Integer id);
}
