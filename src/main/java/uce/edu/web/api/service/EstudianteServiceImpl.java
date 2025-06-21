package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;

@ApplicationScoped 
public class EstudianteServiceImpl implements IEstudianteService{

    @Inject
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante buscarPorId(Integer id) {
       return this.estudianteRepository.seleccionarPorId(id);
    }

}
