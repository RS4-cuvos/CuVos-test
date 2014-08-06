package nl.rsvier.cuvos.model;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import nl.rsvier.cuvos.util.HibernateUtil;

/**
 * Manages database operations for Persoon table.
 * 
 */
public class PersoonManager //throws HibernateException ??
{
    /**
     * Returns list of all Persoon objects in database
     */
    public List getPersonen()
    {
        List personenlijst = null;

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        try
        {
            personenlijst = session.createQuery(
                    "from Persoon").list();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return personenlijst;
    }

    /**
     * Geeft een lijst met alle personen van het gegeven type uit de database.
     *
    *public List<Persoon> getPersonenOpType(char discriminatorValue)
    *{
*	List<Persoon> personenlijst = new List<Persoon>();
*	return personenlijst;
 *   }
*/
    /**
     * Saves a Persoon object.
     * Ook voor het opslaan van aanpassingen	
     */
    public void savePersoon(Persoon persoon)
    {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(persoon);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }

     /**
     * Deletes a Persoon object from de database.	
     */
    public void deletePersoon(Persoon persoon)
    {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        try
        {
            session.delete(persoon);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }    

}
