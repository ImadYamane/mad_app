package managers;

import api.LoginAPI;
import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.LDAPLogin;

import javax.inject.Inject;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
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
