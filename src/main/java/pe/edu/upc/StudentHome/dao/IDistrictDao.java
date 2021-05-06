package pe.edu.upc.StudentHome.dao;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.District;




public interface IDistrictDao {

	public void insert(District distr);

	public List<District> list();

	public void delete(int idDistrict);
	
	public List<District> findByName(District dis);
}
