package pe.edu.upc.StudentHome.service;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.District;


public interface IDistrictService {

	public void insert(District district);

	List<District> list();

	public void delete(int idDistrict);
	
	public List<District> findByName(District dis);
}
