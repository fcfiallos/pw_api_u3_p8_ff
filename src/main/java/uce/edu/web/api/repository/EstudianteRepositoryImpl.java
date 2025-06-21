package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped /*nos dicen que que va manejar transacciones y le da un ambito que se van mantener dentro de la aplicacion */
public class EstudianteRepositoryImpl implements IEstudianteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        return entityManager.find(Estudiante.class, id);
    }

}
