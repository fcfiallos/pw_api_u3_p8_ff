package uce.edu.web.api.service.mapper;

import java.util.List;

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

    public static List<EstudianteTo> toTOList(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(EstudianteMapper::toTO)
                .toList();
    }

    /**
     * Actualiza una entidad Estudiante con los datos no nulos de un EstudianteTo
     * Este método es útil para actualizaciones parciales (PATCH)
     */
    public static void updateEntityFromTO(Estudiante entity, EstudianteTo to) {
        if (to.getApellido() != null) {
            entity.setApellido(to.getApellido());
        }
        if (to.getNombre() != null) {
            entity.setNombre(to.getNombre());
        }
        if (to.getFechaNacimiento() != null) {
            entity.setFechaNacimiento(to.getFechaNacimiento());
        }
        if (to.getGenero() != null) {
            entity.setGenero(to.getGenero());
        }
    }
}
