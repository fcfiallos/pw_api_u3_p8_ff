package uce.edu.web.api.service.to;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.EstudianteController;

public class EstudianteTo {
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private String genero;
    // esto es para los hipervinculos de hijos con el ejemplo
    private Map<String, String> _links = new HashMap<>();

    public EstudianteTo(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento, String genero,
            UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        URI todosHijos = uriInfo.getBaseUriBuilder().path(EstudianteController.class)
                .path(EstudianteController.class, "obtenerHijosPorId").build(id);

        _links.put("hijos", todosHijos.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
