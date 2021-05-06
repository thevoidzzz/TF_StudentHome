package pe.edu.upc.StudentHome.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.dao.IDistrictDao;

import pe.edu.upc.StudentHome.models.entities.District;
import pe.edu.upc.StudentHome.service.IDistrictService;

@Named
@RequestScoped
public class DistrictServiceImpl implements IDistrictService {
	@Inject
	private IDistrictDao districtDao;

	@Override
	public void insert(District distr) {
		try {
			districtDao.insert(distr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<District> list() {
		return districtDao.list();
	}

	@Override
	public void delete(int idDistrict) {
		districtDao.delete(idDistrict);
	}
	
	@Override
	public List<District> findByName(District dis) {		
		return districtDao.findByName(dis);
	}
}
