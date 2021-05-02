package pe.edu.upc.StudentHome.models.entities;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Subscriptions")
@SequenceGenerator(name = "getSubscription", initialValue = 1)
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getSubscription")
	@Column(name = "subscription_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "subscription_name", length = 50, nullable = false)
	private String subscriptionName;
	
	@Column(name = "subscription_description", length = 150, nullable = false)
	private String subscriptionDescription;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(Integer id, String subscriptionName, String subscriptionDescription) {
		super();
		this.id = id;
		this.subscriptionName = subscriptionName;
		this.subscriptionDescription = subscriptionDescription;
	}	
	
	//@ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
	//private List<User> users;
	
	// --Constructor, Getter y Setter  
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getSubscriptionDescription() {
		return subscriptionDescription;
	}

	public void setSubscriptionDescription(String subscriptionDescription) {
		this.subscriptionDescription = subscriptionDescription;
	}

	
	
}
