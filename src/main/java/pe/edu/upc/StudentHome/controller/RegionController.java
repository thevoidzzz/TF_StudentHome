package pe.edu.upc.StudentHome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.models.entities.Region;
import pe.edu.upc.StudentHome.service.IRegionService;

@Named
@RequestScoped
public class RegionController {
	@Inject
	private IRegionService regService;

//variables	
	private Region region;

	List<Region> listaRegiones;

//constructors

	@PostConstruct
	public void init() {
		this.region = new Region();
		this.listaRegiones = new ArrayList<Region>();
		this.list();
	}

//metodos especializados

	public String newRegion() {
		this.setRegion(new Region());
		return "region.xhtml";
	}

	public void insert() {
		try {
			//regService.insert(region);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de región");
		}
	}

	public void list() {
		try {
			//listaRegiones = regService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de región");
		}
	}

	public void delete(Region re) {
		try {
			//regService.delete(re.getId());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de región");
		}
	}	

//get y setters
	
	public IRegionService getRegService() {
		return regService;
	}

	public void setRegService(IRegionService regService) {
		this.regService = regService;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Region> getListaRegiones() {
		return listaRegiones;
	}

	public void setListaRegiones(List<Region> listaRegiones) {
		this.listaRegiones = listaRegiones;
	}

}
