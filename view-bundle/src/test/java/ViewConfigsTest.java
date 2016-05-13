import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * author.name: Imad Yamane
 * author.email: contact@imadyamane.de
 * author.website: //imadyamane.de
 * date: 12/05/16
 */

@RunWith(Arquillian.class)
public class ViewConfigsTest {

    @Deployment
    public static Archive<?> createDeployment(){
        return ShrinkWrap.create(JavaArchive.class);
               // .addPackages(true, "");
         //.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testFun() {
        Assert.assertEquals(1, 1);
    }

}
