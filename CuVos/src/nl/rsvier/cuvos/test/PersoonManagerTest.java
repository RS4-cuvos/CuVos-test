package nl.rsvier.cuvos.test;

import nl.rsvier.cuvos.model.Persoon;

import nl.rsvier.cuvos.model.PersoonManager;
import java.util.Date;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//TODO: Add Javadoc comments
public class PersoonManagerTest extends TestCase
{
    private PersoonManager persoonManager = new PersoonManager();
	

    public static void main(String args[])
    {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite()
    {
        return new TestSuite(PersoonManagerTest.class);
    }

    public void testGetPersonen()
    {
        List personenlijst = persoonManager.getPersonen();
        assertNotNull(personenlijst);
        assertTrue(personenlijst.size() > 0);

        
        Persoon persoon;
        for (int i = 0; i < personenlijst.size(); i++)
        {
            persoon = (Persoon) personenlijst.get(i);

            System.out.println(">>>> persoonID = "
                    + persoon.getPersoonID());
	    
	    System.out.println(">>>> voornaam = "
                    + persoon.getVoornaam());
	    
        }
    }


    public void testDeletePersoon()
    {
        List personenlijst = persoonManager.getPersonen();
        if (personenlijst == null || personenlijst.size() < 1) return;
		System.out.println("Grootte vd lijst: " + personenlijst.size());
        Persoon persoonDelete = (Persoon) personenlijst.get(0);
	
        persoonManager.deletePersoon(persoonDelete);
        List personenlijstNaDelete = persoonManager.getPersonen();
        	
		System.out.println("Grootte vd lijst: " + personenlijstNaDelete.size());
        assertTrue(personenlijstNaDelete.size() == (personenlijst.size() - 1));
		  
		System.out.println("Nieuwe lijst is formaat oude lijst -1: " + personenlijstNaDelete.size()+ " = " + personenlijst.size() + " - 1");
	if (personenlijstNaDelete.size() > 0){
		for (int i = 0; i < personenlijstNaDelete.size(); i++){
        assertTrue(persoonDelete.getPersoonID() != ((Persoon)personenlijstNaDelete.get(i)).getPersoonID());
        	}
	}
    }

    public void testSavePersoon()
    {
         List personenlijst = persoonManager.getPersonen();
	Persoon savePersoon = new Persoon();
	savePersoon.setPersoonID( ((Persoon)personenlijst.get((personenlijst.size()-1)) ).getPersoonID() + 1);
	savePersoon.setVoornaam("NogIemand");
	System.out.println("savePersoon ID: " + savePersoon.getPersoonID() + ", voornaam: " + savePersoon.getVoornaam());
	persoonManager.savePersoon(savePersoon);
	 List personenlijstNaSave = persoonManager.getPersonen();

assertTrue(personenlijstNaSave.size() == (personenlijst.size() + 1));
		
		System.out.println("Nieuwe lijst is formaat oude lijst +1: " + personenlijstNaSave.size() + " = " + personenlijst.size() + " + 1");

	 Persoon persoon;
        for (int i = 0; i < personenlijstNaSave.size(); i++)
        {
           persoon = (Persoon) personenlijstNaSave.get(i);
            System.out.println(">>>> persoonID = "
                    + persoon.getPersoonID());
	    
	    System.out.println(">>>> voornaam = "
                    + persoon.getVoornaam());
	    
        }
// overwrite test
	savePersoon.setVoornaam("VeranderdeNaam");
	persoonManager.savePersoon(savePersoon);
List personenlijstNaOverWrite = persoonManager.getPersonen();
	int id = savePersoon.getPersoonID();
	Persoon databaseSavePersoon = null;
	for (int i = 0; i < personenlijstNaOverWrite.size(); i++){
		if ( ((Persoon)personenlijstNaOverWrite.get(i)).getPersoonID() == id){
		databaseSavePersoon = (Persoon) personenlijstNaOverWrite.get(i);
		}
	}

assertTrue(  databaseSavePersoon.getVoornaam().equals(savePersoon.getVoornaam())  );


	for (int i = 0; i < personenlijstNaOverWrite.size(); i++)
        {
           persoon = (Persoon) personenlijstNaOverWrite.get(i);
            System.out.println(">>>> persoonID = "
                    + persoon.getPersoonID());
	    
	    System.out.println(">>>> voornaam = "
                    + persoon.getVoornaam());
	    
        }
    }

     
}
