package pe.edu.upc.StudentHome.service;

import java.util.List;


import pe.edu.upc.StudentHome.models.entities.Subscription;

public interface ISubscriptionService {

    public void insert(Subscription sub);

    List<Subscription> list();

    public void delete(int idSubscription);
    
    public List<Subscription> findByName(Subscription sub);
}
