package uce.edu.web.api.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
    public List<Profesor> consultarTodos() {
        return this.profesorService.buscarTodos();
    }

    @POST
    @Path("")
    public void insertar(@RequestBody Profesor profesor) {
        this.profesorService.insertar(profesor);
    }

    @PUT
    @Path("/{id}")
    public void modificarPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        profesor.setId(id);
        this.profesorService.modificarPorId(profesor);
    }

    @PATCH
    @Path("/{id}")
    public void modificarParcialPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        profesor.setId(id);
        Profesor pTemp = this.profesorService.buscarPorId(id);
        if (profesor.getNombre() != null) {
            pTemp.setNombre(profesor.getNombre());
        }
        if (profesor.getCedula() != null) {
            pTemp.setCedula(profesor.getCedula());
        }
        if (profesor.getCorreoElectronico() != null) {
            pTemp.setCorreoElectronico(profesor.getCorreoElectronico());
        }
        if (profesor.getEspecialidad() != null) {
            pTemp.setEspecialidad(profesor.getEspecialidad());
        }
        if (profesor.getApellido() != null) {
            pTemp.setApellido(profesor.getApellido());
        }
        this.profesorService.modificarParcialPorId(pTemp);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        this.profesorService.borrar(id);
    }
}
