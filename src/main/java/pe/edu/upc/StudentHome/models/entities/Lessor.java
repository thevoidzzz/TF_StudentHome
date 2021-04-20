package pe.edu.upc.StudentHome.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lessors")
public class Lessor {
	@Id
	@OneToOne(mappedBy = "lessor")	
	private User lessorID;	
	
	@Column(name = "license_id", columnDefinition = "NUMERIC(15)")
	private Integer licenseID;
	
	@OneToMany(mappedBy = "lessor", fetch = FetchType.LAZY)
	private List<Apartment> apartments;
}
