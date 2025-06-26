package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IProfesorService;

@Path("/profesores")
public class ProfesorController {
    @Inject
    private IProfesorService profesorService;

    @GET
    @Path("/{id}")
    public Profesor consularPorId(@PathParam("id") Integer id) {
        return this.profesorService.buscarPorId(id);
    }

    @GET
    @Path("")
    public List<Profesor> consultarTodos(){
        return this.profesorService.buscarTodos();
    }
}
