package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

public interface IProfesorService {
    public Profesor buscarPorId(Integer id);
    public List<Profesor> buscarTodos(String especialidad);
    public void insertar(ProfesorTo profesor);
    public void modificarPorId(ProfesorTo profesor);
    public void modificarParcialPorId(ProfesorTo profesor, Integer id);
    public void borrar(Integer id);
}
