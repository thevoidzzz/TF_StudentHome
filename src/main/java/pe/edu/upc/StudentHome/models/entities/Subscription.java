package pe.edu.upc.StudentHome.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id", nullable = false)
	private Integer id;

	@Column(name = "subscription_name", length = 50, nullable = false)
	private String subscriptionName;

	@Column(name = "subscription_description", length = 150, nullable = false)
	private String subscriptionDescription;

	// @ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
	// private List<User> users;

	// --Constructor, Getter y Setter

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