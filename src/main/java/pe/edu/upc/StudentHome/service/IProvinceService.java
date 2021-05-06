package pe.edu.upc.StudentHome.service;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Province;


public interface IProvinceService {
	public void insert(Province prov);

	List<Province> list();

	public void delete(int idProvince);
	
	public List<Province> findByName(Province pro);
}
