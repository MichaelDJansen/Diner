package za.ac.cput.MichaelJansen.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Model.MenuItemResource;
import za.ac.cput.MichaelJansen.Service.MenuItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 18/09/2015.
 */
@RestController
@RequestMapping("/api/menuItems/**")
public class MenuItemPage {

    @Autowired
    private MenuItemService service;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String menuItemIndex()
    {
        return "View Menu";
    }



    //-------------------Retrieve All MenuItems--------------------------------------------------------

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<MenuItem>> listAllMenuItems() {
        List<MenuItem> menuItems = service.getMenuItems();
        if(menuItems.isEmpty()){
            return new ResponseEntity<List<MenuItem>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MenuItem>>(menuItems, HttpStatus.OK);
    }


    //-------------------Retrieve Single MenuItem--------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable("id") Integer id) {
        System.out.println("Fetching MenuItem with id " + id);
        MenuItem menuItem = service.findById(id);
        if (menuItem == null) {
            System.out.println("menuItem with id " + id + " not found");
            return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
    }



    //-------------------Create a MenuItem--------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createMenuItem(@RequestBody MenuItem menuItem,UriComponentsBuilder ucBuilder) {
        System.out.println("Creating MenuItem " + menuItem.getItemName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
      if (service.isMenuItemExists(menuItem)) {
            System.out.println("A MenuItem with name " + menuItem.getItemName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        service.save(menuItem);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/subject/{id}").buildAndExpand(menuItem.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a MenuItem --------------------------------------------------------

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable("id") Integer id, @RequestBody MenuItem menuItem) {
        System.out.println("Updating menuItem " + id);

        MenuItem currentMenuItem = service.findById(id);

        if (currentMenuItem==null) {
            System.out.println("MenuItem with id " + id + " not found");
            return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
        }

        MenuItem updatedMenuItem = new MenuItem
                .Builder()
                .copy(currentMenuItem)
                .build();
        service.update(updatedMenuItem);
        return new ResponseEntity<MenuItem>(updatedMenuItem, HttpStatus.OK);
    }

    //------------------- Delete a MenuItem --------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MenuItem> deleteMenuItem(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting menuItem with id " + id);

        MenuItem subject = service.findById(id);
        if (subject == null) {
            System.out.println("Unable to delete. MenuItem with id " + id + " not found");
            return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
        }

        service.delete(subject);
        return new ResponseEntity<MenuItem>(HttpStatus.NO_CONTENT);
    }
}