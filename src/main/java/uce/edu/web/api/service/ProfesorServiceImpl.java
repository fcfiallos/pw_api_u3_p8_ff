package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IProfesorRepository;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

@ApplicationScoped
public class ProfesorServiceImpl  implements IProfesorService{

    @Inject
    private IProfesorRepository profesorRepository;

    @Override
    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo) {
        Profesor p = this.profesorRepository.seleccionarPorId(id);
        ProfesorTo pTo = new ProfesorTo(p.getId(), p.getNombre(), p.getApellido(), p.getEspecialidad(), p.getCorreoElectronico(), p.getCedula(), uriInfo);
        return pTo;
    }

    @Override
    public List<Profesor> buscarTodos(String especialidad) {
        return this.profesorRepository.seleccionarTodos(especialidad);
    }

    @Override
    public void insertar(Profesor profesor) {
        this.profesorRepository.insertar(profesor);
    }

    @Override
    public void modificarPorId(Profesor profesor) {
        this.profesorRepository.actualizarPorId(profesor);
    }

    @Override
    public void modificarParcialPorId(Profesor profesor) {
        this.profesorRepository.actualizarParcialPorId(profesor);
    }

    @Override
    public void borrar(Integer id) {
        this.profesorRepository.eliminar(id);
    }

}
