package domfarr.model;

import domfarr.repository.CustomerService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class CustomerITest
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void shouldPersistCustomer()
    {
        final Customer customer = new Customer("Dom", "Farr", "dominicfarr@gmail.com");
        customerService.save(customer);

        assertThat(customer.getId(), notNullValue());
    }
}