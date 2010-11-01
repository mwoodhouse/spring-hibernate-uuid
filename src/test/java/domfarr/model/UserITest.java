package domfarr.model;

import domfarr.repository.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
@TransactionConfiguration(defaultRollback = false)
public class UserITest {

    private static final List<Pet> PETS = asList(new Pet("Tom", PetType.CAT));

    @Autowired
    private UserService userService;

    @Test
    public void shouldBeAbleToUseEquals() {
        User originalUser = new User("Dom", "Farr", "dominicfarr@gmail.com", PETS);

        System.out.println("User just created: " + originalUser);
        System.out.println("User's Pet just created: " + StringUtils.collectionToCommaDelimitedString(originalUser.getPets()));

        userService.addUser(originalUser);

        System.out.println("User now saved: " + originalUser);
        System.out.println("User's Pets now saved: " + StringUtils.collectionToCommaDelimitedString(originalUser.getPets()));

        User retrievedUser = userService.getUser(originalUser.getId());

        System.out.println("User now retrieved: " + retrievedUser);
        System.out.println("User's Pets now retrieved: " + StringUtils.collectionToCommaDelimitedString(retrievedUser.getPets()));

        assertThat(retrievedUser, equalTo(originalUser));
    }
}
