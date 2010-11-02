package domfarr.model;

import domfarr.repository.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class UserITest {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void shouldBeAbleToUseEquals() {
        User originalUser = createUser();

        save(originalUser, "Save User");

        add(new Pet("Tom", PetType.CAT, originalUser), originalUser);

        save(originalUser, "Save With Pet");

        sessionFactory.evict(User.class);

        User retrievedUser = retrieve(originalUser);

        assertThat(retrievedUser, equalTo(originalUser));
    }

    private User retrieve(final User originalUser)
    {
        User retrievedUser = userService.getUser(originalUser.getId());

        printInfo(originalUser, "Retrieve");

        return retrievedUser;
    }

    private User createUser()
    {
        User originalUser = new User("Dom", "Farr", "dominicfarr@gmail.com");

        printInfo(originalUser, "Before add");

        return originalUser;
    }

    private void save(final User user, final String title)
    {
        userService.save(user);

        printInfo(user, title);
    }

    private void add(final Pet pet, final User user)
    {
        user.addPet(pet);

        printInfo(user, "Add pet");
    }

    private void printInfo(final User user, String title)
    {
        System.out.println(title);
        System.out.println("User: " + user);
        System.out.println("User's Pets: " + StringUtils.collectionToCommaDelimitedString(user.getPets()) + "\n");
    }
}
