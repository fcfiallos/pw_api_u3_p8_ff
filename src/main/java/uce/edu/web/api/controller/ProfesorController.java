package uce.edu.web.api.controller;

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
import uce.edu.web.api.service.IHIjoService;
import uce.edu.web.api.service.IProfesorService;
import uce.edu.web.api.service.mapper.HijoMapper;
import uce.edu.web.api.service.mapper.ProfesorMapper;
import uce.edu.web.api.service.to.HijoTo;
import uce.edu.web.api.service.to.ProfesorTo;

@Path("/profesores")
public class ProfesorController {
    @Inject
    private IProfesorService profesorService;
    @Inject
    private IHIjoService hijoService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consularPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ProfesorTo profesorTo = ProfesorMapper.toTO(this.profesorService.buscarPorId(id));
        profesorTo.buildURI(uriInfo);
        return Response.status(Response.Status.OK).entity(profesorTo).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consultar Todos los Profesores", description = "Permite consultar todos los profesores de la BD")
    public Response consultarTodos(@QueryParam("especialidad") String especialidad,
            @QueryParam("carrera") String carrera, @Context UriInfo uriInfo) {
        List<ProfesorTo> profesoresTo = ProfesorMapper.toToList(this.profesorService.buscarTodos(especialidad));
        profesoresTo.forEach(profesor -> profesor.buildURI(uriInfo));
        return Response.status(Response.Status.OK).entity(profesoresTo).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Guardar un profesor", description = "Permite guardar un nuevo recurso profesor en la BD")
    public Response insertar(@RequestBody ProfesorTo profesor) {
        this.profesorService.insertar(profesor);
        return Response.status(Response.Status.CREATED)
                .entity("{\"mensaje\": \"Profesor creado exitosamente\"}").build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarPorId(@RequestBody ProfesorTo profesor, @PathParam("id") Integer id) {
        profesor.setId(id);
        this.profesorService.modificarPorId(profesor);
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Profesor actualizado exitosamente\"}").build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarParcialPorId(@RequestBody ProfesorTo profesor, @PathParam("id") Integer id) {

        this.profesorService.modificarParcialPorId(profesor, id);
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
    public List<HijoTo> obtenerHijosPorId(@PathParam("id") Integer id) {
        return HijoMapper.toTOList(this.hijoService.buscarPorIdProfesor(id));
    }
}
