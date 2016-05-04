package service;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;
import static org.picketlink.idm.model.basic.BasicModel.grantRole;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */

@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {
        // Create user john
        User superuser = new User("superuser");
        superuser.setEmail("imad@imad.com");
        superuser.setFirstName("Superuser");
        IdentityManager identityManager = this.partitionManager.createIdentityManager();
        //create superuser
        identityManager.add(superuser);
        identityManager.updateCredential(superuser, new Password("password"));
        // Create application role "superuser"
        Role superuserRole = new Role("superuser");
        identityManager.add(superuserRole);
        // Create role "manager"
        Role manager = new Role("manager");
        identityManager.add(manager);
        // Create application role "superuser"
        Role user = new Role("user");
        identityManager.add(user);
        //init relationship manager
        RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();
        // Grant the "superuser" application role to jane
        grantRole(relationshipManager, superuser, superuserRole);
    }
}
