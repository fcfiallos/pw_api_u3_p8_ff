package uce.edu.web.api.service;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteService {
    public Estudiante buscarPorId(Integer id);
}
