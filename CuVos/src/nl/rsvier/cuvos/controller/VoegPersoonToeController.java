 package nl.rsvier.cuvos.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import nl.rsvier.cuvos.model.Persoon;
import nl.rsvier.cuvos.model.PersoonManager;

/**
 * Controller klasse voor voegpersoontoe-scherm
 * 
 */
public class VoegPersoonToeController extends SimpleFormController
{
    private PersoonManager persoonManager = null;

    /**
     * Returns a new instance of Persoon object  
     * @see nl.rsvier.cuvos.Persoon
     */
    protected Object formBackingObject(HttpServletRequest request)
    {
	return new Persoon();
    }

    /**
     * For registering custom property editors (p. 149)
     */
    protected void initBinder(
            HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception
    {
    }

    /**
     * Returns Hashmap containing a list of all Department databse records (ook p.149)
     * @see com.visualpatterns.timex.model.Department
     */
   // protected Map referenceData(HttpServletRequest request) throws Exception
    {
    }

    /**
     * Saves Persoon command object using 
     * persoonManager.savePersoon(persoon);
     * @see PersoonManager
     */
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors)
    {
        Persoon persoon = (Persoon) command;
        persoonManager.savePersoon(persoon);
        
        return new ModelAndView(getSuccessView());
    }

    public PersoonManager getPersoonManager()
    {
        return persoonManager;
    }

    public void setPersoonManager(PersoonManager persoonManager)
    {
        this.persoonManager = persoonManager;
    }

}
