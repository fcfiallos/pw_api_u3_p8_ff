package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.Profesor;

public interface IProfesorService {
    public Profesor buscarPorId(Integer id);
    public List<Profesor> buscarTodos(String especialidad);
    public void insertar(Profesor profesor);
    public void modificarPorId(Profesor profesor);
    public void modificarParcialPorId(Profesor profesor);
    public void borrar(Integer id);
}
