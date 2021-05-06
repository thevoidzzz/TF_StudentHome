package pe.edu.upc.StudentHome.dao;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Apartment;


public interface IApartmentDao {
	public void insert(Apartment apartment);

    public List<Apartment> list();

    public void delete(int idApartment);
    
    public List<Apartment> findByName(Apartment apa);
}
