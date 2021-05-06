package pe.edu.upc.StudentHome.service;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Region;

public interface IRegionService {

    public void insert(Region reg);

    List<Region> list();

    public void delete(int idRegion);
    
    public List<Region> findByName(Region reg);
    
}    