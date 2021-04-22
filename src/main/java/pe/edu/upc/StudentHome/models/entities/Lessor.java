package pe.edu.upc.StudentHome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "Lessors")
public class Lessor extends User{
	
	private User lessorID;	
	
	@Column(name = "license_id", columnDefinition = "NUMERIC(15)")
	private Integer licenseID;
	
	@OneToMany(mappedBy = "lessor", fetch = FetchType.LAZY)
	private List<Apartment> apartments;
	
	// --Constructor, Getter y Setter  
			public Lessor() {
				apartments = new ArrayList<Apartment>();
			}

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

			public List<Apartment> getApartments() {
				return apartments;
			}

			public void setApartments(List<Apartment> apartments) {
				this.apartments = apartments;
			}
			
			
}
