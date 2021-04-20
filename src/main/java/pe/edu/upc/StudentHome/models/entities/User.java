package pe.edu.upc.StudentHome.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	// EmbeddedId primary key
	@Id
	private Integer id;
	
	@Column(name = "user_first_name", length = 20)
	private String firstName;
	
	@Column(name = "user_last_name", length = 20)
	private String lastName;

	@Column(name = "user_dni", length = 8)
	private String dni;
	
	@Column(name = "user_phone", length = 12)
	private String phone;
	
	@Column(name = "user_email", length = 30)
	private String email;
	
	@Column(name = "user_password", length = 20)
	private String password;
	
	@Column(name = "user_address", length = 30)
	private String address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id", nullable = false)
	private District district;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reservation> reservations;		
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_subscriptions",
			joinColumns = { @JoinColumn(referencedColumnName = "id", name = "user_id")},
			inverseJoinColumns = { @JoinColumn(referencedColumnName = "subscription_id", name = "subscription_id")})
	private List<Subscription> subscriptions;		
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "lessor_id")
	private Lessor lessor;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "student_id")
	private Student student;
}
