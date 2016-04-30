package managers;

import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.PostLoggedOutEvent;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;
import org.picketlink.idm.event.IdentityTypeCreatedEvent;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * Created by ImadYamane on 29/04/16.
 */
public class HttpSecurityConfiguration {

    Logger logger = Logger.getLogger(this.getClass().getName());


    public void onInit(@Observes SecurityConfigurationEvent event) {
        SecurityConfigurationBuilder builder = event.getBuilder();

        builder
                .http()
                .allPaths()
                .authenticateWith()
                     .form()
                         .loginPage("/login")
                         .errorPage("/error")
                .forPath("/assets/*")
                    .unprotected()
                .forPath("/javax.faces.resource/*")
                    .unprotected()
                .forPath("/logout")
                     .logout()
                     .redirectTo("/home");
    }

    public void onPre(@Observes LoggedInEvent event) {
        logger.info("User login");
    }

    public void onPre(@Observes PostLoggedOutEvent event) {
        logger.info("User logout");
    }

    public void onPre(@Observes IdentityTypeCreatedEvent event) {
        logger.info("IdentityType created");
    }
}

