package nl.rsvier.cuvos.test;

import java.util.List;

import nl.rsvier.cuvos.model.Persoon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



//TODO: Add Javadoc comments
public class HibernateTest
{
    public static void main(String args[]) throws Exception
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession(); // changed to
        // openSession
        Transaction tx = session.beginTransaction();
        Persoon persoon;

        // Demo 1: Get single record
       persoon = (Persoon) session.get(Persoon.class, 1);
        System.out.println("dit is " + persoon.getVoornaam());
        
       persoon.setVoornaam("Thomas");

       //Demo 2: Get all records
        List<?> pList = session.createQuery("from Persoon").list();
        for (int i = 0; i < pList.size(); i++)
        {
            persoon = (Persoon) pList.get(i);
            System.out.println("Row " + (i + 1) + "> " + persoon.getVoornaam()
                    + " (" + persoon.getPersoonID() + ")");
        }

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
