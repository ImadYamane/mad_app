package config;

import authorizer.CustomPathAuthorizer;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.PostLoggedOutEvent;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;
import org.picketlink.http.AuthenticationRequiredException;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.event.IdentityTypeCreatedEvent;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import java.util.logging.Logger;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */
public class HttpSecurityConfiguration {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @SuppressWarnings("unchecked")
    public void onInit(@Observes SecurityConfigurationEvent event) {
        SecurityConfigurationBuilder builder = event.getBuilder();
        //we create the builder :)
        builder
                .http()
                     .allPaths()
                        .authenticateWith()
                            .form() //use the form for authentication
                                .loginPage("/login") //login page
                                .errorPage("/error") //error page
                                .forPath("/assets/*") //allow style for login page
                                      .unprotected()
                                .forPath("/javax.faces.resource/*") //allow resources for login page like js
                                      .unprotected()
                                .forPath("/module/{identity.account.partition.name}/*")
                                    .authorizeWith()
                                    .authorizer(CustomPathAuthorizer.class)
                                    //.expression("#{identity.account.partition.name}")
                                   .redirectTo("/forbidden")
                                        .whenForbidden()
                                        .whenException(AuthenticationRequiredException.class)
                                        .whenError()
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

