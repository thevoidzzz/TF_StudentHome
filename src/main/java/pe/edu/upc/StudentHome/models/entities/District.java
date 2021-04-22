package pe.edu.upc.StudentHome.models.entities;

import java.util.ArrayList;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Districts")
@SequenceGenerator(name = "getDistrict", initialValue = 1)
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getDistrict")
	@Column(name = "district_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "district_name", length = 20)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<User> users;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Apartment> apartments;
	
	// --Constructor, Getter y Setter  
			public District() {
				users = new ArrayList<User>();
				apartments = new ArrayList<Apartment>();
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Province getProvince() {
				return province;
			}

			public void setProvince(Province province) {
				this.province = province;
			}

			public List<User> getUsers() {
				return users;
			}

			public void setUsers(List<User> users) {
				this.users = users;
			}

			public List<Apartment> getApartments() {
				return apartments;
			}

			public void setApartments(List<Apartment> apartments) {
				this.apartments = apartments;
			}
			
			
}
