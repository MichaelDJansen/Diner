package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Manager;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Shift;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 08/09/2015.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestManagerRepository extends AbstractTestNGSpringContextTests {

    int id;

    @Autowired
    private ManagerRepository repository;

    Manager manager;

    String name;
    String surname;
    Salary salary;

    private String password = "Noodlez";

    //@Test
    public void create() throws Exception
    {

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        password = "Noodles";

        manager = new Manager.Builder(name,surname,salary,password).build();

        repository.save(manager);
        id = manager.getId();

        Assert.assertNotNull(manager.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Manager manager1 = repository.findOne(id);

        Assert.assertEquals(id, manager1.getId());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Manager newManager = new Manager.Builder("Layton",surname,salary,password).build();

        repository.save(newManager);
        id = newManager.getId();
        Manager updatedManager = repository.findOne(id);

        Assert.assertEquals(id, updatedManager.getId());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Manager manager2 = repository.findOne(id);
        repository.delete(manager2);
        Manager newerManager = repository.findOne(id);
        Assert.assertNull(newerManager);
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
