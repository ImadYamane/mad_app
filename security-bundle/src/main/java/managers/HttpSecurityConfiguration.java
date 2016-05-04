package managers;

import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.PostLoggedOutEvent;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.event.IdentityTypeCreatedEvent;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
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

    /**
     * This method uses the IdentityConfigurationBuilder to create an IdentityConfiguration, which
     * defines how PicketLink stores identity-related data.  In this particular example, a
     * JPAIdentityStore is configured to allow the identity data to be stored in a relational database
     * using JPA.
     */
    @Produces
    IdentityConfiguration produceIdentityManagementConfiguration() {
        IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();

        builder
                .named("default")
                .stores()
                .jpa()
                // Specify that this identity store configuration supports all features
                .supportAllFeatures();

        return builder.build();
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

