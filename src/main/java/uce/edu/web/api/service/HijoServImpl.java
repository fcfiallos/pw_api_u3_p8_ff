package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IHIjoRepo;
import uce.edu.web.api.repository.modelo.Hijo;

@ApplicationScoped
public class HijoServImpl implements IHIjoService{
    @Inject
    private IHIjoRepo hijoRepo;

    @Override
    public List<Hijo>  buscarPorIdEstudiante(Integer id) {
        return this.hijoRepo.seleccionarPorIdEstudiante(id);
    }

    @Override
    public List<Hijo> buscarPorIdProfesor(Integer id) {
        return this.hijoRepo.seleccionarPorIdProfesor(id);
    }

}
