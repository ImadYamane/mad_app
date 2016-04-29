package resources;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;

/**
 * Created by ImadYamane on 29/04/16.
 */
public class Resources {

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces
    public Logger produceLoggerContext() {
        return Logger.getLogger("MAD-APP-LOGGER");
    }

}