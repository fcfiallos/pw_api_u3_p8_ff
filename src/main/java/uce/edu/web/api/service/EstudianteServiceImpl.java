package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

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
    public void modificarPorId(EstudianteTo estudianteTo) {
        Estudiante estudiante = EstudianteMapper.toEntity(estudianteTo);
        this.estudianteRepository.actualizarPorId(estudiante);
    }

    @Override
    public void modificarParcialPorId(EstudianteTo estudianteTo, Integer id) {
        // Buscamos la entidad existente
        Estudiante estudianteExistente = this.estudianteRepository.seleccionarPorId(id);
        
        // Actualizamos solo los campos no nulos usando el mapper
        EstudianteMapper.updateEntityFromTO(estudianteExistente, estudianteTo);
        
        // Guardamos los cambios
        this.estudianteRepository.actualizarParcialPorId(estudianteExistente);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.estudianteRepository.eliminarPorId(id);
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        Estudiante estu = EstudianteMapper.toEntity(estudiante);
        this.estudianteRepository.insertar(estu);
    }

}
