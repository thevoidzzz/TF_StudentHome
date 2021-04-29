package pe.edu.upc.StudentHome.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
//import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PaymentProofs")
public class PaymentProof {
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getPaymentProof")
	
	//@OneToOne	
	//@Column(name = "payment_proof_id", columnDefinition = "NUMERIC(4)")
	@Id
	private Integer id;
	
	@Column(name = "payment_proof_initial_date")
	@Temporal(TemporalType.DATE)
	private Date paymentProofInitialDate;
	
	@Column(name = "payment_price", columnDefinition = "DECIMAL(8,2)")
	private Float paymentPrice;
	
	@OneToOne	
	@MapsId	
	@JoinColumn(name = "id", columnDefinition = "NUMERIC(4)")
	private Reservation reservation;
	
	// --Constructor, Getter y Setter  

	

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
