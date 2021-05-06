package pe.edu.upc.StudentHome.models.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Apartments")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apartment_id", nullable = false)
	private Integer id;

	@Column(name = "apartment_name", length = 50)
	private String apartmentName;

	@Column(name = "apartment_description", length = 150)
	private String apartmentDescription;

	@Column(name = "apartment_price")
	private String apartmentPrice;

	@Column(name = "apartment_initial_date_publication")	
	private String initialDatePublication;
	
	//@ManyToOne()
	//@JoinColumn(name = "region_id", nullable = false)
	//private Region region;

	//@ManyToOne()
	//@JoinColumn(name = "province_id", nullable = false)
	//private Province province;

	@ManyToOne()
	@JoinColumn(name = "district_id")
	private District district;

	// @ManyToOne()
	// @JoinColumn(name = "lessor_id", nullable = false)
	// private Lessor lessor;

	@OneToMany(mappedBy = "apartment")
	private List<Reservation> reservations;

	// --Constructor, Getter y Setter

	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(Integer id, String apartmentName, String apartmentDescription, String apartmentPrice,
			String initialDatePublication, District district, List<Reservation> reservations) {
		super();
		this.id = id;
		this.apartmentName = apartmentName;
		this.apartmentDescription = apartmentDescription;
		this.apartmentPrice = apartmentPrice;
		this.initialDatePublication = initialDatePublication;
		this.district = district;
		this.reservations = reservations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getApartmentDescription() {
		return apartmentDescription;
	}

	public void setApartmentDescription(String apartmentDescription) {
		this.apartmentDescription = apartmentDescription;
	}

	public String getApartmentPrice() {
		return apartmentPrice;
	}

	public void setApartmentPrice(String apartmentPrice) {
		this.apartmentPrice = apartmentPrice;
	}

	public String getInitialDatePublication() {
		return initialDatePublication;
	}

	public void setInitialDatePublication(String initialDatePublication) {
		this.initialDatePublication = initialDatePublication;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}	

	

	

}