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
@Table(name = "Provinces")
@SequenceGenerator(name = "getProvince", initialValue = 1)
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getProvince")
	@Column(name = "province_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "province_name", length = 20)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<District> districts;
	
	// --Constructor, Getter y Setter  
	public Province() {
		districts = new ArrayList<District>();
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	
}
