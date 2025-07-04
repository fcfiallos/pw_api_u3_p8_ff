package uce.edu.web.api.service;

import java.util.List;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

public interface IProfesorService {
    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo);
    public List<Profesor> buscarTodos(String especialidad);
    public void insertar(Profesor profesor);
    public void modificarPorId(Profesor profesor);
    public void modificarParcialPorId(Profesor profesor);
    public void borrar(Integer id);
}
