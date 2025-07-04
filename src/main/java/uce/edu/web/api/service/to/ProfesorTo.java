package uce.edu.web.api.service.to;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.EstudianteController;

public class ProfesorTo {
    private Integer id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String correoElectronico;
    private String cedula;
    private Map<String, String> _links = new HashMap<>();
    public ProfesorTo(Integer id, String nombre, String apellido, String especialidad, String correoElectronico,
            String cedula, UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.correoElectronico = correoElectronico;
        this.cedula = cedula;
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Map<String, String> get_links() {
        return _links;
    }
    public void set_links(Map<String, String> _links) {
        this._links = _links;
    }

    
}
