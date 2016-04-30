package api;

import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;

/**
 * Created by ImadYamane on 29/04/16.
 */
public interface LoginAPI {
    Boolean login();
    void logout();
    DefaultLoginCredentials getCredentials();
    Identity getIdentity();
}
