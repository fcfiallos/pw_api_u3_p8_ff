package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProfesorRepository;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.mapper.ProfesorMapper;
import uce.edu.web.api.service.to.ProfesorTo;

@ApplicationScoped
public class ProfesorServiceImpl implements IProfesorService {

    @Inject
    private IProfesorRepository profesorRepository;

    @Override
    public Profesor buscarPorId(Integer id) {
        return this.profesorRepository.seleccionarPorId(id);
    }

    @Override
    public List<Profesor> buscarTodos(String especialidad) {
        return this.profesorRepository.seleccionarTodos(especialidad);
    }

    @Override
    public void insertar(ProfesorTo profesor) {
        Profesor prof = ProfesorMapper.toEntity(profesor);
        this.profesorRepository.insertar(prof);
    }

    @Override
    public void modificarPorId(ProfesorTo profesorTo) {
        Profesor profesor = ProfesorMapper.toEntity(profesorTo);
        this.profesorRepository.actualizarPorId(profesor);
    }

    @Override
    public void modificarParcialPorId(ProfesorTo profesorTo, Integer id) {
        Profesor prof = this.profesorRepository.seleccionarPorId(id);
        ProfesorMapper.actualizarProfesorPorId(prof, profesorTo);
        this.profesorRepository.actualizarParcialPorId(prof);
    }

    @Override
    public void borrar(Integer id) {
        this.profesorRepository.eliminar(id);
    }

}
