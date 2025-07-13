package uce.edu.web.api.service.mapper;

import java.util.List;

import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

public class ProfesorMapper {
    public static ProfesorTo toTO(Profesor profesor) {
        ProfesorTo profesorTo = new ProfesorTo();
        profesorTo.setId(profesor.getId());
        profesorTo.setNombre(profesor.getNombre());
        profesorTo.setApellido(profesor.getApellido());
        profesorTo.setEspecialidad(profesor.getEspecialidad());
        profesorTo.setCorreoElectronico(profesor.getCorreoElectronico());
        profesorTo.setCedula(profesor.getCedula());
        return profesorTo;
    }

    public static Profesor toEntity(ProfesorTo profesorTo) {
        Profesor profesor = new Profesor();
        profesor.setId(profesorTo.getId());
        profesor.setNombre(profesorTo.getNombre());
        profesor.setApellido(profesorTo.getApellido());
        profesor.setEspecialidad(profesorTo.getEspecialidad());
        profesor.setCorreoElectronico(profesorTo.getCorreoElectronico());
        profesor.setCedula(profesorTo.getCedula());
        return profesor;
    }

    public static List<ProfesorTo> toToList(List<Profesor> profesores) {
        return profesores.stream()
                .map(ProfesorMapper::toTO)
                .toList();
    }

    public static void actualizarProfesorPorId(Profesor profesor, ProfesorTo profesorTo){
        if (profesorTo.getNombre() != null) {
            profesor.setNombre(profesorTo.getNombre());
        }
        if (profesorTo.getApellido() != null) {
            profesor.setApellido(profesorTo.getApellido());
        }
        if (profesorTo.getEspecialidad() != null) {
            profesor.setEspecialidad(profesorTo.getEspecialidad());
        }
        if (profesorTo.getCorreoElectronico() != null) {
            profesor.setCorreoElectronico(profesorTo.getCorreoElectronico());
        }
        if (profesorTo.getCedula() != null) {
            profesor.setCedula(profesorTo.getCedula());
        }
    }
}
