package pe.edu.upc.StudentHome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.models.entities.Apartment;
import pe.edu.upc.StudentHome.models.entities.District;
import pe.edu.upc.StudentHome.service.IApartmentService;
import pe.edu.upc.StudentHome.service.IDistrictService;

@Named
@RequestScoped
public class ApartmentController {
	@Inject
	private IApartmentService apartmentService;
	@Inject
	private IDistrictService dService;	
	
//variables	
	private Apartment apartment;
	List<District> listaDistritos;
	List<Apartment> listaApartment;

//constructors

	@PostConstruct
	public void init() {
		this.apartment = new Apartment();
		this.listaApartment = new ArrayList<Apartment>();
		this.listApartment();
		this.listDistrict();
	}

//metodos especializados

	public String newApartment() {
		this.setApartment(new Apartment());
		return "apartment.xhtml";
	}

	public void insert() {
		try {
			apartmentService.insert(apartment);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de región");
		}
	}

	public void listApartment() {
		try {
			listaApartment = apartmentService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de apartment");
		}
	}

	public void delete(Apartment apartment) {
		try {
			apartmentService.delete(apartment.getId());
			this.listApartment();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de apartment");
		}
	}	
	
	public void listDistrict() {
		try {
			listaDistritos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de district");
		}
	}
	
	public void findByName() {
		try {
			if(apartment.getApartmentName().isEmpty()) {
				this.listApartment();
			}else {
				listaApartment = this.apartmentService.findByName(this.getApartment());
			}
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller de región");
		}
	}
	
	public void clean() {
		this.init();
	}

//get y setters
	
	public IApartmentService getApartmentService() {
		return apartmentService;
	}

	public void setApartmentService(IApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}

	public Apartment getApartment() {
		return apartment;
	}	

	public IDistrictService getdService() {
		return dService;
	}

	public void setdService(IDistrictService dService) {
		this.dService = dService;
	}

	public List<District> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<District> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public void setApartment(Apartment apartment) {
		this.apartment= apartment;
	}

	public List<Apartment> getListaApartment() {
		return listaApartment;
	}

	public void setListaApartment(List<Apartment> listaApartment) {
		this.listaApartment = listaApartment;
	}

}
