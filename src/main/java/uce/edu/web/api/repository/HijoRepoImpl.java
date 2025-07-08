package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Hijo;

@Transactional
@ApplicationScoped
public class HijoRepoImpl implements IHIjoRepo{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hijo>  seleccionarPorId(Integer id) {
        return this.entityManager.createQuery("SELECT h FROM Hijo h WHERE h.estudiante.id = :id", Hijo.class)
                .setParameter("id", id).getResultList();
    }

}
