package pe.edu.upc.StudentHome.models.entities;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Apartments")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apartment_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "apartment_description", length = 20)
	private String description;
	
	@Column(name = "apartment_price", columnDefinition = "DECIMAL(8,2)")
	private Float price;
	
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
	
}