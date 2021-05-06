package pe.edu.upc.StudentHome.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.StudentHome.dao.IDistrictDao;

import pe.edu.upc.StudentHome.models.entities.District;

public class DistrictDaoImpl implements IDistrictDao {
	@PersistenceContext(unitName = "StudentHomeDS")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(District distr) {
		try {
			em.persist(distr);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> list() {
		List<District> lista = new ArrayList<District>();
		try {
			Query q = em.createQuery("from District d");
			lista = (List<District>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idDistrict) {
		District di = new District();
		try {
			di = em.getReference(District.class, idDistrict);
			em.remove(di);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<District> findByName(District dis) {
		List<District> lista = new ArrayList<District>();
		try {
			Query q = em.createQuery("from District d where d.name like ?1");
			q.setParameter(1, "%" + dis.getName() + "%"); //comodines para buscar que dejan desde el inicio o final
			lista = (List<District>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
