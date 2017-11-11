package database;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sasha on 05.11.17.
 */
public class DBOperations {

    public boolean alreadyExists(String userName){
        EntityManager em=HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Query query=em.createQuery("select u from User u where login='"+userName+"'");
        em.getTransaction().commit();
        List list=query.getResultList();
        if(list.isEmpty())
            return false;
        else
            return true;
    }

    public void addUser(User user) {
        EntityManager em= HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

}
