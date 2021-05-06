package pe.edu.upc.StudentHome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.models.entities.District;
import pe.edu.upc.StudentHome.models.entities.Province;
import pe.edu.upc.StudentHome.service.IDistrictService;
import pe.edu.upc.StudentHome.service.IProvinceService;

@Named
@RequestScoped
public class DistrictController {
	@Inject
	private IDistrictService dService;
	@Inject
	private IProvinceService pService;

//variables	
	private District district;
	List<District> listaDistritos;
	List<Province> listaProvincias;

	@PostConstruct
	public void init() {
		this.district = new District();
		this.listaDistritos = new ArrayList<District>();
		this.listaProvincias = new ArrayList<Province>();
		this.listDistrict();
		this.listProvince();
	}

	// metodos especificos

	public String newDistrict() {
		this.setDistrict(new District());
		return "district.xhtml";
	}

	public void insert() {
		try {
			dService.insert(district);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listDistrict() {
		try {
			listaDistritos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de distrito");
		}
	}

	public void delete(Province pr) {
		try {
			pService.delete(pr.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listProvince() {
		try {
			listaProvincias = pService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void findByName() {
		try {
			if(district.getName().isEmpty()) {
				this.listDistrict();
			}else {
				listaDistritos = this.dService.findByName(this.getDistrict());
			}
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller de región");
		}
	}
	
	public void clean() {
		this.init();
	}

	public IDistrictService getdService() {
		return dService;
	}

	public void setdService(IDistrictService dService) {
		this.dService = dService;
	}

	public IProvinceService getpService() {
		return pService;
	}

	public void setpService(IProvinceService pService) {
		this.pService = pService;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<District> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<District> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Province> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Province> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

}
