package pe.edu.upc.StudentHome.dao;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Province;


public interface IProvinceDao {
	public void insert(Province prov);

	public List<Province> list();

	public void delete(int idProvince);
	
	public List<Province> findByName(Province pro);
}
