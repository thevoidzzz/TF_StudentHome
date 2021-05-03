package pe.edu.upc.StudentHome.models.entities;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
//@SequenceGenerator(name = "getRegion", initialValue = 1)
public class Region {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getRegion")
    @Column(name = "region_id", columnDefinition = "NUMERIC(4)")
    private Integer id;

    @Column(name = "region_name", length = 20)
    private String name;

    //@OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
        //private List<Province> provinces;

    public Region() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Region(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // --Constructor, Getter y Setter 
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

}