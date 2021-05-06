package pe.edu.upc.StudentHome.models.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id", nullable = false)
	private Integer id;

	@Column(name = "region_name", length = 20)
	private String name;

	@OneToMany(mappedBy = "region")
	private List<Province> provinces;
	
	//@OneToMany(mappedBy = "region")
	//private List<Apartment> apartments;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(Integer id, String name, List<Province> provinces) {
		super();
		this.id = id;
		this.name = name;
		this.provinces = provinces;
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

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Region other = (Region) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	// --Constructor, Getter y Setter

	

	
		
	

	
	

}