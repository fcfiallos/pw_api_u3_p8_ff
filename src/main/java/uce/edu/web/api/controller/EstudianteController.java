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
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

//tambien se le conoce como servicio (recursos)
@Path("/estudiantes") /* url y representacion al modelo pero en plural */
public class EstudianteController {
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
    public Estudiante consularPorId(@PathParam("id") Integer id) {
        return this.estudianteService.buscarPorId(id);
    }

    @GET
    @Path("")
    public List<Estudiante> consultarTodos() {
        return this.estudianteService.buscarTodos();
    }

    /*
     * Cuando se necesita guardar un recurso debe venir en el body de la peticion
     * se usa una anotacion o sin ella
     * lo que significa que el estudiante viene en el body
     */
    @POST
    @Path("")
    public void guardar(@RequestBody Estudiante estudiante) {

    }

    @PUT
    @Path("/{id}")
    public void actualizarPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {

    }

    /*
     * Como no se sabe el recurso que se va actualizar parcial se usa igual el body
     */
    @PATCH
    @Path("/{id}")
    public void actualizarParcialPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {

    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id) {
        
    }
}
