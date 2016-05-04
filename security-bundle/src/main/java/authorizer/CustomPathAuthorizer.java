package authorizer;

import org.picketlink.config.http.PathConfiguration;
import org.picketlink.http.authorization.PathAuthorizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */
public class CustomPathAuthorizer implements PathAuthorizer {

   Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean authorize(PathConfiguration pathConfiguration, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        try {
            System.out.println("-<-<-<>" + pathConfiguration.getUri());
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return true;
    }
}
