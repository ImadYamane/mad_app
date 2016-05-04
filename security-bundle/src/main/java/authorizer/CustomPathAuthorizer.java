package authorizer;

import org.picketlink.config.http.PathConfiguration;
import org.picketlink.http.authorization.PathAuthorizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */
public class CustomPathAuthorizer implements PathAuthorizer {

    //todo implement the authorization class
    @Override
    public boolean authorize(PathConfiguration pathConfiguration, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return true;
    }
}
