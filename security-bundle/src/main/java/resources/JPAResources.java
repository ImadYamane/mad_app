package resources;

import org.picketlink.annotations.PicketLink;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ImadYamane on 01/05/16.
 */

public class JPAResources {

    public enum REALM {acme, umbrella, wayne}

    /*
    * Since we are using JPAIdentityStore to store identity-related data, we must provide it with an EntityManager via a
    * producer method or field annotated with the @PicketLink qualifier.
    */
    @Produces
    @PicketLink
    @PersistenceContext(unitName = "picketlink-default")
    private EntityManager picketLinkEntityManager;

    @Produces
    @Named("supportedRealms")
    public Enum[] supportedRealms() {
        return REALM.values();
    }
}
