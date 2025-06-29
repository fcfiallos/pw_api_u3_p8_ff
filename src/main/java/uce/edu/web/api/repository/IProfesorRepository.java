package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Profesor;

public interface IProfesorRepository {
    public Profesor seleccionarPorId(Integer id);
    public List<Profesor> seleccionarTodos();
    public void insertar(Profesor profesor);
    public void actualizarPorId(Profesor profesor);
    public void actualizarParcialPorId(Profesor profesor);
    public void eliminar(Integer id);
}
