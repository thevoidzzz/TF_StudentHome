package pe.edu.upc.StudentHome.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "reservation_description",length = 100)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;	

	@Column(name = "reservation_initial_date")
	@Temporal(TemporalType.DATE)
	private Date initialDate;

	@Column(name = "reservation_final_date")
	@Temporal(TemporalType.DATE)
	private Date finalDate;
	
	@OneToOne(mappedBy = "reservation")
	private PaymentProof paymentProof;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id", nullable = false)
	private Apartment apartment;
	
}