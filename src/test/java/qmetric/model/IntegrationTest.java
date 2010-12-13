package qmetric.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import qmetric.repository.CustomerService;
import qmetric.repository.EnquiryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class IntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EnquiryService enquiryService;

    @Test
    public void create()
    {
        Customer customer = new Customer("dom", "farr", "dominicfarr@gmail.com");

        customerService.save(customer);

        System.out.println(customer);

        InsuranceEnquiry enquiry = new InsuranceEnquiry("enquiry 1");

        enquiryService.save(enquiry);

        System.out.println(enquiry);

        customer.addInsuranceEnquiry(enquiry);

        customerService.save(customer);

        System.out.println(customer);

        customerService.remove(customer);
    }
}