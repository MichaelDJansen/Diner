package za.ac.cput.MichaelJansen.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael on 16/09/2015.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index()
    {
        return "Welcome to the home page of the Diner App";
    }
}