package consumer;

import exaple.Sample;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.*;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.cdi.CDIFraction;
import org.wildfly.swarm.ejb.EJBFraction;
import org.wildfly.swarm.undertow.WARArchive;

import javax.inject.Inject;

/**
 * Created by wlw on 13.09.16.
 */

@RunWith(Arquillian.class)
public class SampleTest {

    @Deployment
    public static Archive createDeployment() throws Exception {
        WARArchive archive = ShrinkWrap.create(WARArchive.class, "SampleTest.war");
        archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        archive.addPackage("exaple");
        archive.addAllDependencies();
        return archive;
    }

    @Inject
    private Sample sample;

    @org.junit.Test
    public void testGet() throws Exception {
        Assert.assertEquals(this.sample.saySomething(), "something");
    }

}
