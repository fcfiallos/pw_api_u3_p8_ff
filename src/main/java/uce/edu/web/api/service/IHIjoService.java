package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.Hijo;

public interface IHIjoService {
    public List<Hijo>  buscarPorIdEstudiante(Integer id);
    public List<Hijo> buscarPorIdProfesor(Integer id);

}
