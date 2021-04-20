package pe.edu.upc.StudentHome.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "subscription_name", length = 50, nullable = false)
	private String subscriptionName;
	
	@Column(name = "subscription_description", length = 150, nullable = false)
	private String subscriptionDescription;
	
	@ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
	private List<User> users;
}
