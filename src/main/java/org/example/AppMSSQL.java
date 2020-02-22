package org.example;

import org.example.enumerators.Pohlavie;
import org.example.model.Osoba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppMSSQL
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("nazovPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //vytvorenie entity managera, ktory je naviazany na nazov v persistenceMSSQL.xml
        //   pomocou persistanceUnitName

//        ZAPIS DO DB
        /*
        entityManager.getTransaction().begin();
        //zacinam transakciu

        entityManager.persist(new Message("Prva sprava"));
        //fakeovy zapis do databazy, realny az po commite
        entityManager.persist(new Message("Druha sprava"));
        //fakeovy zapis do databazy, realny az po commite

        entityManager.getTransaction().commit();
        //az po tomto prikaze sa realne ulozia hodnoty do databazy

        entityManager.close();
        //zatvorenie transakcie

*/

//      CITANIE Z DB
        /*
        entityManager.getTransaction().begin();
        List<Message> messageList =
                entityManager.createQuery("from Message",Message.class).getResultList();

        //vypis listu sprav
        for(Message msg:messageList)
        {
            System.out.println("id: "+msg.getId() +
                    "\nsprava: "+msg.getMessage() +
                    "\ndatumCas: "+msg.getCreateDate());
        }


        entityManager.getTransaction().commit();
        entityManager.close();
        //zatvorenie transakcie
         */

//       ZAPIS OSOBY DO DB
        entityManager.getTransaction().begin();
        entityManager.persist(new Osoba(Pohlavie.MUZ));
        entityManager.persist(new Osoba(Pohlavie.ZENA));
        entityManager.persist(new Osoba());
        entityManager.getTransaction().commit();
//        entityManager.close();

//       CITANIE OSOBY Z DB
        entityManager.getTransaction().begin();
        List<Osoba> messageList =
                entityManager.createQuery("from Osoba",Osoba.class).getResultList();

        //vypis listu sprav
        for(Osoba osoba:messageList)
        {
            System.out.println("id: "+osoba.getId() +
                    "\nsprava: "+osoba.getPohlavie());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
