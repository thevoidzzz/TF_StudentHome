package pe.edu.upc.StudentHome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student extends User{	
	
	private User user;	
	
	@Column(name = "college_code", length = 40, nullable = false)
	private Integer collegeCode;
	
	// GETTER Y SETTER

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(Integer collegeCode) {
		this.collegeCode = collegeCode;
	}
	
	
	
}