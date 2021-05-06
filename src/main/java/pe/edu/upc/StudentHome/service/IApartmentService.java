package pe.edu.upc.StudentHome.service;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Apartment;


public interface IApartmentService {
	public void insert(Apartment apartment);

    List<Apartment> list();

    public void delete(int idApartment);
    
    public List<Apartment> findByName(Apartment apa);
}
