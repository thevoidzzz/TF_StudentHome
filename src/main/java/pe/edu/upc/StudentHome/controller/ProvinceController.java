package pe.edu.upc.StudentHome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.models.entities.Province;
import pe.edu.upc.StudentHome.models.entities.Region;
import pe.edu.upc.StudentHome.service.IProvinceService;
import pe.edu.upc.StudentHome.service.IRegionService;

@Named
@RequestScoped
public class ProvinceController {
	@Inject
	private IProvinceService pService;
	@Inject
	private IRegionService rService;

//variables	
	private Province province;
	List<Province> listaProvincias;
	List<Region> listaRegiones;
	

	@PostConstruct
	public void init() {
		this.province = new Province();
		this.listaProvincias = new ArrayList<Province>();
		this.listaRegiones = new ArrayList<Region>();
		this.listProvince();
		this.listRegion();
	}
	
	//metodos especificos
	
	public String newProvince() {
		this.setProvince(new Province());
		return "province.xhtml";
	}
	
	public void insert() {
		try {
			pService.insert(province);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listProvince() {
		try {
			listaProvincias = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de province");
		}
	}
	
	public void delete(Province pr) {
		try {
			pService.delete(pr.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listRegion() {
		try {
			listaRegiones = rService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void findByName() {
		try {
			if(province.getName().isEmpty()) {
				this.listProvince();
			}else {
				listaProvincias = this.pService.findByName(this.getProvince());
			}
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller de región");
		}
	}
	
	public void clean() {
		this.init();
	}

	public IProvinceService getpService() {
		return pService;
	}

	public void setpService(IProvinceService pService) {
		this.pService = pService;
	}

	public IRegionService getrService() {
		return rService;
	}

	public void setrService(IRegionService rService) {
		this.rService = rService;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Province> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Province> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<Region> getListaRegiones() {
		return listaRegiones;
	}

	public void setListaRegiones(List<Region> listaRegiones) {
		this.listaRegiones = listaRegiones;
	}
	
	
	
	
}
