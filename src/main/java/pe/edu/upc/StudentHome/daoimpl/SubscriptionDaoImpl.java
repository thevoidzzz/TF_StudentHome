package pe.edu.upc.StudentHome.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.StudentHome.dao.ISubscriptionDao;
import pe.edu.upc.StudentHome.models.entities.Subscription;

public class SubscriptionDaoImpl implements ISubscriptionDao {

    @PersistenceContext(unitName = "StudentHomeDS")
    private EntityManager em;

    @Transactional
    @Override
    public void insert(Subscription sub) {
        try {

            em.persist(sub);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al insertar Suscripcion en el dao");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subscription> list() {
        List<Subscription> lista = new ArrayList<Subscription>();
        try {

            Query q = em.createQuery("from Subscription s");
            lista = (List<Subscription>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Transactional
    @Override
    public void delete(int idSubscription) {

        Subscription su = new Subscription();
        try {
            su = em.getReference(Subscription.class, idSubscription);
            em.remove(su);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}