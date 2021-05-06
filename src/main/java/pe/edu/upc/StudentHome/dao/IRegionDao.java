package pe.edu.upc.StudentHome.dao;

import java.util.List;

import pe.edu.upc.StudentHome.models.entities.Region;

public interface IRegionDao {
    public void insert(Region reg);

    public List<Region> list();

    public void delete(int idRegion);
    
    public List<Region> findByName(Region reg);
}