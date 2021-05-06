package pe.edu.upc.StudentHome.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.dao.IRegionDao;
import pe.edu.upc.StudentHome.models.entities.Region;
import pe.edu.upc.StudentHome.service.IRegionService;


@Named
@RequestScoped
public class RegionServiceImpl implements IRegionService {
    @Inject
    private IRegionDao regDao;

    @Override
    public void insert(Region reg) {
        regDao.insert(reg);
    }

    @Override
    public List<Region> list() {
        // TODO Auto-generated method stub
        return regDao.list();
    }

    @Override
    public void delete(int idRegion) {
        regDao.delete(idRegion);
    }
    
    @Override
	public List<Region> findByName(Region reg) {		
		return regDao.findByName(reg);
	}

}
