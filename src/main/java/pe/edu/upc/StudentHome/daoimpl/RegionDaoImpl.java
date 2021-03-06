package pe.edu.upc.StudentHome.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.StudentHome.dao.IRegionDao;
import pe.edu.upc.StudentHome.models.entities.Region;

public class RegionDaoImpl implements IRegionDao {

    @PersistenceContext(unitName = "StudentHomeDS")
    private EntityManager em;

    @Transactional
    @Override
    public void insert(Region reg) {
        try {
            em.persist(reg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al insertar Region en el dao");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Region> list() {
        List<Region> lista = new ArrayList<Region>();
        try {
            Query q = em.createQuery("from Region r");
            lista = (List<Region>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Transactional
    @Override
    public void delete(int idRegion) {

        Region re = new Region();
        try {
            re = em.getReference(Region.class, idRegion);
            em.remove(re);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Region> findByName(Region reg) {
		List<Region> lista = new ArrayList<Region>();
		try {
			Query q = em.createQuery("from Region r where r.name like ?1");
			q.setParameter(1, "%" + reg.getName() + "%"); //comodines para buscar que dejan desde el inicio o final
			lista = (List<Region>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}