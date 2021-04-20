package pe.edu.upc.StudentHome.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "region_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "region_name", length = 20)
	private String name;
	
	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
	private List<Province> provinces;
}
