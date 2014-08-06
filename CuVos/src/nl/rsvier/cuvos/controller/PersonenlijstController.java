package nl.rsvier.cuvos.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import nl.rsvier.cuvos.model.Persoon;
import nl.rsvier.cuvos.model.PersoonManager;


/**
 * Controller voor personenlijst scherm.
 * 
 */
public class PersonenlijstController implements Controller
{
    private PersoonManager persoonManager;
    public static final String MAP_KEY = "personen";
    private String successView;

    /**
     * Returns a list of Persoon database objects in ModelAndView.
     * @see nl.rsvier.cuvos.model.Persoon
     */
    public ModelAndView handleRequest(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
 
        List personen = persoonManager.getPersonen();
        
        return new ModelAndView(getSuccessView(), MAP_KEY, personen);
    }

    public PersoonManager getPersoonManager()
    {
        return persoonManager;
    }

    public void setPersoonManager(PersoonManager persoonManager)
    {
        this.persoonManager = persoonManager;
    }

    
    public String getSuccessView()
    {
        return successView;
    }

    public void setSuccessView(String successView)
    {
        this.successView = successView;
    }

   }
