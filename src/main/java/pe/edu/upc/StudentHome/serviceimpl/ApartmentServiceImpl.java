package pe.edu.upc.StudentHome.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.dao.IApartmentDao;
import pe.edu.upc.StudentHome.models.entities.Apartment;

import pe.edu.upc.StudentHome.service.IApartmentService;

@Named
@RequestScoped
public class ApartmentServiceImpl implements IApartmentService{
	@Inject
    private IApartmentDao apartmentDao;

    @Override
    public void insert(Apartment apartment) {
        apartmentDao.insert(apartment);
    }

    @Override
    public List<Apartment> list() {
        // TODO Auto-generated method stub
        return apartmentDao.list();
    }

    @Override
    public void delete(int idApartment) {
        apartmentDao.delete(idApartment);
    }
    
    @Override
	public List<Apartment> findByName(Apartment apa) {		
		return apartmentDao.findByName(apa);
	}
}
