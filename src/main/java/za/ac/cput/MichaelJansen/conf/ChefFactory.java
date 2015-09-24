package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Chef;
import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 07/09/2015.
 */
public class ChefFactory {
    public static Chef createChef(String name, String surname, Salary salary,String speciality){
        Chef chef = new Chef.Builder(name,surname,salary).speciality(speciality).build();
        return chef;
    }
}
