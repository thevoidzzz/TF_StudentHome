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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PaymentProofs")
public class PaymentProof {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_proof_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "payment_proof_initial_date")
	@Temporal(TemporalType.DATE)
	private Date paymentProofInitialDate;
	
	@OneToOne	
	//@MapsId
	@JoinColumn(name = "payment_proof_id")
	private Reservation reservation;
	
}
