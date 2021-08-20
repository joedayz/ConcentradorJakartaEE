package pe.farmaciasperuanas.concentrador.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext(unitName = "concentrador_pu")
    private EntityManager em;
    
    @ApplicationScoped
    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

}
