package pe.edu.upc.StudentHome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.models.entities.Subscription;
import pe.edu.upc.StudentHome.service.ISubscriptionService;

@Named
@RequestScoped
public class SubscriptionController {
	@Inject
	private ISubscriptionService subscService;

//variables	
	private Subscription subscription;

	List<Subscription> listaSuscripciones;

//constructors

	@PostConstruct
	public void init() {
		this.subscription = new Subscription();
		this.listaSuscripciones = new ArrayList<Subscription>();
		this.list();
	}

//metodos especializados

	public String newSubscription() {
		this.setSubscription(new Subscription());
		return "subscription.xhtml";
	}

	public void insert() {
		try {
			subscService.insert(subscription);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de suscripción");
		}
	}

	public void list() {
		try {
			listaSuscripciones = subscService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de suscripción");
		}
	}
	
	public void delete(Subscription su) {
		try {
			subscService.delete(su.getId());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de suscripción");
		}
	}	
	
	public void findByName() {
		try {
			if(subscription.getSubscriptionName().isEmpty()) {
				this.list();
			}else {
				listaSuscripciones = this.subscService.findByName(this.getSubscription());
			}
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller de región");
		}
	}
	
	public void clean() {
		this.init();
	}

//get y setters
	
	public ISubscriptionService getSubscService() {
		return subscService;
	}

	public void setSubscService(ISubscriptionService subscService) {
		this.subscService = subscService;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public List<Subscription> getListaSuscripciones() {
		return listaSuscripciones;
	}

	public void setListaSuscripciones(List<Subscription> listaSuscripciones) {
		this.listaSuscripciones = listaSuscripciones;
	}
	
	
	
}
