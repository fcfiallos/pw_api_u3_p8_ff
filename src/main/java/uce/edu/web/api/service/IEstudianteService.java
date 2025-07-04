package uce.edu.web.api.service;

import java.util.List;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {
    public EstudianteTo buscarPorId(Integer id, UriInfo uriInfo);

    public List<Estudiante> buscarTodos(String genero);

    public void modificarPorId(Estudiante estudiante);

    public void modificarParcialPorId(Estudiante estudiante);

    public void borrarPorId(Integer id);

    public void guardar(Estudiante estudiante);
}
