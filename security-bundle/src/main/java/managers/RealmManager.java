package managers;

import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.model.basic.Realm;
import resources.JPAResources;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 04/05/16
 */
public class RealmManager  implements Serializable {

    @Inject
    private PartitionManager partitionManager;

    private Realm realm;

    @Produces
    @PicketLink
    public Realm select() {
        return this.realm;
    }

    public JPAResources.REALM getRealm() {
        if (this.realm == null) {
            return null;
        }

        return JPAResources.REALM.valueOf(this.realm.getName());
    }

    public void setRealm(JPAResources.REALM realm) {
        this.realm = this.partitionManager.getPartition(Realm.class, realm.name());
    }

}
