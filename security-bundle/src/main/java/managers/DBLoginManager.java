package managers;

import api.LoginAPI;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.DBLogin;

import javax.inject.Inject;

/**
 * Created by ImadYamane on 29/04/16.
 */

@DBLogin
public class DBLoginManager implements LoginAPI {

    @Inject
    DefaultLoginCredentials loginCredentials;

    @Override
    public Boolean login() {
        return false;
    }

    @Override
    public DefaultLoginCredentials getCredentials() {
        return loginCredentials;
    }
}
