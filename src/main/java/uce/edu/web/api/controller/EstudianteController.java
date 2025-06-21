package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

@Path("/estudiantes")/*url y representacion al modelo pero en plural*/
public class EstudianteController {
    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/consultar/{id}") /*cada metodo se le incluye un path y PathParam igual a Path Variable*/
    /*como se realiza una peticion se maneja con verbos o metodos http*/
    public Estudiante consularPorId(@PathParam("id") Integer id){
        return this.estudianteService.buscarPorId(id);
    }
}
