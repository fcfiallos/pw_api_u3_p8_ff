package uce.edu.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IProfesorService;
import uce.edu.web.api.service.to.ProfesorTo;

@Path("/profesores")
public class ProfesorController {
    @Inject
    private IProfesorService profesorService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consularPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ProfesorTo profesorTo = this.profesorService.buscarPorId(id, uriInfo);
        return Response.status(Response.Status.OK).entity(profesorTo).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consultar Todos los Profesores", description = "Permite consultar todos los profesores de la BD")
    public Response consultarTodos(@QueryParam("especialidad") String especialidad,
            @QueryParam("carrera") String carrera) {
        return Response.status(Response.Status.OK).entity(this.profesorService.buscarTodos(especialidad)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Guardar un profesor", description = "Permite guardar un nuevo recurso profesor en la BD")
    public Response insertar(@RequestBody Profesor profesor) {
        this.profesorService.insertar(profesor);
        return Response.status(Response.Status.CREATED)
                .entity("{\"mensaje\": \"Profesor creado exitosamente\"}").build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        profesor.setId(id);
        this.profesorService.modificarPorId(profesor);
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Profesor actualizado exitosamente\"}").build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarParcialPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        // profesor.setId(id);
        /*Profesor pTemp = this.profesorService.buscarPorId(id);
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
        this.profesorService.modificarParcialPorId(pTemp);*/
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Profesor actualizado parcialmente exitosamente\"}").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") Integer id) {
        this.profesorService.borrar(id);
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Profesor eliminado exitosamente\"}").build();
    }

    @GET
    @Path("/{id}/hijos") 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {
        Hijo hijo1 = new Hijo();
        hijo1.setNombre("Pepito ");

        Hijo hijo2 = new Hijo();
        hijo2.setNombre("Juanito ");

        List<Hijo> hijos = new  ArrayList<>();
        hijos.add(hijo1);
        hijos.add(hijo2);
        return hijos;
    }
}
