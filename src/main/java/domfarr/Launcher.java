package domfarr;

import domfarr.model.Pet;
import domfarr.model.PetType;
import domfarr.model.User;
import domfarr.repository.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Launcher
{
    private static final List<Pet> PETS = asList(new Pet("Tom", PetType.CAT));

    public static void main(String[] args)
    {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");

//        UserService userService = (UserService) ctx.getBean("userService");


//       User originalUser = new User("Dom", "Farr", "dominicfarr@gmail.com", PETS);

//        System.out.println("User just created: " + originalUser);
//        System.out.println("User's Pet just created: " + StringUtils.collectionToCommaDelimitedString(originalUser.getPets()));

//        userService.addUser(originalUser);

//        System.out.println("User now saved: " + originalUser);
//        System.out.println("User's Pets now saved: " + StringUtils.collectionToCommaDelimitedString(originalUser.getPets()));

//        User retrievedUser = userService.getUser("402882ba2c088f20012c088f21780001");

//        System.out.println("User now retrieved: " + retrievedUser);
//        System.out.println("User's Pets now retrieved: " + StringUtils.collectionToCommaDelimitedString(retrievedUser.getPets()));


    }
}
