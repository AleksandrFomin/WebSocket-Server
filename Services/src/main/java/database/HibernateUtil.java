package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by sasha on 05.11.17.
 */
public class HibernateUtil {
    private static final EntityManagerFactory entityManagerFactory;
    static{
        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("serverdbUnit");
        } catch(Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
