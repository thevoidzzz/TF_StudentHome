package pe.edu.upc.StudentHome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student extends User{	
	
	@OneToOne(mappedBy = "student")
	private User studentId;	
	
	@Column(name = "college_code", length = 40, nullable = false)
	private Integer collegeCode;
	
	
	// GETTER Y SETTER

	public User getStudentId() {
		return studentId;
	}

	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}

	public Integer getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(Integer collegeCode) {
		this.collegeCode = collegeCode;
	}
	
	
	
}