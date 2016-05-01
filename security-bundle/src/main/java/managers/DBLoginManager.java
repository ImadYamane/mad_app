package managers;

import api.LoginAPI;
import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.DBLogin;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by ImadYamane on 29/04/16.
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
        //login user
         identity.login();
        //return result
        return identity.isLoggedIn();
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