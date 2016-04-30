package managers;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by ImadYamane on 29/04/16.
 */
@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {
        IdentityManager identityManager = this.partitionManager.createIdentityManager();

        User user = new User("imad");

        user.setEmail("imad@doe.com");
        user.setFirstName("imad");
        user.setLastName("imad");

        identityManager.add(user);
        identityManager.updateCredential(user, new Password("123456"));

    }
}
