package pe.edu.upc.StudentHome.models.entities;

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
import javax.persistence.Table;

@Entity
@Table(name = "Districts")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id", nullable = false)
	private Integer id;

	@Column(name = "district_name", length = 20)
	private String name;

	@ManyToOne()
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;

	//@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	//private List<User> users;

	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Apartment> apartments;

	// --Constructor, Getter y Setter

	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(Integer id, String name, Province province, List<Apartment> apartments) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.apartments = apartments;
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

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartments == null) ? 0 : apartments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		District other = (District) obj;
		if (apartments == null) {
			if (other.apartments != null)
				return false;
		} else if (!apartments.equals(other.apartments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}

	

	

	
	

}
