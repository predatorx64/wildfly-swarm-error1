
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * Created by wlw on 13.09.16.
 */

@RunWith(Arquillian.class)
public class Test {

    @Deployment
    public static Archive createDeployment() throws Exception {
        WARArchive archive = ShrinkWrap.create(WARArchive.class, "Test.war");
        archive.addPackage("helper");
        return archive;
    }

    @org.junit.Test
    public void test() throws Exception {

        Assert.assertEquals(1,1);
    }

}
