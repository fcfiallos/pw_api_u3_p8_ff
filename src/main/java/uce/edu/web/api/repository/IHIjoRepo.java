package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Hijo;

public interface IHIjoRepo {
    public List<Hijo> seleccionarPorId(Integer id);
}
