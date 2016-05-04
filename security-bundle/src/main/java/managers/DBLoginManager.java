package managers;

import api.LoginAPI;
import org.picketlink.Identity;
import org.picketlink.authentication.AuthenticationException;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.DBLogin;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */

@DBLogin
public class DBLoginManager implements LoginAPI {

    @Inject
    DefaultLoginCredentials loginCredentials;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private Identity identity;

    @Override
    public Boolean login() {
        try {
            //login user
            Identity.AuthenticationResult result =  identity.login();
            logger.warning("authenticate(String, String, String) - AuthenticationResult result=" + result);
            //return result
            return identity.isLoggedIn();
        } catch (AuthenticationException e) {
           return false;
        }
    }

    @Override
    public void logout() {
        identity.logout();
    }

    @Override
    public DefaultLoginCredentials getCredentials() {
        return loginCredentials;
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }
}
