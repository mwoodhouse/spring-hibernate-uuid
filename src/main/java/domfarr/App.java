package domfarr;

import domfarr.model.Pet;
import domfarr.model.User;
import domfarr.repository.UserService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class App
{
    private final UserService userService;

    public App() {
        this.userService = null;
    }

    public App(final UserService userService)
    {
        this.userService = userService;
    }

    public void printUserById(final String id)
    {
        final User user = userService.getUser(id);
        System.out.println(user);
        System.out.println(user.getPets());
    }

    public void add(final Pet pet)
    {
        pet.getOwner().addPet(pet);

        userService.saveOrUpdate(pet.getOwner());
    }

    public void saveOrUpdate(final User user)
    {
        userService.saveOrUpdate(user);
    }
}
