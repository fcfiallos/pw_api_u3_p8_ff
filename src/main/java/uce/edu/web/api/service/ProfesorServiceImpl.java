package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProfesorRepository;
import uce.edu.web.api.repository.modelo.Profesor;

@ApplicationScoped
public class ProfesorServiceImpl  implements IProfesorService{

    @Inject
    private IProfesorRepository profesorRepository;

    @Override
    public Profesor buscarPorId(Integer id) {
        return this.profesorRepository.seleccionarPorId(id);
    }

    @Override
    public List<Profesor> buscarTodos() {
        return this.profesorRepository.seleccionarTodos();
    }

}
