package managers;

import api.LoginAPI;
import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.LDAPLogin;

import javax.inject.Inject;

/**
 * Created by ImadYamane on 29/04/16.
 */

@LDAPLogin
public class LDAPLoginManager implements LoginAPI {

    @Inject
    DefaultLoginCredentials loginCredentials;

    @Override
    public Boolean login() {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public DefaultLoginCredentials getCredentials() {
        return loginCredentials;
    }

    @Override
    public Identity getIdentity() {
        return null;
    }
}
