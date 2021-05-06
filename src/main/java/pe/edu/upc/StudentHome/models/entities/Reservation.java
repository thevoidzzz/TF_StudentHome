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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Reservations")
@SequenceGenerator(name = "getReservation", initialValue = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getReservation")
	@Column(name = "reservation_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	@Column(name = "reservation_description", length = 100)
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

	// --Constructor, Getter y Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public PaymentProof getPaymentProof() {
		return paymentProof;
	}

	public void setPaymentProof(PaymentProof paymentProof) {
		this.paymentProof = paymentProof;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

}