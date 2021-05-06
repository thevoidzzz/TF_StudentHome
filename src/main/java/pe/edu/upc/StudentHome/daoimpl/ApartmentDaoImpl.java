package pe.edu.upc.StudentHome.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.StudentHome.dao.IApartmentDao;
import pe.edu.upc.StudentHome.models.entities.Apartment;


public class ApartmentDaoImpl implements IApartmentDao{
	@PersistenceContext(unitName = "StudentHomeDS")
    private EntityManager em;

    @Transactional
    @Override
    public void insert(Apartment apartment) {
        try {
            em.persist(apartment);
        } catch (Exception e) {            
            System.out.println("Error al insertar Apartment en el dao");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Apartment> list() {
        List<Apartment> lista = new ArrayList<Apartment>();
        try {
            Query q = em.createQuery("from Apartment a");
            lista = (List<Apartment>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Transactional
    @Override
    public void delete(int idApartment) {

        Apartment ap = new Apartment();
        try {
            ap = em.getReference(Apartment.class, idApartment);
            em.remove(ap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Apartment> findByName(Apartment apa) {
		List<Apartment> lista = new ArrayList<Apartment>();
		try {
			Query q = em.createQuery("from Apartment a where a.name like ?1");
			q.setParameter(1, "%" + apa.getApartmentName() + "%"); //comodines para buscar que dejan desde el inicio o final
			lista = (List<Apartment>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
