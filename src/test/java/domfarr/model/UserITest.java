package domfarr.model;

import com.qmetric.hamcrest.matchers.CollectionMatcher;
import domfarr.repository.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserITest
{
    @Autowired
    private UserService userService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void shouldPersistUser()
    {
        final User user = new User("Dom", "Farr", "dominicfarr@gmail.com");
        userService.saveOrUpdate(user);

        assertThat(user.getId(), notNullValue());
    }

    @Test
    public void shouldPersistUserWithPet()
    {
        final User user = new User("Dom", "Farr", "dominicfarr@gmail.com");

        user.addPet(new Pet("Tom", PetType.CAT, user));

        userService.saveOrUpdate(user);

        assertThat(user.getId(), notNullValue());

        assertThat(user.getPets().get(0), notNullValue());

        assertThat(user.getPets().get(0).getId(), notNullValue());
    }

    @Test
    public void shouldPersistUserAndThenAddPet()
    {
        final User user = new User("Dom", "Farr", "dominicfarr@gmail.com");

        userService.saveOrUpdate(user);

        sessionFactory.getCurrentSession().evict(user);

        user.addPet(new Pet("Tom", PetType.CAT, user));

        userService.saveOrUpdate(user);

        assertThat(user.getId(), notNullValue());

        assertThat(user.getPets().get(0), notNullValue());

        assertThat(user.getPets().get(0).getId(), notNullValue());
    }

    @Test
    public void shouldRetrieveUser()
    {
        final User user = new User("Dom", "Farr", "dominicfarr@gmail.com");

        user.addPet(new Pet("Tom", PetType.CAT, user));

        userService.saveOrUpdate(user);

        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().evict(user);

        final User loadedUser = userService.getUser(user.getId());

        assertThat(loadedUser, equalTo(user));
        assertThat(loadedUser.getPets(), CollectionMatcher.containsOnly(user.getPets()));
    }
}
