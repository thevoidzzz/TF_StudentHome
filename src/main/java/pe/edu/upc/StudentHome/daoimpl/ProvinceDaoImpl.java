package pe.edu.upc.StudentHome.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.StudentHome.dao.IProvinceDao;

import pe.edu.upc.StudentHome.models.entities.Province;

public class ProvinceDaoImpl implements IProvinceDao{
	@PersistenceContext(unitName = "StudentHomeDS")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Province prov) {
		try {
			em.persist(prov);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Province> list() {
		List<Province> lista = new ArrayList<Province>();
		try {
			Query q = em.createQuery("from Province p");
			lista = (List<Province>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idProvince) {
		Province pr = new Province();
		try {
			pr = em.getReference(Province.class, idProvince);
			em.remove(pr);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Province> findByName(Province pro) {
		List<Province> lista = new ArrayList<Province>();
		try {
			Query q = em.createQuery("from Province p where p.name like ?1");
			q.setParameter(1, "%" + pro.getName() + "%"); //comodines para buscar que dejan desde el inicio o final
			lista = (List<Province>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
