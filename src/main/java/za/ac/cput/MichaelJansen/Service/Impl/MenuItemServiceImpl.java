package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Repository.MenuItemRepository;
import za.ac.cput.MichaelJansen.Service.MenuItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    MenuItemRepository repository;

    public List<MenuItem> getMenuItems(){

        List<MenuItem> allMenuItems = new ArrayList<MenuItem>();

        Iterable<MenuItem> menuItems = repository.findAll();
        for(MenuItem menuItem: menuItems)
        {
            allMenuItems.add(menuItem);
        }

        return allMenuItems;
    }

    public MenuItem getMenuItem(int id){
        MenuItem menuItem;

        menuItem = repository.findOne(id);

        return menuItem;
    }

    public List<MenuItem> getType(String type){
        List<MenuItem> allMenuItems = new ArrayList<MenuItem>();

        Iterable<MenuItem> menuItems = repository.findAll();
        for(MenuItem menuItem: menuItems)
        {
            if(menuItem.getType().equalsIgnoreCase(type))
                allMenuItems.add(menuItem);
        }

        return allMenuItems;
    }

    @Override
    public MenuItem findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public MenuItem save(MenuItem entity) {
        return repository.save(entity);
    }

    @Override
    public MenuItem update(MenuItem entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(MenuItem entity) {
        repository.delete(entity);

    }

    public Boolean isMenuItemExists(MenuItem menuItem){
        Boolean exists = false;

        Iterable<MenuItem> menuItems = repository.findAll();
        for(MenuItem temp: menuItems)
        {
            if(menuItem.getItemName().equalsIgnoreCase(temp.getItemName()))
            {
                exists = true;
                break;
            }
        }

        return exists;
    }
}
