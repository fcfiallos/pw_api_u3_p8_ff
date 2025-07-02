package uce.edu.web.api.service;

import java.util.List;

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

    @Override
    public List<Estudiante> buscarTodos(String genero) {
        return this.estudianteRepository.seleccionarTodos(genero);
    }

    @Override
    public void modificarPorId(Estudiante estudiante) {
        this.estudianteRepository.actualizarPorId(estudiante);
    }

    @Override
    public void modificarParcialPorId(Estudiante estudiante) {
        this.estudianteRepository.actualizarParcialPorId(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.estudianteRepository.eliminarPorId(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.estudianteRepository.insertar(estudiante);
    }

}
