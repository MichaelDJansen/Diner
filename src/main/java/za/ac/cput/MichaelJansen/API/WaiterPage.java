package za.ac.cput.MichaelJansen.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.MichaelJansen.Domain.Waiter;
import za.ac.cput.MichaelJansen.Model.WaiterResource;
import za.ac.cput.MichaelJansen.Service.WaiterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 18/09/2015.
 */
//@RestController
//@RequestMapping("/api/waiters/**")
public class WaiterPage {
/*
    @Autowired
    private WaiterService waiterService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String WaiterIndex()
    {
        return "View waiters";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<WaiterResource> getWaiters()
    {
        List<WaiterResource> hateoas = new ArrayList<WaiterResource>();
        List<Waiter> waiters = waiterService.getWaiters();

        for(Waiter waiter: waiters)
        {
            WaiterResource res = new WaiterResource
                    .Builder(waiter.getId(),waiter.getName(),waiter.getSurname(),waiter.getSalary())
                    .tip(waiter.getTip())
                    .build();

            Link allWaiters = new
                    Link("http://localhost:8181/api/waiters/all").
                    withRel("Waiters");

            res.add(allWaiters);
            hateoas.add(res);
        }

        return hateoas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WaiterResource getWaiter(@PathVariable Integer id)
    {
        WaiterResource hateoas;
        Waiter waiter = waiterService.getWaiter(id);

        WaiterResource res = new WaiterResource
                .Builder(waiter.getId(),waiter.getName(),waiter.getSurname(),waiter.getSalary())
                .tip(waiter.getTip())
                .build();

        Link waiters = new
                Link("http://localhost:8181/api/waiters/" + res.getWaiterId()).
                withRel("waiters");

        res.add(waiters);
        hateoas = res;

        return hateoas;
    }
*/
}
