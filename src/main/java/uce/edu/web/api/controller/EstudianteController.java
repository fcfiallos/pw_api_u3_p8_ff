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
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

//tambien se le conoce como servicio (recursos)
@Path("/estudiantes") /* url y representacion al modelo pero en plural */
public class EstudianteController extends BaseControlador {
    @Inject
    private IEstudianteService estudianteService;

    /*
     * cada metodo se le incluye un path y PathParam igual a Path Variable
     * como se realiza una peticion se maneja con verbos o metodos http
     * los metodos son capacidades de ese servicio con los path
     * por en nivel uno del modelo madurez se quita /consulta y solo se usa como
     * esta actualmente
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consularPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        EstudianteTo estudianteTo = this.estudianteService.buscarPorId(id, uriInfo);
        return Response.status(227).entity(estudianteTo).build();
    }

    // ?genero=F&provincia=pichincha
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consultar Todos los Estudiantes", description = "Permite consultar todos los estudiantes del sistema")
    public Response consultarTodos(@QueryParam("genero") String genero, @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.OK).entity(this.estudianteService.buscarTodos(genero)).build();
    }

    /*
     * Cuando se necesita guardar un recurso debe venir en el body de la peticion
     * se usa una anotacion o sin ella
     * lo que significa que el estudiante viene en el body
     */
    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON) // para api JSON o XML
    @Operation(summary = "Guardar Estudiante", description = "Permite guardar un estudiante en el sistema de la base de datos")
    public Response guardar(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
        // 201 CREATED: La solicitud se realizó correctamente y, como resultado, se creó
        // un nuevo recurso.
        return Response.status(Response.Status.CREATED)
                .entity("{\"mensaje\": \"Estudiante guardado exitosamente\"}")
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        estudiante.setId(id);
        this.estudianteService.modificarPorId(estudiante);
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Estudiante actualizado exitosamente\"}")
                .build();
    }

    /*
     * Como no se sabe el recurso que se va actualizar parcial se usa igual el body
     */
    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarParcialPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        // estudiante.setId(id);
        /*Estudiante e = this.estudianteService.buscarPorId(id);
        if (estudiante.getApellido() != null) {
            e.setApellido(estudiante.getApellido());
        }
        if (estudiante.getNombre() != null) {
            e.setNombre(estudiante.getNombre());
        }
        if (estudiante.getFechaNacimiento() != null) {
            e.setFechaNacimiento(estudiante.getFechaNacimiento());
        }
        if (estudiante.getGenero() != null) {
            e.setGenero(estudiante.getGenero());
        }
        this.estudianteService.modificarParcialPorId(e);*/
        return Response.status(Response.Status.OK)
                .entity("{\"mensaje\": \"Estudiante actualizado parcialmente exitosamente\"}")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.estudianteService.borrarPorId(id);
        // 204 NO CONTENT: No hay contenido para enviar para esta solicitud
        return Response.status(Response.Status.NO_CONTENT)
                .entity("{\"mensaje\": \"Estudiante eliminado exitosamente\"}")
                .build();
    }

    @GET
    @Path("/{id}/hijos") // debe ser auto descriptivo
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
