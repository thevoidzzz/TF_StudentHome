package pe.edu.upc.StudentHome.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lessors")
public class Lessor extends User {

	@OneToOne(mappedBy = "lessor")
	private User lessorID;

	@Column(name = "license_id", columnDefinition = "NUMERIC(15)")
	private Integer licenseID;

	// @OneToMany(mappedBy = "lessor", fetch = FetchType.LAZY)
	// private List<Apartment> apartments;

	// --Constructor, Getter y Setter

	public User getLessorID() {
		return lessorID;
	}

	public void setLessorID(User lessorID) {
		this.lessorID = lessorID;
	}

	public Integer getLicenseID() {
		return licenseID;
	}

	public void setLicenseID(Integer licenseID) {
		this.licenseID = licenseID;
	}

}
