package pe.edu.upc.StudentHome.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Apartments")
@SequenceGenerator(name = "getApartment", initialValue = 1)
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getApartment")
	@Column(name = "apartment_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "apartment_description", length = 20)
	private String apartmentDescription;
	
	@Column(name = "apartment_price", columnDefinition = "DECIMAL(8,2)")
	private Float apartmentPrice;
	
	@Column(name = "apartment_initial_date_publication")
	@Temporal(TemporalType.DATE)
	private Date initialDatePublication;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id", nullable = false)
	private District district;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lessor_id", nullable = false)
	private Lessor lessor;
	
	@OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
	private List<Reservation> reservations;	
	
	// --Constructor, Getter y Setter  
		public Apartment() {
			reservations = new ArrayList<Reservation>();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getApartmentDescription() {
			return apartmentDescription;
		}

		public void setApartmentDescription(String apartmentDescription) {
			this.apartmentDescription = apartmentDescription;
		}

		public Float getApartmentPrice() {
			return apartmentPrice;
		}

		public void setApartmentPrice(Float apartmentPrice) {
			this.apartmentPrice = apartmentPrice;
		}

		public Date getInitialDatePublication() {
			return initialDatePublication;
		}

		public void setInitialDatePublication(Date initialDatePublication) {
			this.initialDatePublication = initialDatePublication;
		}

		public District getDistrict() {
			return district;
		}

		public void setDistrict(District district) {
			this.district = district;
		}

		public Lessor getLessor() {
			return lessor;
		}

		public void setLessor(Lessor lessor) {
			this.lessor = lessor;
		}

		public List<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}

		
	
}