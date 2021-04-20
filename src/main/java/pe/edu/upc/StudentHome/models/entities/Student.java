package pe.edu.upc.StudentHome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
	
	@Id
	@OneToOne(mappedBy = "student")	
	private User user;	
	
	@Column(name = "college_code", length = 40, nullable = false)
	private Integer collegeCode;
	
}