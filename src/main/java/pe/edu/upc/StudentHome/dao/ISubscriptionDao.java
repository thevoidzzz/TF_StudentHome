package pe.edu.upc.StudentHome.dao;

import java.util.List;


import pe.edu.upc.StudentHome.models.entities.Subscription;

public interface ISubscriptionDao {
    public void insert(Subscription sub);

    public List<Subscription> list();

    public void delete(int idSubscription);
    
    public List<Subscription> findByName(Subscription reg);
}