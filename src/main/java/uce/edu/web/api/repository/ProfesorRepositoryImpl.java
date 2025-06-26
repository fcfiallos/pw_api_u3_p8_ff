package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Profesor;

@Transactional
@ApplicationScoped
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Profesor seleccionarPorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        return this.entityManager.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
    }

}
