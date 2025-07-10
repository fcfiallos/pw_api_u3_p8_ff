package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

public class EstudianteMapper {
    public static EstudianteTo toTO(Estudiante estudiante){
        EstudianteTo estudianteTo = new EstudianteTo();
        estudianteTo.setId(estudiante.getId());
        estudianteTo.setNombre(estudiante.getNombre());
        estudianteTo.setApellido(estudiante.getApellido());
        estudianteTo.setGenero(estudiante.getGenero());
        estudianteTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        return estudianteTo;
    }

    public static Estudiante toEntity(EstudianteTo estudianteTo){
        Estudiante e = new Estudiante();
        e.setId(estudianteTo.getId());
        e.setNombre(estudianteTo.getNombre());
        e.setApellido(estudianteTo.getApellido());
        e.setGenero(estudianteTo.getGenero());
        e.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        return e;
    }
}
