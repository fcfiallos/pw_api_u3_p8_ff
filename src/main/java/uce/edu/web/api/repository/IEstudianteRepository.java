package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public Estudiante seleccionarPorId(Integer id);
    public List<Estudiante> seleccionarTodos();
    public  void actualizarPorId(Estudiante estudiante);
    public void actualizarParcialPorId(Estudiante estudiante);
    public void eliminarPorId(Integer id);
    public void insertar(Estudiante estudiante);
}
