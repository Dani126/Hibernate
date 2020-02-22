package org.example;

import org.example.enumerators.Pohlavie;
import org.example.model.Osoba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AppPostgre
{

    public List<Object[]> list;
    public Object[] objects;
//    //       Metoda na citanie objektu z databazy UIM
//    public List<Object[]> readUIMDB(String query) {
//        entityManagerUIM.getTransaction().begin();
//        List<Object[]> list =
//                entityManagerUIM.createNativeQuery(query).getResultList();
//        entityManagerUIM.getTransaction().commit();
//        entityManagerUIM.close();
//        return list;
//    }

    public static void main(String[] args)
    {
        List<Object[]> list;
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("nazovPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        list = entityManager.createNativeQuery("SELECT \"UserName\" FROM ids.\"Users\"").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        for(Object object:list)
        {
            System.out.println("User: "+object.toString()+"\n");
        }
    }

}
