package domfarr.model;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserTest {
    private static final User EXPECTED_UESR = new User("firstName", "lastName", "email@address.com");

    @Test
    public void shouldNotHaveToTestEachField() {
        User user = new User("firstName", "lastName", "email@address.com");

        assertThat(user, equalTo(EXPECTED_UESR));
    }
}
