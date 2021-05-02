package pe.edu.upc.StudentHome.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.StudentHome.dao.ISubscriptionDao;
import pe.edu.upc.StudentHome.models.entities.Subscription;
import pe.edu.upc.StudentHome.service.ISubscriptionService;

@Named
@RequestScoped
public class SubscriptionServiceImpl implements ISubscriptionService{
    @Inject
    private ISubscriptionDao subDao;

    @Override
    public void insert(Subscription sub) {
        subDao.insert(sub);
    }

    @Override
    public List<Subscription> list() {
        // TODO Auto-generated method stub
        return subDao.list();
    }

    @Override
    public void delete(int idSubscription) {
        subDao.delete(idSubscription);
    }
}
