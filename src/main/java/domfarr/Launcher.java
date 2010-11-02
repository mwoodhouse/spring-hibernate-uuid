package domfarr;

import domfarr.model.Pet;
import domfarr.model.PetType;
import domfarr.model.User;
import domfarr.repository.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Launcher
{
    private UserService userService;

    public static void main(String[] args)
    {
        App app = (App) new ClassPathXmlApplicationContext("spring/spring-context.xml").getBean("app");

        User user = new User("Dom", "Farr", "df@df.com");

        app.saveOrUpdate(user);

        user.addPet(new Pet("Tom", PetType.CAT, user));

        app.saveOrUpdate(user);

        app.printUserById(user.getId());
    }

}
