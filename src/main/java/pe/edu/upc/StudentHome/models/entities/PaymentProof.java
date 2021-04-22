package pe.edu.upc.StudentHome.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PaymentProofs")
@SequenceGenerator(name = "getPaymentProof", initialValue = 1)
public class PaymentProof {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getPaymentProof")
	@Column(name = "payment_proof_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "payment_proof_initial_date")
	@Temporal(TemporalType.DATE)
	private Date paymentProofInitialDate;
	
	@OneToOne	
	//@MapsId
	@JoinColumn(name = "payment_proof_id")
	private Reservation reservation;
	
	// --Constructor, Getter y Setter  

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaymentProofInitialDate() {
		return paymentProofInitialDate;
	}

	public void setPaymentProofInitialDate(Date paymentProofInitialDate) {
		this.paymentProofInitialDate = paymentProofInitialDate;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
			
	
}
